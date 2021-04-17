package model;

import frsf.cidisi.faia.state.EnvironmentState;
import scenary.Scenary;

import java.awt.*;

import static constants.Constants.SCENARY_HEIGHT;
import static constants.Constants.SCENARY_WIDTH;

public class CaperucitaEnvironmentState extends EnvironmentState {
    private final int[][] INITIAL_FOREST = new int[SCENARY_HEIGHT][SCENARY_WIDTH];
    private int[][] currentForest = INITIAL_FOREST;
    private Point wolfPosition;
    private Point caperucitaPosition;

    public CaperucitaEnvironmentState(Scenary scenary) {
        currentForest = scenary.getForest();
        wolfPosition = scenary.getWolfPosition();
        caperucitaPosition = scenary.getCaperucitaPosition();
    }

    public int[][] getForest() {
        return currentForest;
    }

    public void setScenary(int[][] scenary) {
        this.currentForest = scenary;
    }

    public Point getWolfPosition() {
        return wolfPosition;
    }

    public void setWolfPosition(Point wolfPosition) {
        this.wolfPosition = wolfPosition;
    }

    public Point getCaperucitaPosition() {
        return caperucitaPosition;
    }

    public void setCaperucitaPosition(Point caperucitaPosition) {
        this.caperucitaPosition = caperucitaPosition;
    }

    public int[][] getInicialScenary() {
        return INITIAL_FOREST;
    }

    public int[][] getCurrentForest() {
        return currentForest;
    }

    public void setCurrentForest(int[][] currentForest) {
        this.currentForest = currentForest;
    }

    @Override
    public void initState() {
    }

    @Override
    public String toString() {
        /*StringBuilder matrix = new StringBuilder();

        for (int i = 0; i < SCENARY_HEIGHT; i++) {
            matrix.append("\n").append(currentForest[i][0]);
            for (int j = 1; j < SCENARY_WIDTH; j++) {
                matrix.append(" ").append(currentForest[i][j]);
            }
        }*/

        return ":v";//matrix.toString();
    }
}
