public class Crossroads {
    private TrafficLight trafficLight0;
    private TrafficLight trafficLight1;
    private TrafficLight trafficLight2;
    private TrafficLight trafficLight3;

    public Crossroads() {
        this.trafficLight0 = new TrafficLight();
        this.trafficLight1 = new TrafficLight();
        this.trafficLight2 = new TrafficLight();
        this.trafficLight3 = new TrafficLight();
        trafficLight0.switchLight();
        trafficLight1.switchLight();
    }

    public void switchTrafficLights(){
        trafficLight0.switchLight();
        trafficLight1.switchLight();
        trafficLight2.switchLight();
        trafficLight3.switchLight();
    }


    public boolean isSafe(int Id){
        TrafficLight[] trafficLights = new TrafficLight[]{trafficLight0,trafficLight1,trafficLight2,trafficLight3};
        return trafficLights[Id].isGreen();
    }
}
