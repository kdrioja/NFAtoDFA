/*
    Kenia Rioja-Naranjo
    CSC 471 Project 1
 */

import javafx.util.Pair;
import java.util.LinkedHashSet;

public class State {
    /*
    Object was used to represent a State in a NFA
     */
    // Name of the state
    private int name;
    // Array containing all defined transitions
    private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;
    // True if final state, false if non-final
    private boolean finalState;

    // Constructor
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

    // Returns string with the state's name and it's transitions
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.finalState) {
            result.append("Final State\t" + this.name + " -> ");
        }
        else {
            result.append("Non-final State\t" + this.name + " -> ");
        }


        for (int i = 0; i < this.transitions.getSize(); i++) {
            if (this.transitions.get(i).getValue() == null) {
                result.append("(" + this.transitions.get(i).getKey() + ", [])   ");
            }
            else {
                result.append("(" + this.transitions.get(i).getKey() + ", " + this.transitions.get(i).getValue() + ")   ");
            }
        }
        return  result.toString();
    }
}