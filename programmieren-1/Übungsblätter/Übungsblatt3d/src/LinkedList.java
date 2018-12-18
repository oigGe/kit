public class LinkedList {


    private class ListCell {
        public ListElement element;
        public ListCell next;
        public ListCell prev;


        public ListCell(ListElement element, ListCell prev, ListCell next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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

        public ListCell getPrev() {
            return prev;
        }

        public void setPrev(ListCell prev) {
            this.prev = prev;
        }
    }

    private ListCell head;
    private static ListCell firstListCell;
    private static ListCell lastListCell;
    private static int min;
    private static int max;
    int getMax = 0;
    int getMin = 999;

    public LinkedList() {
        this.head = null;
    }


    public void addFirst(ListElement element) {
        ListCell newHead = new ListCell(element, null, null);
        this.head = newHead;
        firstListCell = this.head;

        System.out.println("addFirst called");
    }

    public void addLast(ListElement element) {
        if (this.head == null) {
            this.head = new ListCell(element, null, null);
            System.out.println("this shouldnt happen");
            return;
        }
        ListCell c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        c.next = new ListCell(element, c, null);
        lastListCell = this.head;

        System.out.println("addLast called");
    }

    public void addBetween(ListElement element) {
        ListCell tempNext = this.head.getNext();
        ListCell tempPrev = this.head.getPrev();
        this.head.setNext(new ListCell(element, tempPrev, tempNext));
        this.head = this.head.getNext();
        System.out.println("addBetween called");

    }


    public void add(ListElement e) {
        int newValue = e.getElement();
        System.out.println("Input value: " + newValue);

        if (this.head == null) {
            max = newValue;
            min = newValue;
            getMin = min;
            getMax = max;
            System.out.println("addFirst expected");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addFirst(e);
        } else if (e.getElement() <= min) {
            min = newValue;
            getMin = min;
            System.out.println("add first expected because input smaller than min");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addFirst(e);
        } else if (newValue > max) {
            max = newValue;
            getMax = max;
            System.out.println("addLast expected");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addLast(e);
        } else {
            System.out.println("add between expected because input inbetween min and max");
            int thisValue = this.head.element.getElement();
            ListCell c = this.head;
            while (newValue <= thisValue) {
                c = c.next;
            }
            addBetween(e);
        }
    }


//    public void insert(ListElement element, LinkedList l) {
//
//        int newValue = element.getElement();
//
//
//        //1.Fall: Die Liste ist leer
//        if (this.head == null) {
//            this.head = new ListCell(element, null, null);
////            firstListCell = this.head;
//            return;
//        }
////Die Liste ist nicht leer. Wir gehen solange durch, bis unser input wert groesser ist, als die vorherigen listenwerte.
//        else {
////            int elementValue = this.head.element.getElement();
////            while (newValue <= elementValue && this.head.next != null) {
////                elementValue = this.head.element.getElement();
////                this.head = this.head.next;
//////          Wir sind nun an dem Punkt an dem die folgenden Listeneinträge grösser sind als unser inputwert.
////            }
//
//            ListCell c = this.head;
//            while (c.next != null) {
//                c = c.next;
//            }
//            c.next = new ListCell(element, null, null);
//        }
//
////        //2.Fall Wir hängen einen Knoten hinten an
////        if (this.head.next == null) {
////            this.head.setNext(new ListCell(element, null));
//////                lastListCell = this.head.getNext();
//////                this.head = lastListCell;
////        } else  {
////            //3.Fall Wir fügen eine Knoten zwischen zwei existierenden Knoten ein.
////            ListCell tempNext = this.head.getNext();
////            this.head.setNext(new ListCell(element, tempNext));
////            this.head = this.head.getNext();
////
////        }
//    }


    public class Iterator {
        private ListCell cursor;

        private Iterator(ListCell start) {
            this.cursor = start;
        }

        public boolean hasNext() {
            return (this.cursor != null);
        }

        public ListElement next() {
            ListElement currentContent = this.cursor.element;
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }
}
