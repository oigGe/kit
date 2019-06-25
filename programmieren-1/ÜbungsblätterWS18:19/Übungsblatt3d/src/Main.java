public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();


        ListElement one = new ListElement(1);
        ListElement two = new ListElement(2);
        ListElement three = new ListElement(3);
        ListElement four = new ListElement(4);
        ListElement five = new ListElement(5);
        ListElement six = new ListElement(6);


//        l.add(four);
//        l.add(three);
//        l.add(two);
//        l.add(five);
//        l.add(one);
//        l.add(six);

        l.add(two);
        l.add(five);
        l.add(three);


//        l.add(four);
//        l.add(five);
//        l.add(three);
//        l.add(six);
//        l.add(two);
//        l.add(four);


        LinkedList.Iterator it = l.iterator();

        System.out.println("Iterator: ");
        while (it.hasNext()) {
            ListElement v = it.next();
            System.out.println(v.getElement());
        }
//        System.out.println(it.hasNext());

    }
}
