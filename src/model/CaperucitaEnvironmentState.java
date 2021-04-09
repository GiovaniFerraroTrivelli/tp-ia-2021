package model;

import frsf.cidisi.faia.state.EnvironmentState;

import java.awt.*;

public class CaperucitaEnvironmentState extends EnvironmentState {

    public static final int SCENARY_WIDTH = 20;
    public static final int SCENARY_HEIGHT = 20;

    private final int[][] INITIAL_SCENARY = new int[SCENARY_HEIGHT][SCENARY_WIDTH];
    private int[][] scenary = INITIAL_SCENARY;
    private Point wolfPosition;
    private Point caperucitaPosition;


    public int[][] getScenary() {
        return scenary;
    }

    public void setScenary(int[][] scenary) {
        this.scenary = scenary;
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

    public int[][] getINITIAL_SCENARY() { return INITIAL_SCENARY; }

    @Override
    public void initState() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
