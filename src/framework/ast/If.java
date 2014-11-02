package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;
import framework.RegularFlow;

/**
 * Created by Rogier on 29-09-14.
 */
public class If extends Statement {

	public Expression conditional;
	public Statement ifCase;
	public Statement elseCase;

	public String toString() {
		return String.format("IfThenElse(%s,%s,%s)", conditional, ifCase, elseCase);
	}

	public Element first() {
		return conditional;
	}

	public List<Flow> internalFlow() {
		List<Flow> res = new ArrayList<>();
		res.add(new RegularFlow(conditional, ifCase.first()));
		res.add(new RegularFlow(conditional, elseCase.first()));
		res.addAll(ifCase.internalFlow());
		res.addAll(elseCase.internalFlow());
		return res;
	}

	public List<Element> last() {
		List<Element> res = new ArrayList<>();
		res.addAll(ifCase.last());
		res.addAll(elseCase.last());
		return res;
	}

}
