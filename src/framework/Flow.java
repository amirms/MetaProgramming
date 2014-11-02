package framework;

import framework.ast.Element;

/**
 * Created by Rogier on 02-11-14.
 */
public class Flow {

	public Element from;
	public Element to;

	public Flow(Element from, Element to) {
		this.from = from;
		this.to = to;
	}

	//	public String toString() {
	//		return String.format("From %s to %s",from.toString(),to.toString());
	//	}

	@Override
	public int hashCode() {
		return from.hashCode() * 17 * to.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Flow) {
			Flow that = (Flow) obj;
			return from.equals(that.from) && to.equals(that.to);
		}
		return false;
	}

	public String toString() {
		return String.format("From %s to %s", from.getLabel(), to.getLabel());
	}

	public Flow reverse() {
		return new Flow(to, from);
	}

}
