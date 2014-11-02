package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;

/**
 * Created by Rogier on 02-11-14.
 */
public class ProcedureCall extends Statement {

	public Procedure callee;
	public ID returnVal;
	public List<Expression> params;

	public String toString() { return String.format("ProcedureCall(%s,%s,%s)", callee.name.id, returnVal, params); }

	public Element first() {
		return this;
	}

	public List<Element> last() {
		List<Element> res =  new ArrayList<>();
		res.add(this);
		return res;
	}
}
