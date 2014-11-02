package framework.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 29-09-14.
 */
public class Int extends Expression {

	public int value;

	public String toString() {
		return String.format("%d", value);
	}

	@Override
	public boolean containsId(ID id) {
		return false;
	}

	@Override
	public List<Expression> getChildren() {
		return new ArrayList<Expression>(0);
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Int) {
			Int that = (Int)obj;
			return this.value==that.value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value;
	}


}
