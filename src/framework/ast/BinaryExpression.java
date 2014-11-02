package framework.ast;

/**
 * Created by Rogier on 29-09-14.
 */
public class BinaryExpression extends Expression {

	public Expression left;
	public Expression right;
	public String operator;

	public String toString() {
		return String.format("BinaryExpression(%s,%s,%s)",operator,left,right);
	}

}
