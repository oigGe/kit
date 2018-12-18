public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        ListElement one = new ListElement(1);
        ListElement two = new ListElement(2);
        ListElement three = new ListElement(3);
        ListElement four = new ListElement(4);
        ListElement five = new ListElement(5);
        ListElement six = new ListElement(6);



        LinkedList.Iterator it = l.iterator();

        l.add(six);
        l.add(three);
        System.out.println(it.hasNext());
        l.add(five);
        l.add(one);

//        System.out.println(it.hasNext());
//        System.out.println("lala" +it.next().getElement());

        while (it.hasNext()){
            ListElement v = it.next();
            System.out.println(v.getElement());
        }
//        System.out.println(it.hasNext());

    }
}
