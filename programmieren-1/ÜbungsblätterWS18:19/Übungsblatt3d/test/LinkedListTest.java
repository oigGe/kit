import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void canCreateEmptyList() {
        LinkedList l = new LinkedList();
    }

    @Test
    public void canAddElementsToList() {
        LinkedList l = new LinkedList();
        l.add(new ListElement(1));
        l.add(new ListElement(2));
        l.add(new ListElement(3));
    }
}