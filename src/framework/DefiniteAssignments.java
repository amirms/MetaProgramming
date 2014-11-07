package framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import framework.ast.Assignment;
import framework.ast.Element;
import framework.ast.ProcedureCall;
import framework.ast.Program;

/**
 * Created by Rogier on 02-11-14.
 */
public class DefiniteAssignments extends Analysis {

	protected Collection<AnalysisResult> assignments = new ArrayList<>();

	public DefiniteAssignments(List<Flow> cfg) {
		super(cfg, AnalysisDirection.FORWARDS);
	}

	@Override
	public Collection<AnalysisResult> kill(Element e) {
		return new HashSet<>();
	}

	@Override
	public Collection<AnalysisResult> gen(Element e) {
		Collection<AnalysisResult> res = new HashSet<>();
		if (e instanceof Assignment) {
			res.add(new DefiniteAssignmentsResult(((Assignment) e).id, e.getLabel()));
		} else if ( e instanceof ProcedureCall) {
			res.add(new DefiniteAssignmentsResult(((ProcedureCall)e).returnVal,e.getLabel()));
		}
		assignments.addAll(res);
		return res;
	}

	@Override
	public Collection<AnalysisResult> entry(Element e, int i) {
		if (e.equals(Program.START)) {
			return new HashSet<>();
		}
		if ( e.getLabel() == 8 ) {
			System.err.println("found the bitch");
		}
		// Error is it requires the join. However if something is defined before the loop it should not consider the stuff in the loop
		Set<AnalysisResult> res = new TreeSet<>(assignments);
		for (Element workElement : getAllNodesWithDirection(e, AnalysisDirection.BACKWARDS)) {
			// check if workElement will ultimately depend on e again. If so, ignore
			if ( hasCircularDependency(e,workElement,this.cfg.size())) {
				continue;
			}
			Collection<AnalysisResult> x = this.exitTable.get(new IterationElement(i, workElement));
			if (x == null) {
				x = new HashSet<>();
			}
			res.retainAll(x);
		}
		this.entryTable.put(new IterationElement(i, e), res);
		return res;
	}

	@Override
	public Collection<AnalysisResult> exit(Element e, int i) {
		if (e.equals(Program.START)) {
			return new HashSet<>();
		}
		Collection<AnalysisResult> res = this.entryTable.get(new IterationElement(i , e));
		if (res == null) {
			res = entry(e, i);
		}
		res.addAll(gen(e));
		for (AnalysisResult ar : kill(e)) {
			res.remove(ar);
		}
		res = new TreeSet<>(res);
		this.exitTable.put(new IterationElement(i, e), res);
		return res;
	}

	private boolean hasCircularDependency(Element first, Element dependee, int remaining ) {
		if ( remaining <= 0) {
			return false;
		}
		if ( first.equals(dependee) ) {
			return true;
		}
		for( Element e : getAllNodesWithDirection(dependee, AnalysisDirection.BACKWARDS)) {
			if ( hasCircularDependency(first,e,remaining-1)) {
				return true;
			}
		}
		return false;
	}
}
