package model;

import frsf.cidisi.faia.state.EnvironmentState;

import java.awt.*;

public class CaperucitaEnvironmentState extends EnvironmentState {

    public static final int SCENARY_WIDTH = 20;
    public static final int SCENARY_HEIGHT = 20;

    private int[][] scenary = new int[SCENARY_HEIGHT][SCENARY_WIDTH];
    private Point wolfPosition;
    private Point caperucitaPosition;

    private final Point POSICION_INICIAL = null;

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
