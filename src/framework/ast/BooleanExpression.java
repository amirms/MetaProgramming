package framework.ast;

/**
 * Created by Rogier on 29-09-14.
 */
public class BooleanExpression extends Expression {

	public boolean value;

	public String toString() {
		return String.format("Boolean(%s)",value);
	}

}
