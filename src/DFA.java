import java.util.LinkedHashSet;

public class DFA {
    // Output of program is DFA matrix
    // Each cell should be a single state

    private ArrayList<SetOfStates> states;
    private ArrayList<String> inputAlphabet;
    private int startVar;
    private LinkedHashSet<Integer> finalVars;
    private boolean trapStateExists;

    public DFA(int startVar, LinkedHashSet<Integer> finalVars, ArrayList<String> inputAlphabet) {
        this.states = new ArrayList<>();
        this.startVar = startVar;
        this.finalVars = finalVars;
        this.inputAlphabet = inputAlphabet;
        this.trapStateExists = false;
    }

    public void addSetOfStates(SetOfStates newSetOfStates) {
        if (newSetOfStates != null) {
            this.states.add(newSetOfStates);
        }
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.states.getSize() == 0) {
            result.append("DFA\nInput alphabet: " + this.inputAlphabet + "\nNo states");
        }
        else {
            result.append("DFA\nInput alphabet: " + this.inputAlphabet + "\n");
            for (int i = 0; i < this.states.getSize(); i++) {
                result.append(this.states.get(i).toString() + " -> ");
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