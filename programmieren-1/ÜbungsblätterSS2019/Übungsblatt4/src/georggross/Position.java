package georggross;

public class Position {
    private int xPos;
    private int yPos;
    private Stone stone;
    private String name;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.stone = null;
        this.name = Integer.toString(xPos) + Integer.toString(yPos);
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public Stone getStone() {
        return stone;
    }

    public String getName() {
        return name;
    }


}
