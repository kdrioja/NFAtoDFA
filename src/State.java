import javafx.util.Pair;
import java.util.LinkedHashSet;

public class State {
    private int name;
    private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;
    private boolean finalState;

    public State(int name, boolean finalState, ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions) {
        this.name = name;
        this.finalState = finalState;
        this.transitions = transitions;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
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
            result.append("Final State " + this.name + " -> ");
        }
        else {
            result.append("Non-final State " + this.name + " -> ");
        }


        for (int i = 0; i < this.transitions.getSize(); i++) {
            if (this.transitions.get(i).getValue() == null) {
                result.append("(" + this.transitions.get(i).getKey() + ", - )   ");
            }
            else {
                result.append("(" + this.transitions.get(i).getKey() + ", " + this.transitions.get(i).getValue() + ")   ");
            }
        }
        return  result.toString();
    }
}