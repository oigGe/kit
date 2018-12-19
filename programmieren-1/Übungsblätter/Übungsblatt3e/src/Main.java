public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 1000; i++){
            l.add((int)(Math.random()*-1000)+(int)(Math.random()*1000));
        }








        LinkedList.Iterator it = l.iterator();

        System.out.println("Iterator: ");
        while (it.hasNext()) {
            int v = it.next();
            System.out.println(v);


    }


}}
