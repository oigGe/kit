package board;

public class Position {
    private String name;
    private Position[] edges;
    private int xPos;
    private int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = xPos + " " + yPos;
    }

    public void setEdges() {
        Position edge1 = getEdge(this.xPos + 1, this.yPos - 1);
        Position edge2 = getEdge(this.xPos + 1, this.yPos);
        Position edge3 = getEdge(this.xPos, this.yPos + 1);
        Position edge4 = getEdge(this.xPos - 1, this.yPos + 1);
        Position edge5 = getEdge(this.xPos - 1, this.yPos);
        Position edge6 = getEdge(this.xPos, this.yPos - 1);

        if (edge1 != null){
            edges[0] = edge1;
        }
        if (edge2 != null){
            edges[1] = edge1;
        }
        if (edge3 != null){
            edges[2] = edge1;
        }
        if (edge4 != null){
            edges[3] = edge1;
        }
        if (edge5 != null){
            edges[4] = edge1;
        }
        if (edge6 != null){
            edges[5] = edge1;
        }
















        //        edges[0] = Board.getInstance().getPosition(this.xPos + 1, this.yPos - 1);
//        edges[1] = Board.getInstance().getPosition(this.xPos + 1, this.yPos);
//        edges[2] = Board.getInstance().getPosition(this.xPos, this.yPos + 1);
//        edges[3] = Board.getInstance().getPosition(this.xPos - 1, this.yPos + 1);
//        edges[4] = Board.getInstance().getPosition(this.xPos - 1, this.yPos);
//        edges[5] = Board.getInstance().getPosition(this.xPos, this.yPos - 1);


    }


    private Position getEdge(int xPos, int yPos) {
        return Board.getInstance().getPosition(xPos, yPos);
    }

    public Position getEdge(int edgenumber) {
        if (edgenumber >= 1 && edgenumber <= 6) {
            return edges[edgenumber - 1];
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
