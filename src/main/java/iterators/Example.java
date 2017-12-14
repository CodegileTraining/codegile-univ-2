package iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("abc");
        list.add(Arrays.asList("a", "b", "c"));
        list.add("awesome");
        list.add(Arrays.asList("codegile", "university"));
        list.add(Arrays.asList("ok", Arrays.asList(
                "idee", Arrays.asList(
                        Arrays.asList(
                                "ha", Arrays.asList(
                                        "haha", "hahaha")), "hahahaha", Arrays.asList("hahahahaha")))));

        printFoo(list);
    }

    private static void printFoo(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof List) {
                printInternalFoo((List) list.get(i), "Foo." + i);
            } else {
                System.out.println("Foo." + i + ": " + list.get(i).toString());
            }
        }
    }

    private static void printInternalFoo(List list, String currentString) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof List) {
                printInternalFoo((List) list.get(i), currentString + "." + i);
            } else {
                System.out.println(currentString + "." + i + ": " + list.get(i).toString());
            }
        }
    }
}
