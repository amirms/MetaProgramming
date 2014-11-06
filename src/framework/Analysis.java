package framework;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import framework.ast.Element;
import framework.ast.Program;

/**
 * Created by Rogier on 02-11-14.
 */
abstract public class Analysis {

	protected List<Flow> cfg;

	protected AnalysisDirection direction;

	protected Map<Integer, ExitEntryPair> result;

	protected Map<IterationElement, Collection<AnalysisResult>> exitTable = new HashMap<>();
	protected Map<IterationElement, Collection<AnalysisResult>> entryTable = new HashMap<>();

	public Analysis(List<Flow> cfg, AnalysisDirection dir) {
		this.cfg = cfg;
		this.direction = dir;
		if (this.direction == AnalysisDirection.BACKWARDS) {
			Collections.reverse(this.cfg);
		}
	}

	abstract public Collection<AnalysisResult> kill(Element e);

	abstract public Collection<AnalysisResult> gen(Element e);

	abstract public Collection<AnalysisResult> entry(Element e, int iteration);

	abstract public Collection<AnalysisResult> exit(Element e, int iteration);

	public Map<Integer, ExitEntryPair> performAnalysis() {
		Map<Integer, ExitEntryPair> map = new HashMap<>();
		for (int i = 0; i < this.cfg.size(); i++) {
			map = new TreeMap<>();
			for (Flow f : this.cfg) {
				ExitEntryPair pair = new ExitEntryPair(exit(f.from, i), entry(f.from, i));
				map.put(f.from.getLabel(), pair);
			}
		}
		map.remove(1); // Thats the Program.START one, we dont care about that
		map.remove(2); // Thats the Program.END one, we dont care about that either
		result = map;
		return map;
	}

	protected Collection<Element> getAllNodesWithDirection(Element e, AnalysisDirection dir) {
		if (e.equals(Program.START) || e.equals(Program.END)) {
			return new HashSet<>();
		}
		Set<Element> res = new HashSet<>();

		for (Flow f : this.cfg) {
			if (dir == AnalysisDirection.BACKWARDS && f.to.equals(e)) {
				res.add(f.from);
			}
			else if (dir == AnalysisDirection.FORWARDS && f.from.equals(e)) {
				res.add(f.to);
			}
		}
		return res;
	}

}
