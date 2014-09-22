package framework.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 29-09-14.
 */
public class IdExpression extends Expression {

	public ID id;

	public String toString() {
		return id.toString();
	}

}
