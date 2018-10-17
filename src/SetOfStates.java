/*
    Kenia Rioja-Naranjo
    CSC 471 Project 1
 */

import javafx.util.Pair;
import java.util.LinkedHashSet;

public class SetOfStates {
    /*
    Object was used to represent a "set of states" that is typically formed through the change of an NFA to a DFA
     */
    // Set containing the names of states therefore creating a new state
    private LinkedHashSet<Integer> setOfStates;
    // Array of transitions for the set of states
    private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;
    // True if a final state, false if non-final state
    private boolean finalState;

    // Constructor
    public SetOfStates(LinkedHashSet<Integer> set, boolean finalState) {
        this.setOfStates = set;
        this.transitions = new ArrayList<>();
        this.finalState = finalState;
    }

    // Adds a transition tp the set of states
    public void addTransition(Pair<String, LinkedHashSet<Integer>> newTransitionPair) {
        if (newTransitionPair != null) {
            this.transitions.add(newTransitionPair);
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

    // Returns a string with the name of the set of states and it's transitions
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (this.finalState) {
            result.append("Final state\t" + this.setOfStates.toString() + " -> ");
        }
        else {
            result.append("Non-final state\t" + this.setOfStates.toString() + " -> ");
        }

        for (int t = 0; t < this.transitions.getSize(); t++) {
            result.append("(" + this.transitions.get(t).getKey() + ", " + this.transitions.get(t).getValue() + ")   ");
        }
        return result.toString();
    }
}