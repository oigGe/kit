public class Main {
    public static void main(String[] args) {

        LinkedList myList = new LinkedList();
        Content one = new Content(1);
        Content two = new Content(2);
        Content three = new Content(3);

        myList.addFirst(one);
        myList.addFirst(three);


        LinkedList.Iterator it = myList.iterator();

////        it.next();
//        System.out.println(it.hasNext());
//
//        myList.addFirst(two);
//        System.out.println(it.hasNext());
//
//        it.next();
//        System.out.println(it.hasNext());


        while (it.hasNext()){
            Content v = it.next();
            System.out.println(v.getContent());

        }


    }

}

