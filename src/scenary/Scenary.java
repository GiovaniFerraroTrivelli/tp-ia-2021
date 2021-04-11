package scenary;

import java.awt.*;
import java.util.ArrayList;

import static constants.Constants.*;

public abstract class Scenary {
    protected int[][] forest;
    protected ArrayList<Point> flowersPosition;
    protected Point wolfPosition;
    protected Point caperucitaPosition;
    protected Integer cakesTotal;

    public void initializeScenary(int[][] forest) {
        for (int i = 0; i < SCENARY_HEIGHT; i++) {
            for (int j = 0; j < SCENARY_WIDTH; j++) {
                switch (forest[i][j]) {
                    case SCENARY_CAKE -> this.cakesTotal++;
                    case SCENARY_FLOWER -> flowersPosition.add(new Point(j, i));
                    case SCENARY_CAPERUCITA -> caperucitaPosition = new Point(j, i);
                    case SCENARY_WOLF -> wolfPosition = new Point(j, i);
                }
            }
        }
    }

    public int[][] getForest() {
        return forest;
    }

    public ArrayList<Point> getFlowersPosition() {
        return flowersPosition;
    }

    public Point getWolfPosition() {
        return wolfPosition;
    }

    public Point getCaperucitaPosition() {
        return caperucitaPosition;
    }

    public Integer getCakesTotal() {
        return cakesTotal;
    }
}
