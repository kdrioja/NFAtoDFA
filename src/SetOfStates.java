import javafx.util.Pair;
import java.util.LinkedHashSet;

public class SetOfStates {
    private LinkedHashSet<Integer> setOfStates;
    private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;
    private boolean finalState;

    public SetOfStates(LinkedHashSet<Integer> set, boolean finalState) {
        this.setOfStates = set;
        this.transitions = new ArrayList<>();
        this.finalState = finalState;
    }
    public SetOfStates(LinkedHashSet<Integer> set, ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions, boolean finalState) {
        this.setOfStates = set;
        this.transitions = transitions;
        this.finalState = finalState;
    }

    public void addTransition(Pair<String, LinkedHashSet<Integer>> newTransitionPair) {
        if (newTransitionPair != null) {
            this.transitions.add(newTransitionPair);
        }
    }

    public boolean sameSetOfStates(SetOfStates otherSetOfStates) {
        if (this.setOfStates.size() != otherSetOfStates.setOfStates.size()) {
            return false;
        }
        else {
            return this.setOfStates.equals(otherSetOfStates.setOfStates);
        }
    }

    public LinkedHashSet<Integer> getSetOfStates() {
        return setOfStates;
    }

    public void setSetOfStates(LinkedHashSet<Integer> setOfStates) {
        this.setOfStates = setOfStates;
    }

    public ArrayList<Pair<String, LinkedHashSet<Integer>>> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions) {
        this.transitions = transitions;
    }

    public boolean isFinalState() {
        return finalState;
    }

    public void setFinalState(boolean finalState) {
        this.finalState = finalState;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if (this.finalState) {
            result.append("Final state " + this.setOfStates.toString() + " -> ");
        }
        else {
            result.append("Non-final state " + this.setOfStates.toString() + " -> ");
        }

        for (int t = 0; t < this.transitions.getSize(); t++) {
            result.append("(" + this.transitions.get(t).getKey() + ", " + this.transitions.get(t).getValue() + ")   ");
        }
        return result.toString();
    }
}