package framework.ast;

import java.util.Collection;

/**
 * Created by Rogier on 29-09-14.
 */
abstract public class Expression extends Element {

	abstract public boolean containsId(ID id);

	abstract public Collection<Expression> getChildren();

	abstract public boolean equals(Object obj);

	abstract public int hashCode();
}
