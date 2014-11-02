package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;
import framework.ProcedureFlow;
import framework.RegularFlow;

/**
 * Created by Rogier on 29-09-14.
 */
public class Block extends Statement {

	public String toString() {
		return String.format("Block(%s)",super.toString());
	}

	public Element first() {
		if ( AST.size() == 0 ) {
			return this;
		}
		return AST.get(0).first();
	}

	public List<Flow> internalFlow() {
		List<Flow> result = new ArrayList<>();
		if ( AST.size() == 0 ) {
			return result;
		}

		List<Element> prev = new ArrayList<>(1);
		prev.addAll(AST.get(0).last());
		result.addAll(AST.get(0).internalFlow());
		for(int i = 1; i < AST.size(); i++) {
			Element elem = AST.get(i);
			for ( Element e : prev) {
				if ( e instanceof ProcedureCall) {
					result.add(new ProcedureFlow(e, elem.first()));
				} else {
					result.add(new RegularFlow(e, elem.first()));
				}
			}
			result.addAll(elem.internalFlow());
			prev = elem.last();
		}
		return result;
	}

	public List<Element> last() {
		if ( AST.size() == 0 ) {
			return this.last();
		}
		 else {
			return AST.get(AST.size()-1).last();
		}
	}

}
