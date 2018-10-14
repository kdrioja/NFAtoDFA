import javafx.util.Pair;

import java.util.LinkedHashSet;

public class SetOfStates {
    private LinkedHashSet<Integer> set;
    private boolean finalState;
    private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;

    public SetOfStates() {
        this.set = new LinkedHashSet<>();
        this.finalState = false;
    }

    public void addState(State newState) {
        if (newState != null) {
            this.finalState = newState.isFinalState();
            this.set.add(newState.getName());
        }
    }

    public boolean sameSetOfStates() {
        return true;
    }
}
