import edu.kit.informatik.Terminal;

public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();


        while (true) {
            String input = Terminal.readLine();
            if (input.equals("quit")) {
                return;
            } else if (input.contains(" ")) {
                String[] parts = input.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];
                int inputValue = Integer.parseInt(part2);

                if (part1.equals("add")) {
                    l.add(new ListElement(inputValue));
                }

                if (part1.equals("get")) {
                    l.getElementAtIndex(l, inputValue);
                }
                if (part1.equals("indexOf")) {
                    l.giveIndexOf(l, inputValue);
                }

                if (part1.equals("lastIndexOf")) {
                    l.giveLastIndexOf(l, inputValue);
                }

                if (part1.equals("remove")) {
                    l.remove(inputValue);
                }

                if (part1.equals("contains")) {
                    l.contains(inputValue);
                }

            } else {
                if (input.equals("print")) {
                    l.print(l);
                } else if (input.equals("size")) {
                    l.giveSize(l);
                } else if (input.equals("isEmpty")) {
                    l.isEmpty(l);
                } else if (input.equals("clear")) {
                    l.clear();
                }
            }

        }

    }
}
