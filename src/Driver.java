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
        inputAlphB.add("L");
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

    public static void testCaseC() {
        //c
        ArrayList<String> inputAlphC = new ArrayList<>();
        inputAlphC.add("a");
        inputAlphC.add("b");
        inputAlphC.add("L");
        LinkedHashSet<Integer> finalVars = new LinkedHashSet<>();
        finalVars.add(1);
        NFA c = new NFA(0, finalVars, inputAlphC, true);

        ArrayList<Pair<String, LinkedHashSet<Integer>>> tempArray = new ArrayList<>();
        LinkedHashSet<Integer> tempSet = new LinkedHashSet<>();
        tempSet.add(0);
        tempSet.add(1);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        tempArray.add(new Pair<>("L", null));
        c.addState(new State(0, false, tempArray));


        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(1);
        tempSet.add(2);
        tempArray.add(new Pair<>("a", null));
        tempArray.add(new Pair<>("b", tempSet));
        tempArray.add(new Pair<>("L", tempSet));
        c.addState(new State(1, true, tempArray));

        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(2);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        tempArray.add(new Pair<>("L", null));
        c.addState(new State(2, false, tempArray));

        System.out.println(c);
        System.out.println(c.transformToDFA());
    }

    public static void testCaseD() {
        //d
        ArrayList<String> inputAlphA = new ArrayList<>();
        inputAlphA.add("a");
        inputAlphA.add("b");
        LinkedHashSet<Integer> finalVars = new LinkedHashSet<>();
        finalVars.add(1);
        NFA d = new NFA(0, finalVars, inputAlphA, false);

        ArrayList<Pair<String, LinkedHashSet<Integer>>> tempArray = new ArrayList<>();
        LinkedHashSet<Integer> tempSet = new LinkedHashSet<>();
        tempSet.add(0);
        tempSet.add(1);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", null));
        d.addState(new State(0, false, tempArray));


        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(2);
        tempArray.add(new Pair<>("a", tempSet));
        tempArray.add(new Pair<>("b", tempSet));
        d.addState(new State(1, true, tempArray));

        tempArray = new ArrayList<>();
        tempSet = new LinkedHashSet<>();
        tempSet.add(2);
        tempArray.add(new Pair<>("a", null));
        tempArray.add(new Pair<>("b", tempSet));
        d.addState(new State(2, false, tempArray));

        System.out.println(d);
        System.out.println(d.transformToDFA());
    }

    public static void main(String[] args) {
        System.out.println("Test case A:");
        testCaseA();
        System.out.println("Test case B:");
        testCaseB();
        System.out.println("Test case C");
        testCaseC();
        System.out.println("Test case D");
        testCaseD();
    }
}
