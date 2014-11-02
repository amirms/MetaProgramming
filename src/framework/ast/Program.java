package framework.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import framework.Flow;
import framework.ProcedureFlow;
import framework.RegularFlow;
import lombok.ToString;

/**
 * Created by Rogier on 29-09-14.
 */
@ToString
public class Program extends Element {

	public static final Element START = new Element() {
		@Override
		public String toString() {
			return "START";
		}
	};
	public static final Element END = new Element() {
		@Override
		public String toString() {
			return "END";
		}
	};

	public List<Element> ast() {
		List<Element> correctlyOrdered = new ArrayList<>(AST);
		Collections.reverse(correctlyOrdered);
		return correctlyOrdered;
	}

	public String astString() {
		String x = ast().toString();
		return x.substring(1, x.length() - 1);
	}

	public List<Flow> internalFlow() {
		List<Flow> result = new ArrayList<>();
		List<Element> elements = ast();
		List<Element> prev = new ArrayList<>(1);
		prev.add(Program.START);
		outerLoop:
		for (int i = 0; i < elements.size(); i++) {
			Element elem = elements.get(i);
			for (Element e : prev) {
				if (elem instanceof Procedure) {
					continue outerLoop;
				}
				else if (elem instanceof ProcedureCall) {
					result.add(new ProcedureFlow(e, elem.first()));
				}
				else {
					result.add(new RegularFlow(e, elem.first()));
				}
			}
			result.addAll(elem.internalFlow());
			prev = elem.last();
		}
		for (Element e : prev) {
			result.add(new RegularFlow(e, Program.END));
		}
		return result;
	}

}
