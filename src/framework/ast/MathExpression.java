package framework.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 30-09-14.
 */
public class MathExpression extends Expression {

	public Expression left;
	public Expression right;
	public String operator;

	public String toString() {
		return String.format("BinaryExpression(%s,%s,%s)",operator,left,right);
	}

}
