import edu.kit.informatik.Terminal;

public class LinkedList {
    private class ListCell {
        public ListElement element;
        public ListCell next;
        private ListCell firstCell;


        public ListCell(ListElement element, ListCell next) {
            this.element = element;
            this.next = next;
        }

        public ListElement getElement() {
            return element;
        }

        public void setElement(ListElement element) {
            this.element = element;
        }

        public ListCell getNext() {
            return next;
        }

        public void setNext(ListCell next) {
            this.next = next;
        }
    }

    private ListCell head;
    private static ListCell firstListCell;
    private static int min;
    private static int max;

//    constructor
    public LinkedList() {
        this.head = null;
    }

    public void add(ListElement element) {

        int newValue = element.getValue();

        if (this.head == null) {

            max = newValue;
            min = newValue;
            addVeryFirst(element);

        } else if (newValue <= min) {

            min = newValue;
            addFirst(element);
        } else if (newValue >= max) {

            max = newValue;
            addLast(element);
        } else {

            int thisValue = this.head.element.getValue();
            ListCell temp = this.head;
            ListCell loopTemp = this.head;
            while (newValue > thisValue) {

                loopTemp = this.head;
                this.head = this.head.next;
                thisValue = this.head.element.getValue();

            }

            this.head = loopTemp;
            addBetween(element);
            this.head = temp;
        }


    }

    public void addVeryFirst(ListElement element) {

        ListCell newHead = new ListCell(element, null);
        this.head = newHead;
        firstListCell = newHead;
        giveIndex();


    }

    public void addFirst(ListElement element) {

        ListCell newHead = new ListCell(element, this.head);
        this.head = newHead;
        firstListCell = newHead;
        giveIndex();
    }

    public void addLast(ListElement element) {

        ListCell c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        c.next = new ListCell(element, null);
        giveIndex();

    }

    public void addBetween(ListElement element) {
        ListCell temp = new ListCell(element, this.head.getNext());
        this.head.setNext(temp);
        giveIndex();


    }

    public void giveSize(LinkedList list) {

        LinkedList.Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += 1;
            it.next();
        }
        Terminal.printLine(size);
    }

    public void giveIndex() {

        ListCell current = firstListCell;
        int count = 0;
        while (current != null) {
            current.element.setIndex(count);
            count++;
            current = current.next;
        }
    }

    public void print(LinkedList l) {
        LinkedList.Iterator it = l.iterator();

        String list = "";
        while (it.hasNext()) {
            list += it.next().getValue();
            if (it.hasNext()) {
                list += ",";

            }
        }
        Terminal.printLine("[" + list + "]");
    }

    public void isEmpty(LinkedList list) {
        LinkedList.Iterator it = list.iterator();
        boolean empty = true;
        if (it.hasNext()) {
            empty = false;
        }
        Terminal.printLine(empty);
    }

    public void clear() {
        this.head = null;
    }

    public void getElementAtIndex(LinkedList list, int whichIndex) {

        LinkedList.Iterator it = list.iterator();

        while (it.cursor.getElement().getIndex() < whichIndex) {
            it.next();
        }
        Terminal.printLine(it.cursor.getElement().getValue());

    }

    public void giveIndexOf(LinkedList list, int whichValue) {

        LinkedList.Iterator it = list.iterator();
        boolean flag = true;
//        check if empty list
        if (!it.hasNext()) {
            flag = false;
            Terminal.printLine("-1");
        }
        outerLooP:
        while (flag) {
//            look for occurence
            while (it.cursor.getElement().getValue() < whichValue) {
                it.next();

                if (it.cursor == null) {
                    Terminal.printLine("-1");
                    break outerLooP;
                }
            }
            if (it.cursor.getElement().getValue() == whichValue) {
                Terminal.printLine(it.cursor.getElement().getIndex());
            } else {
                Terminal.printLine("-1");
            }
            break outerLooP;
        }
    }

    public void giveLastIndexOf(LinkedList list, int whichValue) {
        LinkedList.Iterator it = list.iterator();
        boolean flag = true;
//        check if empty list
        if (!it.hasNext()) {
            flag = false;
            Terminal.printLine("-1");
        }
        outerLooP:
        while (flag) {
//           Look for the element
            while (it.cursor.getElement().getValue() < whichValue) {

                it.next();

                if (it.cursor == null) {
                    Terminal.printLine("-1");
                    break outerLooP;
                }
            }
//            look for repeating occurrences
            if (it.cursor.getElement().getValue() == whichValue) {
                while (it.cursor.getElement().getValue() == whichValue
                        && it.cursor.getNext() != null && it.cursor.getNext().getElement().getValue() == whichValue) {
                    it.next();
                }
                Terminal.printLine(it.cursor.getElement().getIndex());
            } else {
                Terminal.printLine("-1");
            }
            break outerLooP;
        }

    }

    public void remove(int whichValue) {

        ListCell c = this.head;
//remove head. print true
        if (c != null && c.getElement().getValue() == whichValue) {
            this.head = c = c.getNext();
            Terminal.printLine("true");
            return;

        }
//  check for empty list
        if (c == null) {
            Terminal.printLine("false");
            return;
        }
//  check for occurrences and delete them. print true
        while (c.getNext() != null) {
            if (c.getNext().getElement().getValue() == whichValue) {
                c.setNext(c.getNext().getNext());
                Terminal.printLine("true");
                return;
            } else {
                c = c.getNext();
            }
        }

    }

    public void contains(int whichValue) {
//  check for empty list
        if (this.head == null) {
            Terminal.printLine("false");
            return;
        }
// check for occurrences
        for (ListCell c = head; c != null; c = c.getNext()) {
            if (c.getElement().getValue() == whichValue) {
                Terminal.printLine("true");
            } else {
                Terminal.printLine("false");
            }
        }
    }

//  Iterator
    public class Iterator {
        private ListCell cursor;

        private Iterator(ListCell start) {
            this.cursor = start;
        }
//  hasNext method to check if next ListElement exists
        public boolean hasNext() {
            return (this.cursor != null);
        }
// next method to get the current content and go to the next ListElement
        public ListElement next() {
            ListElement currentContent = this.cursor.getElement();
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }


}