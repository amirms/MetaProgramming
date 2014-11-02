package framework;

import java.util.Collection;

import framework.ast.Element;
import framework.ast.ID;

/**
 * Created by Rogier on 02-11-14.
 */
abstract public class AnalysisResult implements Comparable {

	protected int label;

	public AnalysisResult(int label) {
		this.label = label;
	}

	public int getLabel() {
		return label;
	}

	public boolean containsId(ID id) {
		return false;
	}

	abstract public Collection<Element> getSet();
}
