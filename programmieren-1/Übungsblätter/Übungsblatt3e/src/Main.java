public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 1000; i++){
            l.add(new ListElement((int)(Math.random()*100)));
        }







        LinkedList.Iterator it = l.iterator();

        System.out.println("Iterator: ");
        while (it.hasNext()) {
             ListElement v = it.next();
            System.out.println(v.getIndex() + ": " + v.getValue());


    }


}}
