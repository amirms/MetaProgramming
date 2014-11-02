package framework.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Rogier on 29-09-14.
 */
public class IdExpression extends Expression {

	public ID id;

	public String toString() {
		return id.toString();
	}

	@Override
	public boolean containsId(ID id) {
		return this.id.equals(id);
	}

	@Override
	public Collection<Expression> getChildren() {
		return new TreeSet<>();
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof IdExpression) {
			IdExpression that = (IdExpression)obj;
			return this.id.equals(that.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
