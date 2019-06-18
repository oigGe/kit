public class TrafficLight {
    private Light greenLight;
    private Light redLight;


    public TrafficLight() {
        this.greenLight = new Light(false);
        this.redLight = new Light(true);
    }

    public void switchLight(){
        greenLight.pushButton();
        redLight.pushButton();
    }

    public boolean isGreen(){
        return greenLight.getIsOn();
    }
}
