public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(1);
        l.add(5);
        l.add(4);
        l.add(-2);
        l.add(10);
        l.add(10);
        l.add(-10);
        l.add(-10);
        l.add(-10);
        l.add(-10);
        l.add(-1);
        l.add(10);
        l.add(-100);
        l.add(4);
        l.add(100);
        l.add(-1);
        l.add(100);
        l.add(30);
        l.add(99);
        l.add(-100);
        l.add(3);







        LinkedList.Iterator it = l.iterator();

        System.out.println("Iterator: ");
        while (it.hasNext()) {
            int v = it.next();
            System.out.println(v);


    }


}}
