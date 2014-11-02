package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;

/**
 * Created by Rogier on 02-11-14.
 */
public class Procedure extends Element {

	public ID name;
	public ID returnVal;
	public List<ID> parameters;

	public Block content;

	public String toString() {
		return String.format("Procedure(%s,%s,%s,%s)", name, returnVal, parameters, content);
	}

	public Element first() {
		return this;
	}

	public List<Flow> internalFlow() {
		return new ArrayList<>();
	}

	public List<Element> last() {
		return new ArrayList<>();
	}

}
