public class Main {
    public static void main(String[] args) {
        List list = new List();
        List.Iterator it = list.iterator();
        System.out.println(it.hasNext());
        list.addFirst(22);
        System.out.println(it.hasNext());
        list.addLast(23);
        System.out.println(it.hasNext());
        list.addFirst(21132);
        System.out.println(it.hasNext());
        it.next();
        System.out.println(it.hasNext());

    }
}
