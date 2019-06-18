public class Light {
    private boolean isOn;

    public Light(boolean isOn) {
        this.isOn = isOn;
    }

    public void pushButton(){
        isOn = !isOn;
    }

    public boolean getIsOn(){
        return this.isOn;
    }

}
