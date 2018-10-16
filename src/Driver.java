import javafx.util.Pair;
import java.util.LinkedHashSet;

public class Driver {

    public static void testCaseA() {
        //a
        ArrayList<String> inputAlphA = new ArrayList<>();
        inputAlphA.add("a");
        inputAlphA.add("b");
        LinkedHashSet<Integer> finalVars = new LinkedHashSet<>();
        finalVars.add(1);
        NFA a = new NFA(0, finalVars, inputAlphA, false);
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

        System.out.println(a);
        System.out.println(a.transformToDFA());
    }

    public static void testCaseB() {
        //b
        ArrayList<String> inputAlphB = new ArrayList<>();
        inputAlphB.add("a");
        inputAlphB.add("b");
        LinkedHashSet<Integer> finalVars = new LinkedHashSet<>();
        finalVars.add(1);
        NFA b = new NFA(0, finalVars, inputAlphB, true);

        ArrayList<Pair<String, LinkedHashSet<Integer>>> tempArray = new ArrayList<>();
        LinkedHashSet<Integer> tempSet = new LinkedHashSet<>();
        tempSet.add(0);
        tempSet.add(1);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        tempSet = new LinkedHashSet<>();
        tempSet.add(2);
        tempArray.add(new Pair<>("L", tempSet));
        b.addState(new State(0, false, tempArray));


        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(1);
        tempSet.add(2);
        tempArray.add(new Pair<>("a", null));
        tempArray.add(new Pair<>("b", tempSet));
        tempArray.add(new Pair<>("L", null));
        b.addState(new State(1, true, tempArray));

        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(2);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        tempArray.add(new Pair<>("L", null));
        b.addState(new State(2, false, tempArray));

        System.out.println(b);
        System.out.println(b.transformToDFA());
    }

    public static void main(String[] args) {
        testCaseB();
    }
}
