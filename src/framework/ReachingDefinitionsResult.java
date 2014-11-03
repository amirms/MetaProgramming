package framework;

import java.util.Collection;
import java.util.HashSet;

import framework.ast.Element;
import framework.ast.ID;

/**
 * Created by Rogier on 03-11-14.
 */
public class ReachingDefinitionsResult extends AnalysisResult {

	public ID id;

	public ReachingDefinitionsResult(ID id, int label) {
		super(label);
		this.id = id;
	}

	@Override
	public int hashCode() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ReachingDefinitionsResult) {
			ReachingDefinitionsResult that = (ReachingDefinitionsResult) obj;
			return this.label == that.label && this.id.equals(that.id);
		}
		return false;
	}


	public String toString() {
		return String.format("(%s,%s)", id, label);
	}

	@Override
	public int compareTo(Object o) {
		return this.label - ((ReachingDefinitionsResult) o).label;
	}

	@Override
	public Collection<Element> getSet() {
		Collection<Element> res = new HashSet<>();
		res.add(id);
		return res;
	}
}
