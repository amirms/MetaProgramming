package framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import framework.ast.Assignment;
import framework.ast.Element;
import framework.ast.ID;
import framework.ast.ProcedureCall;
import framework.ast.Program;

/**
 * Created by Rogier on 02-11-14.
 */
public class ReachingDefinitions extends Analysis {

	protected Map<ID, List<Integer>> assignments = new HashMap<>();

	public ReachingDefinitions(List<Flow> cfg) {
		super(cfg, AnalysisDirection.FORWARDS);
	}

	@Override
	public Collection<AnalysisResult> kill(Element e) {
		Set<AnalysisResult> res = new HashSet<>();
		if (e instanceof Assignment) {
			ID id = ((Assignment) e).id;
			res.add(new ReachingDefinitionsResult(id, -1));
			if (assignments.containsKey(id)) {
				for (Integer i : assignments.get(id)) {
					res.add(new ReachingDefinitionsResult(id, i));
				}
			}
		}
		else if (e instanceof ProcedureCall) {
			ID id = ((ProcedureCall) e).returnVal;
			res.add(new ReachingDefinitionsResult(id, -1));
			if (assignments.containsKey(id)) {
				for (Integer i : assignments.get(id)) {
					res.add(new ReachingDefinitionsResult(id, i));
				}
			}
		}
		return res;
	}

	@Override
	public Collection<AnalysisResult> gen(Element e) {
		Set<AnalysisResult> res = new HashSet<>();
		if (e instanceof Assignment) {
			ID id = ((Assignment) e).id;
			res.add(new ReachingDefinitionsResult(id, e.getLabel()));
			if (assignments.containsKey(id)) {
				assignments.get(id).add(e.getLabel());
			}
			else {
				List<Integer> i = new ArrayList<>(1);
				i.add(e.getLabel());
				assignments.put(id, i);
			}
		}
		else if (e instanceof ProcedureCall) {
			ID id = ((ProcedureCall) e).returnVal;
			res.add(new ReachingDefinitionsResult(id, e.getLabel()));
			if (assignments.containsKey(id)) {
				assignments.get(id).add(e.getLabel());
			}
			else {
				List<Integer> i = new ArrayList<>(1);
				i.add(e.getLabel());
				assignments.put(id, i);
			}
		}
		return res;
	}

	@Override
	public Collection<AnalysisResult> entry(Element e, int i) {
		if (e.equals(Program.START)) {
			return new HashSet<>();
		}
		Set<AnalysisResult> res = new TreeSet<>();
		for (Element workElement : getAllNodesWithDirection(e, AnalysisDirection.BACKWARDS)) {
			Collection<AnalysisResult> x = this.exitTable.get(new IterationElement(i, workElement));
			if (x == null) {
				x = new HashSet<>();
			}
			res.addAll(x);
		}
		this.entryTable.put(new IterationElement(i, e), res);
		return res;
	}

	@Override
	public Collection<AnalysisResult> exit(Element e, int i) {
		if (e.equals(Program.START)) {
			return new HashSet<>();
		}
		Collection<AnalysisResult> res = this.entryTable.get(new IterationElement(i - 1, e));
		if (res == null) {
			res = new HashSet<>();
		}
		for (AnalysisResult ar : kill(e)) {
			res.remove(ar);
		}
		res.addAll(gen(e));
		res = new TreeSet<>(res);
		this.exitTable.put(new IterationElement(i, e), res);
		return res;
	}
}
