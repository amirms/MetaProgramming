package framework;

import framework.ast.Element;

/**
 * Created by Rogier on 22-09-14.
 */
public class Flow {

	public Element from;
	public Element to;

	public Flow(Element from, Element to) {
		this.from = from;
		this.to = to;
	}

	public String toString() {
		return String.format("From %s to %s",from.toString(),to.toString());
	}

}
