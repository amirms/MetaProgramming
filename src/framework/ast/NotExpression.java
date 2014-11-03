package framework.ast;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Rogier on 30-09-14.
 */
public class NotExpression extends Expression {

	public Expression subExpression;

	public String toString() {
		return String.format("Not(%s)", subExpression);
	}


	@Override
	public boolean containsId(ID id) {
		return subExpression.containsId(id);
	}

	@Override
	public Collection<Expression> getChildren() {
		Collection<Expression> res = new HashSet<>();
		res.add(subExpression);
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NotExpression) {
			NotExpression that = (NotExpression) obj;
			return this.subExpression.equals(that.subExpression);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return subExpression.hashCode() - 1;
	}
}
