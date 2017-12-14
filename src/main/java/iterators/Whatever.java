package iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Whatever<T> {

    T object;

    public Whatever(T object) {
        this.object = object;
    }

    T getObject() {
        return object;
    }
}

class Test {

    public static void main(String[] args) {
        Whatever<Number> w1 = new Whatever<>(2.3D);
        Whatever<Float> w2 = new Whatever<>(4.5F);
        Whatever<Integer> w3 = new Whatever<>(5);

        System.out.println(w1.getObject().getClass());
        System.out.println(w2.getObject().getClass());
        System.out.println(w3.getObject().getClass());

        Collection<? super Integer> something = new ArrayList<Number>();
    }

    private static List<Object> myList = new ArrayList<>();

    private static <T> void doSomething(T object) {
        myList.add(object);
    }
}