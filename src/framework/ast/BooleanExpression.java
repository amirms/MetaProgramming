package framework.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Rogier on 29-09-14.
 */
public class BooleanExpression extends Expression {

	public boolean value;

	public String toString() {
		return String.format("Boolean(%s)", value);
	}

	@Override
	public boolean containsId(ID id) {
		return false;
	}

	@Override
	public Collection<Expression> getChildren() {
		return new TreeSet<>();
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof MathExpression) {
			BooleanExpression that = (BooleanExpression)obj;
			return this.value==that.value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value?1:0;
	}


}
