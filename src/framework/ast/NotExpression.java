package framework.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 30-09-14.
 */
public class NotExpression extends Expression {

	public Expression subExpression;

	public String toString() {
		return String.format("Not(%s)",subExpression);
	}

}
