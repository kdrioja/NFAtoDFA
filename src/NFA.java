import javafx.util.Pair;
import sun.awt.image.ImageWatched;

import java.util.LinkedHashSet;

public class NFA {
    // NFA represented as a matrix, where the columns correspond to input
    // symbols, while the rows correspond to states
    // Matrix cells are subsets of states representing the transitions for
    // the corresponding states and symbols
    // Lambda is represented as 'L' in the inputAlphabet and is always at the
    // end of inputAlphabet and transition ArrayLists

    private ArrayList<State> states;
    private ArrayList<String> inputAlphabet;
    private int startVar;
    private LinkedHashSet<Integer> finalVars;
    private boolean lambdaTransitions;

    public NFA(int startVar, LinkedHashSet<Integer> finalVar, ArrayList<String> inputAlphabet, boolean lambdaTransitions) {
        this.startVar = startVar;
        this.finalVars = finalVar;
        this.inputAlphabet = inputAlphabet;
        this.states = new ArrayList<>();
        this.lambdaTransitions = lambdaTransitions;
    }

    public void addState(State newState) {
        if (newState != null) {
            this.states.add(newState);
        }
    }

    private State getStartingState(){
        for (int s = 0; s < this.states.getSize(); s++) {
            if (this.states.get(s).getName() == this.startVar) {
                return this.states.get(s);
            }
        }

        return null;
    }

    public DFA transformToDFA() {
        int processed = 0;
        int pointer = 0;
        DFA dfa = new DFA(this.startVar, this.finalVars, this.inputAlphabet);
        // also have member private ArrayList<SetOfStates> states;

        //  can be added later first create the SetOfStates and add it to dfa and then while
        //  the number of items in the dfa is != to the processed amount then keep processing the next item in the dfa's states arraylist
        //  maybe keep a pointer outside of the loop? HMMM, but first have to create the first and add it
        //  the first is the start symbol which is 0 in this case

        // SetOfStates member variables
        // private LinkedHashSet<Integer> setOfStates;
        // private ArrayList<Pair<String, LinkedHashSet<Integer>>> transitions;
        // private boolean finalState;
        // public SetOfStates(LinkedHashSet<Integer> set, boolean finalState) {


        // Process start state
        State startState = getStartingState();
        LinkedHashSet<Integer> startSS = new LinkedHashSet<>();
        startSS.add(this.startVar);
        SetOfStates startStateSet = new SetOfStates(startSS, startState.isFinalState());

        dfa.addSetOfStates(startStateSet);

        while (processed != dfa.getStates().getSize()) {
            Object[] stateNames = (Integer[]) dfa.getStates().get(pointer).getSetOfStates().toArray();
            for (int l = 0; l < this.inputAlphabet.getSize(); l++) {
                String key = this.inputAlphabet.get(l);
                LinkedHashSet<Integer> values = new LinkedHashSet<>();

                if (key.equals("L")) {

                }
                else {
                    for (int stateInSet = 0; stateInSet < stateNames.length; stateInSet++) {
                        int stateName = (Integer) stateNames[stateInSet];
                        Object[] currentLetterTransitions = (Integer[]) this.states.get(stateName).getTransitions().get(l).getValue().toArray();

                        if (currentLetterTransitions != null && currentLetterTransitions.length != 0) {
                            for (int i = 0; i < currentLetterTransitions.length; i++) {
                                values.add((int) currentLetterTransitions[i]);
                            }
                        }
                        else {
                            //state doesn't have any transitions defined for this letter
                        }

                        //Lambda checking

                    }
                }

                if (values.size() == 0) {
                    values.add(-1);

                    if (!dfa.isTrapStateExists()) {
                        SetOfStates trapState = new SetOfStates(values, false);
                    }
                }

            }
        }

        return dfa;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.states.getSize() == 0) {
            result.append("NFA\nInput alphabet: " + this.inputAlphabet + "\nNo states");
        }
        else {
            result.append("NFA\nInput alphabet: " + this.inputAlphabet + "\n");
            for (int i = 0; i < this.states.getSize(); i++) {
                result.append(this.states.get(i).getName() + " -> ");
                for (int p = 0; p < this.states.get(i).getTransitions().getSize(); p++) {
                    if (this.states.get(i).getTransitions().get(p).getValue() == null) {
                        result.append("(" + this.states.get(i).getTransitions().get(p).getKey() + ", - )   ");
                    }
                    else {
                        result.append("(" + this.states.get(i).getTransitions().get(p).getKey() + ", " + this.states.get(i).getTransitions().get(p).getValue() + ")   ");
                    }
                }
                result.append("\n");
            }
        }
        return result.toString();
    }
}