package framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import framework.ast.Element;
import framework.ast.Expression;
import framework.ast.ID;
import framework.ast.IdExpression;
import framework.ast.Int;

/**
 * Created by Rogier on 03-11-14.
 */
public class DefiniteAssignmentsResult extends AnalysisResult {
	private final ID id;

	public DefiniteAssignmentsResult(ID id, int label) {
		super(label);
		this.id = id;
	}

	@Override
	public int compareTo(Object o) {
		DefiniteAssignmentsResult that = (DefiniteAssignmentsResult) o;
		return this.id.hashCode() - that.id.hashCode();
	}

	public boolean containsId(ID id) {
		return this.id.equals(id);
	}

	public Collection<Element> getSet() {
		Set<Element> res = new HashSet<>();
		res.add(id);
		return res;
	}

	public String toString() {
		return getSet().toString();
	}

	public boolean equals(Object obj) {
		if (obj instanceof DefiniteAssignmentsResult) {
			DefiniteAssignmentsResult that = (DefiniteAssignmentsResult) obj;
			return this.label == that.label && this.id.equals(that.id);
		}
		return false;
	}
}
