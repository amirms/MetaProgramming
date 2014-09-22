package framework.ast;

/**
 * Created by Rogier on 29-09-14.
 */
public class Int extends Expression {

	public int value;

	public String toString() {
		return String.format("%d",value);
	}
}
