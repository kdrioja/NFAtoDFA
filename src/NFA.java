/*
    Kenia Rioja-Naranjo
    CSC 471 Project 1
 */

import javafx.util.Pair;
import java.util.LinkedHashSet;

public class NFA {
    // Array of State objects representing the states in the NFA
    private ArrayList<State> states;
    // Array containing the input alphabet
    // lambda transitions are represented as 'L' and are always at the end of the array
    private ArrayList<String> inputAlphabet;
    // Start state of NFA
    private int startVar;
    // Set of Integers that represent the final states
    private LinkedHashSet<Integer> finalVars;
    // True if the NFA contains lambda transitions, false otherwise
    private boolean lambdaTransitions;

    // Constructor
    public NFA(int startVar, LinkedHashSet<Integer> finalVar, ArrayList<String> inputAlphabet, boolean lambdaTransitions) {
        this.startVar = startVar;
        this.finalVars = finalVar;
        this.inputAlphabet = inputAlphabet;
        this.states = new ArrayList<>();
        this.lambdaTransitions = lambdaTransitions;
    }

    // Adds a new State object to the NFA's states array
    public void addState(State newState) {
        if (newState != null) {
            this.states.add(newState);
        }
    }

    // Returns the name of the start state
    private State getStartingState(){
        for (int s = 0; s < this.states.getSize(); s++) {
            if (this.states.get(s).getName() == this.startVar) {
                return this.states.get(s);
            }
        }

        return null;
    }

    // Returns a DFA from an NFA
    public DFA transformToDFA() {
        DFA dfa;
        int processed = 0;
        int pointer = 0;

        if (this.lambdaTransitions) {
            ArrayList<String> newInputAlphabet = new ArrayList<>();

            for (int i = 0; i < this.inputAlphabet.getSize(); i++) {
                if (!this.inputAlphabet.get(i).equals("L")) {
                    newInputAlphabet.add(this.inputAlphabet.get(i));
                }
            }
            dfa = new DFA(this.startVar, this.finalVars, newInputAlphabet);
        }
        else {
            dfa = new DFA(this.startVar, this.finalVars, this.inputAlphabet);
        }

        // Process start state
        State startState = getStartingState();
        LinkedHashSet<Integer> startSS = new LinkedHashSet<>();
        startSS.add(this.startVar);
        SetOfStates startStateSet = new SetOfStates(startSS, startState.isFinalState());

        dfa.addSetOfStates(startStateSet);

        while (processed != dfa.getStates().getSize()) {
            Object[] stateNames = dfa.getStates().get(pointer).getSetOfStates().toArray();

            // If trap state populate it
            if ((int) stateNames[0] == -1) {
                for (int l = 0; l < dfa.getInputAlphabet().getSize(); l++) {
                    String key = dfa.getInputAlphabet().get(l);
                    LinkedHashSet<Integer> values = new LinkedHashSet<>();

                    if (!key.equals("L")) {
                        values.add(-1);
                        Pair<String, LinkedHashSet<Integer>> newPair = new Pair<>(key, values);
                        dfa.getStates().get(pointer).addTransition(newPair);
                    }
                }
                processed++;
                pointer++;
            }

            // Not a trap state
            else {
                for (int l = 0; l < dfa.getInputAlphabet().getSize(); l++) {
                    String key = dfa.getInputAlphabet().get(l);
                    LinkedHashSet<Integer> values = new LinkedHashSet<>();
                    boolean finalState = false;

                    if (!key.equals("L")) {
                        for (int stateInSet = 0; stateInSet < stateNames.length; stateInSet++) {
                            int stateName = (Integer) stateNames[stateInSet];
                            LinkedHashSet<Integer> currentLetterTransitions = this.states.get(stateName).getTransitions().get(l).getValue();

                            if (currentLetterTransitions != null) {
                                Object[] currentLetterTransitionsArray = currentLetterTransitions.toArray();
                                for (int i = 0; i < currentLetterTransitionsArray.length; i++) {
                                    values.add((int) currentLetterTransitionsArray[i]);

                                    if (this.finalVars.contains((int) currentLetterTransitionsArray[i])) {
                                        finalState = true;
                                    }
                                }
                            }

                            //Lambda checking for additional transitions happens here
                            int lambdaIndex = this.inputAlphabet.getSize() - 1;
                            LinkedHashSet<Integer> currentLambdaTransitions = this.states.get(stateName).getTransitions().get(lambdaIndex).getValue();

                            if (currentLambdaTransitions != null) {
                                Object[] currentLambdaTransitionsArray = currentLambdaTransitions.toArray();
                                for (int i = 0; i < currentLambdaTransitionsArray.length; i++) {

                                    // if the key is defined for the lambda transition, add it
                                    if (this.states.get((int) currentLambdaTransitionsArray[i]).getTransitions().get(l).getValue() != null) {
                                        values.add((int) currentLambdaTransitionsArray[i]);

                                        if (this.finalVars.contains((int) currentLambdaTransitionsArray[i])) {
                                            finalState = true;
                                        }
                                    }
                                }
                            }
                        }

                        // Finalized the transition set of states
                        if (values.size() == 0) {
                            values.add(-1);
                            dfa.getStates().get(pointer).addTransition(new Pair<>(key, values));

                            if (!dfa.isTrapStateExists()) {
                                SetOfStates trapState = new SetOfStates(values, finalState);
                                dfa.setTrapStateExists(true);
                                dfa.addSetOfStates(trapState);
                            }
                        }
                        else {
                            //Check that the values created isn't already a state in dfa.states
                            SetOfStates newSetOfStates = new SetOfStates(values, finalState);
                            dfa.getStates().get(pointer).addTransition(new Pair<>(key, values));

                            if (!dfa.isAlreadyInStates(newSetOfStates)) {
                                dfa.addSetOfStates(newSetOfStates);
                            }
                        }
                    }
                }
                processed++;
                pointer++;
            }
        }
        return dfa;
    }

    // Returns a string of the NFA
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.states.getSize() == 0) {
            result.append("NFA\nInput alphabet: " + this.inputAlphabet + "\nNo states");
        }
        else {
            result.append("NFA\nInput alphabet: " + this.inputAlphabet + "\n");
            result.append("Starting state: " + this.startVar + "\tFinal states: " + this.finalVars + "\n");

            for (int i = 0; i < this.states.getSize(); i++) {
                result.append(this.states.get(i).getName() + " -> ");
                for (int p = 0; p < this.states.get(i).getTransitions().getSize(); p++) {
                    if (this.states.get(i).getTransitions().get(p).getValue() == null) {
                        result.append("(" + this.states.get(i).getTransitions().get(p).getKey() + ", [])   ");
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