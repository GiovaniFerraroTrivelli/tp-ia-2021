package model;

import frsf.cidisi.faia.state.EnvironmentState;
import scenary.Scenary;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static constants.Constants.*;

public class CaperucitaEnvironmentState extends EnvironmentState {
    private int[][] initialForest;
    private int[][] currentForest;
    private Point wolfPosition;
    private Point caperucitaPosition;
    private ArrayList<Point> wolfSpawnPoints;
    private Point wolfInitialPosition;
    public boolean isCaperucitaDead;

    public CaperucitaEnvironmentState(Scenary scenary) {
        currentForest = scenary.getForest();
        wolfPosition = scenary.getWolfPosition();
        caperucitaPosition = scenary.getCaperucitaPosition();
        wolfSpawnPoints = scenary.getWolfSpawnPoints();
        wolfInitialPosition = new Point(wolfPosition.x, wolfPosition.y);
        initialForest = scenary.getInicialForest();
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

    public int[][] getCurrentForest() {
        return currentForest;
    }

    public void setCurrentForest(int[][] currentForest) {
        this.currentForest = currentForest;
    }

    public void moveWolf() {
        int[][] newForest = this.currentForest.clone();
        newForest[this.wolfPosition.y][this.wolfPosition.x] = 0;
        do {
            this.wolfPosition = this.wolfSpawnPoints.get(new Random().nextInt(this.wolfSpawnPoints.size()));
        }
        while(this.wolfPosition.equals(this.caperucitaPosition));
        newForest[this.wolfPosition.y][this.wolfPosition.x] = SCENARY_WOLF;
        this.setScenary(newForest);
    }

    public Point getWolfInitialPosition() {
        return wolfInitialPosition;
    }

    public void setWolfInitialPosition(Point wolfInitialPosition) {
        this.wolfInitialPosition = wolfInitialPosition;
    }

    public boolean isCaperucitaDead() {
        return isCaperucitaDead;
    }

    public void setCaperucitaDead(boolean caperucitaDead) {
        isCaperucitaDead = caperucitaDead;
    }

    public int[][] getInitialForest() {
        return initialForest;
    }

    public void setInitialForest(int[][] initialForest) {
        this.initialForest = initialForest;
    }

    @Override
    public void initState() {
    }

    @Override
    public String toString() {
        return "Posicion Lobo [x=" + this.wolfPosition.x + ", y=" + this.wolfPosition.y + "]\n";
    }
}
