package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;
import framework.RegularFlow;

/**
 * Created by Rogier on 29-09-14.
 */
public class While extends SingleStatement {

	public Expression conditional;
	public Statement block;

	public String toString() {
		return String.format("While(%s,%s)",conditional,block);
	}

	public Element first() {
		return conditional;
	}

	public List<Flow> internalFlow() {
		List<Flow> res = new ArrayList<>();
		res.add(new RegularFlow(conditional, block.first()));
		res.addAll(block.internalFlow());
		for ( Element e : block.last()) {
			res.add(new RegularFlow(e, conditional));
		}
		return res;
	}

	public List<Element> last() {
		List<Element> res = new ArrayList<>();
		res.add(conditional);
		return res;
	}

}
