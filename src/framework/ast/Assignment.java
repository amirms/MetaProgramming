package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;

/**
 * Created by Rogier on 29-09-14.
 */
public class Assignment extends SingleStatement {

	public ID id;
	public Expression expression;

	public String toString() {
		return String.format("Assignment(%s,%s)", id, expression);
	}

	public Element first() {
		return this;
	}

	public List<Flow> internalFlow() {
		return new ArrayList<Flow>();
	}

	public List<Element> last() {
		List<Element> res = new ArrayList<>();
		res.add(this);
		return res;
	}

}
