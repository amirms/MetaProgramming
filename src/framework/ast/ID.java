package framework.ast;

/**
 * Created by Rogier on 29-09-14.
 */

public class ID extends Element {

	public String id;

	public String toString() {
		return String.format("ID(%s)", id);
	}

	public boolean equals(Object that) {
		if (that instanceof ID) {
			return this.id.equals(((ID) that).id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
