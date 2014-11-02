package framework;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Rogier on 02-11-14.
 */
public class ExitEntryPair {

	private Collection<AnalysisResult> entry;
	private Collection<AnalysisResult> exit;

	public ExitEntryPair(Collection<AnalysisResult> exit, Collection<AnalysisResult> entry) {
		this.entry = entry;
		this.exit = exit;
	}

	public String toString() {
		Collection<AnalysisResult> intEntry = new HashSet<>(entry);
		Collection<AnalysisResult> intExit = new HashSet<>(exit);
		return String.format("Entry: %s; Exit; %s\n", intEntry, intExit);
	}

	public boolean equals(Object obj) {
		if (obj instanceof ExitEntryPair) {
			ExitEntryPair that = (ExitEntryPair) obj;
			return this.entry.equals(that.entry) && this.exit.equals(that.exit);
		}
		return false;
	}

}
