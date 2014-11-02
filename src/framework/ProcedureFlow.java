package framework;

import framework.ast.Element;

/**
 * Created by Rogier on 02-11-14.
 */
public class ProcedureFlow extends Flow {
	public ProcedureFlow(Element from, Element to) {
		super(from, to);
	}

	@Override
	public Flow reverse() {
		return new ProcedureFlow(to, from);
	}
}
