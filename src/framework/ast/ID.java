package framework.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 29-09-14.
 */
public class ID extends Element {

	public String id;

	public String toString() {
		return String.format("ID(%s)",id);
	}

}
