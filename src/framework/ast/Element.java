package framework.ast;

import java.util.ArrayList;
import java.util.List;

import framework.Flow;
import framework.Framework;

/**
 * Created by Rogier on 29-09-14.
 */
abstract public class Element {

	private int label;

	public Element() {
		label = Framework.currentLabel;
		Framework.currentLabel++;
	}

	protected List<Element> AST = new ArrayList<Element>();

	public void add(Element e) {
		this.AST.add(e);
	}

	public String toString() {
		if (AST.isEmpty()) {
			return "";
		}
		if (AST.size() == 1) {
			return AST.get(0).toString();
		}
		String x = AST.toString();
		return x.substring(1,x.length()-1);
	}

	public int getLabel() {
		return label;
	}

	public Element first() {
		return this;
	}

	public List<Flow> internalFlow() {
		return new ArrayList<Flow>();
	}

	public List<Element> last() {
		return new ArrayList<>();
	}

}
