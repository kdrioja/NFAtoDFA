/*
    Kenia Rioja-Naranjo
    CSC 471 Project 1
 */

import java.util.LinkedHashSet;

public class DFA {
    // Array of SetOfStates objects
    private ArrayList<SetOfStates> states;
    // Array containing the input alphabet
    private ArrayList<String> inputAlphabet;
    // Start state of DFA
    private int startVar;
    // Set of Integers that represent the final states
    private LinkedHashSet<Integer> finalVars;
    // Boolean for there already being a trap state in DFA
    private boolean trapStateExists;

    // Constructor
    public DFA(int startVar, LinkedHashSet<Integer> finalVars, ArrayList<String> inputAlphabet) {
        this.states = new ArrayList<>();
        this.startVar = startVar;
        this.finalVars = finalVars;
        this.inputAlphabet = inputAlphabet;
        this.trapStateExists = false;
    }

    // Adds a SetOfStates object to DFA's states array
    public void addSetOfStates(SetOfStates newSetOfStates) {
        if (newSetOfStates != null) {
            this.states.add(newSetOfStates);
        }
    }

    // Checks if a set of states is already in DFA states array
    public boolean isAlreadyInStates(SetOfStates setToBeAdded) {
        for (int i = 0; i < this.states.getSize(); i++) {
            if (this.states.get(i).getSetOfStates().equals(setToBeAdded.getSetOfStates())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<SetOfStates> getStates() {
        return states;
    }

    public void setStates(ArrayList<SetOfStates> states) {
        this.states = states;
    }

    public ArrayList<String> getInputAlphabet() {
        return inputAlphabet;
    }

    public void setInputAlphabet(ArrayList<String> inputAlphabet) {
        this.inputAlphabet = inputAlphabet;
    }

    public int getStartVar() {
        return startVar;
    }

    public void setStartVar(int startVar) {
        this.startVar = startVar;
    }

    public LinkedHashSet<Integer> getFinalVars() {
        return finalVars;
    }

    public void setFinalVars(LinkedHashSet<Integer> finalVars) {
        this.finalVars = finalVars;
    }

    public boolean isTrapStateExists() {
        return trapStateExists;
    }

    public void setTrapStateExists(boolean trapStateExists) {
        this.trapStateExists = trapStateExists;
    }

    // Prints out the DFA
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.states.getSize() == 0) {
            result.append("DFA\nInput alphabet: " + this.inputAlphabet + "\nNo states");
        }
        else {
            result.append("DFA\nInput alphabet: " + this.inputAlphabet + "\n");

            for (int i = 0; i < this.states.getSize(); i++) {
                result.append(this.states.get(i).toString() + "\n");
            }
        }
        return result.toString();
    }
}