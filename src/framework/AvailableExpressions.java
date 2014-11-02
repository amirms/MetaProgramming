package framework;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import framework.ast.Assignment;
import framework.ast.BooleanExpression;
import framework.ast.Element;
import framework.ast.Expression;
import framework.ast.ID;
import framework.ast.IdExpression;
import framework.ast.If;
import framework.ast.Int;
import framework.ast.Program;
import framework.ast.While;

/**
 * Created by Rogier on 02-11-14.
 */
public class AvailableExpressions extends Analysis {

	protected Collection<AnalysisResult> expressions = new ArrayList<>();

	public AvailableExpressions(List<Flow> cfg) {
		super(cfg, AnalysisDirection.FORWARDS);
	}

	@Override
	public Collection<AnalysisResult> kill(Element e) {
		Set<AnalysisResult> res = new HashSet<>();
		if (e instanceof Assignment) {
			// Kill everything with a referenced variable in it
			ID id = ((Assignment)e).id;
			for ( AnalysisResult ar:expressions) {
				if ( ar.containsId(id)) {
					res.add(ar);
				}
			}
		}
		return res;
	}

	@Override
	public Collection<AnalysisResult> gen(Element e) {
		Collection<AnalysisResult> res = new HashSet<>();
		if ( e instanceof IdExpression || e instanceof Int || e instanceof BooleanExpression) {
			return res;
		}
		if (e instanceof Assignment) {
			res.add(new AvailableExpressionsResult(((Assignment)e).expression,e.getLabel()));
			for ( Expression subexp : ((Assignment)e).expression.getChildren()) {
				res.addAll(gen(subexp));
			}
		} else if ( e instanceof Expression) {
			res.add(new AvailableExpressionsResult((Expression)e,e.getLabel()));
			for ( Expression subexp : ((Expression)e).getChildren()) {
				res.addAll(gen(subexp));
			}
		}
		expressions.addAll(res);
		return res;
	}

	@Override
	public Collection<AnalysisResult> entry(Element e,int i) {
		if (e.equals(Program.START)) {
			return new HashSet<>();
		}
		Set<AnalysisResult> res = new TreeSet<>(expressions);
		for (Element workElement : getAllNodesWithDirection(e, AnalysisDirection.BACKWARDS)) {
			Collection<AnalysisResult> x = this.exitTable.get(new IterationElement(i, workElement));
			if ( x == null ) {
				x = new HashSet<>();
			}
			Set<AnalysisResult> oldRes = new TreeSet<>(res);
			res = new TreeSet<>();
			for ( AnalysisResult y : x) {
				if (oldRes.contains(y)) {
					res.add(y);
				}
			}
		}
		this.entryTable.put(new IterationElement(i,e),res);
		return res;
	}

	@Override
	public Collection<AnalysisResult> exit(Element e,int i) {
		if (e.equals(Program.START)) {
			return new HashSet<>();
		}
		Collection<AnalysisResult> res = this.entryTable.get(new IterationElement(i-1,e));
		if ( res == null ) {
			res = entry(e,i);
		}
		res.addAll(gen(e));
		for (AnalysisResult ar : kill(e)) {
			res.remove(ar);
		}
		res = new TreeSet<>(res);
		this.exitTable.put(new IterationElement(i,e),res);
		return res;
	}
}
