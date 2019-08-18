package grid;

import player.Player;
import stones.Stone;

import java.util.ArrayList;

public class Position {
    private String name;
    private Position[] edges;
    private int xPos;
    private int yPos;
    private ArrayList<Stone> stones;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = xPos + " " + yPos;
        this.edges = new Position[6];
        this.stones = new ArrayList<>();
    }

    public void setEdges() {
        Position edge1 = getEdge(this.xPos + 1, this.yPos - 1);
        Position edge2 = getEdge(this.xPos + 1, this.yPos);
        Position edge3 = getEdge(this.xPos, this.yPos + 1);
        Position edge4 = getEdge(this.xPos - 1, this.yPos + 1);
        Position edge5 = getEdge(this.xPos - 1, this.yPos);
        Position edge6 = getEdge(this.xPos, this.yPos - 1);

        if (edge1 != null) {
            edges[0] = edge1;
        }
        if (edge2 != null) {
            edges[1] = edge2;
        }
        if (edge3 != null) {
            edges[2] = edge3;
        }
        if (edge4 != null) {
            edges[3] = edge4;
        }
        if (edge5 != null) {
            edges[4] = edge5;
        }
        if (edge6 != null) {
            edges[5] = edge6;
        }
    }


    private Position getEdge(int xPos, int yPos) {
        return Grid.getInstance().getPosition(xPos, yPos);
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

    public Stone getHighestStone() {
        if (!hasStone()) {
            return null;
        }
        return stones.get(stones.size() - 1);
    }

    public ArrayList<Stone> getStones() {
        return stones;
    }

    public void addStone(Stone stone) {
        this.stones.add(stone);
    }

    public void removeStone(Stone stone) {
        this.stones.remove(stone);
    }

    public boolean hasStone() {
        return stones.size() > 0;
    }

    public boolean hasSurroundingOpponent(Player player) {
        for (Position position : edges) {
//            Position is at the edge of field
            if (position == null) {
                continue;
            }
//            No stone on position
            if (!position.hasStone()) {
                continue;
            }
            if (!position.getHighestStone().getPlayer().equals(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSurroundingStone() {
        for (Position position : edges) {
            if (position == null) {
                continue;
            }
            if (position.hasStone()) {
                return true;
            }
        }
        return false;
    }

    public int getSurroundingStoneCount() {
        int count = 0;
        for (Position position : edges) {
            if (position.hasStone()) {
                count++;
            }
        }
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position[] getEdges() {
        return edges;
    }

    public void setEdges(Position[] edges) {
        this.edges = edges;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
