import java.util.LinkedHashSet;

public class NFA {
    // NFA represented as a matrix, where the columns correspond to input
    // symbols, while the rows correspond to states
    // Matrix cells are subsets of states representing the transitions for
    // the corresponding states and symbols
    private ArrayList<State> states; //ArrayList.size is number of states
    private ArrayList<String> inputAlphabet;
    private int startVar;
    private LinkedHashSet<Integer> finalVar;

    public NFA(int startVar, LinkedHashSet<Integer> finalVar, ArrayList<String> inputAlphabet) {
        this.startVar = startVar;
        this.finalVar = finalVar;
        this.inputAlphabet = inputAlphabet;
        this.states = new ArrayList<>();
    }

    public void addState(State newState) {
        if (newState != null) {
            this.states.add(newState);
        }
    }
    //NEEDS WORK
    public DFA transformToDFA() {
        DFA newDFA = new DFA();

        return newDFA;
    }

    public ArrayList<State> getNfa() {
        return states;
    }

    public void setNfa(ArrayList<State> nfa) {
        this.states = nfa;
    }

    public ArrayList<String> getInputAlphabet() {
        return inputAlphabet;
    }

    public void setInputAlphabet(ArrayList<String> inputAlphabet) {
        this.inputAlphabet = inputAlphabet;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.states.getSize() == 0) {
            result.append("Input alphabet: " + this.inputAlphabet + "\nNo states");
        }
        else {
            result.append("Input alphabet: " + this.inputAlphabet + "\n");
            for (int i = 0; i < this.states.getSize(); i++) {
                result.append(this.states.get(i).getName() + " -> ");
                for (int p = 0; p < this.states.get(i).getTransitions().getSize(); p++) {
                    result.append("(" + this.states.get(i).getTransitions().get(p).getKey() + ", " + this.states.get(i).getTransitions().get(p).getValue()+ ")   ");
                }
                result.append("\n");
            }
        }
        return result.toString();
    }
}
