import javafx.util.Pair;

import java.util.LinkedHashSet;

public class Driver {

    public static void main(String[] args) {
        //a
        ArrayList<String> inputAlphA = new ArrayList<>();
        inputAlphA.add("a");
        inputAlphA.add("b");
        LinkedHashSet<Integer> finalVars = new LinkedHashSet<>();
        finalVars.add(1);
        NFA a = new NFA(0, finalVars, inputAlphA);
        ArrayList<Pair<String, LinkedHashSet<Integer>>> tempArray = new ArrayList<>();
        LinkedHashSet<Integer> tempSet = new LinkedHashSet<>();
        tempSet.add(0);
        tempSet.add(1);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        a.addState(new State(0, false, tempArray));


        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(1);
        tempSet.add(2);
        tempArray.add(new Pair<>("a", null));
        tempArray.add(new Pair<>("b", tempSet));
        a.addState(new State(1, true, tempArray));

        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(2);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        a.addState(new State(2, false, tempArray));




    }
}
