package iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        stringList.add("fourth");
        stringList.add("fifth");

        Iterator<String> iterator = new MyIterator<>(stringList);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class MyIterator<T> implements Iterator<T> {

    private List<T> myList;
    private int currentIndex = 0;

    public MyIterator(List<T> myList) {
        this.myList = myList;
    }

    @Override
    public boolean hasNext() {
        if (myList.isEmpty()) {
            return false;
        }
        if (currentIndex + 1 <= myList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return myList.get(currentIndex++);
        } else {
            return null;
        }
    }
}