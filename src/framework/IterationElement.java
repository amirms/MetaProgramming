package framework;

import framework.ast.Element;

/**
 * Created by Rogier on 03-11-14.
 */
public class IterationElement {

	private int iteration;
	private Element element;

	public IterationElement(int it, Element e) {
		this.iteration = it;
		this.element = e;
	}

	public int hashCode() {
		return 3 * iteration + 37 * element.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof IterationElement) {
			IterationElement that = (IterationElement) obj;
			return this.iteration == that.iteration && this.element.equals(that.element);
		}
		return false;
	}
}
