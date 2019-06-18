public class Main {
    public static void main(String[] args) {

      Crossroads crossroads = new Crossroads();
        System.out.println(crossroads.isSafe(0));
        System.out.println(crossroads.isSafe(1));
        System.out.println(crossroads.isSafe(2));
        System.out.println(crossroads.isSafe(3));
        crossroads.switchTrafficLights();
        System.out.println("_______________________");
        System.out.println(crossroads.isSafe(0));
        System.out.println(crossroads.isSafe(1));
        System.out.println(crossroads.isSafe(2));
        System.out.println(crossroads.isSafe(3));
        crossroads.switchTrafficLights();
        System.out.println("_______________________");
        System.out.println(crossroads.isSafe(0));
        System.out.println(crossroads.isSafe(1));
        System.out.println(crossroads.isSafe(2));
        System.out.println(crossroads.isSafe(3));
    }
}
