package framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import framework.ast.Element;
import framework.ast.Expression;
import framework.ast.ID;
import framework.ast.IdExpression;
import framework.ast.Int;

/**
 * Created by Rogier on 03-11-14.
 */
public class AvailableExpressionsResult extends AnalysisResult {
	private final Expression expression;

	public AvailableExpressionsResult(Expression exp, int label) {
		super(label);
		this.expression = exp;
	}

	@Override
	public int compareTo(Object o) {
		AvailableExpressionsResult that = (AvailableExpressionsResult) o;
		return this.expression.hashCode() - that.expression.hashCode();
	}

	public boolean containsId(ID id) {
		return expression.containsId(id);
	}

	public Collection<Element> getSet() {
		Set<Element> res = new HashSet<>();
		res.add(expression);
		for (Expression e : expression.getChildren()) {
			if (e instanceof IdExpression || e instanceof Int) {
				continue;
			}
			res.add(e);
		}
		return res;
	}

	public String toString() {
		return getSet().toString();
	}

	public boolean equals(Object obj) {
		if (obj instanceof AvailableExpressionsResult) {
			AvailableExpressionsResult that = (AvailableExpressionsResult) obj;
			return this.label == that.label && this.expression.equals(that.expression);
		}
		return false;
	}
}
