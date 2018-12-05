public class TruncatedCone {
    public static void main(String[] args) {
// get values
        int baseRadius = Integer.parseInt(args[0]);
        int topSurfaceRadius = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
// get slant height, which is needed to calculate the lateral surface area and th surface
        double slantHeight = calculateSlantHeight(baseRadius, topSurfaceRadius, height);
// print the result
        System.out.println(calculateVolume(baseRadius, topSurfaceRadius, height) + ";" + calculateSurface(baseRadius, topSurfaceRadius, slantHeight)
                + ";" + calculateLateralSurfaceArea(baseRadius, topSurfaceRadius, slantHeight) + ";" + slantHeight);

    }
// all private because they are local auxiliary methods.
// calculate volume
    private static double calculateVolume(double R, double r, double h) {
        double volume = ((h * Math.PI) / 3) * (Math.pow((R), 2) + R * r + Math.pow((r), 2));
        return volume;
    }
// calculate slant height
    private static double calculateSlantHeight(double R, double r, double h) {
        double slantHeight = Math.sqrt(Math.pow((R - r), 2) + Math.pow(h, 2));
        return slantHeight;
    }
// calculate surface area
    private static double calculateSurface(double R, double r, double slantHeight) {
        double surface = (Math.PI * (Math.pow((R), 2))) + (Math.PI * Math.pow((r), 2)) + ((R + r) * Math.PI * slantHeight);
        return surface;
    }
// calculate lateral surface area
    private static double calculateLateralSurfaceArea(double R, double r, double slantHeight) {
        double lateralSurfaceArea = (R + r) * Math.PI * slantHeight;
        return lateralSurfaceArea;
    }

}