import javafx.util.Pair;
import java.util.LinkedHashSet;

public class SetOfStates {
    private LinkedHashSet<Integer> set;
    private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;
    private boolean finalState;

    public SetOfStates(LinkedHashSet<Integer> set, ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions, boolean finalState) {
        this.set = set;
        this.transitions = transitions;
        this.finalState = finalState;
    }

    public boolean sameSetOfStates(SetOfStates otherSetOfStates) {
        return true;
    }
}