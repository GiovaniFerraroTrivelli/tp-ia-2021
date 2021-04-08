package model;

import frsf.cidisi.faia.state.EnvironmentState;

import java.awt.*;
import java.util.ArrayList;

public class CaperucitaEnvironmentState extends EnvironmentState {

    private ArrayList<Point> cakesPositions;
    private ArrayList<Point> flowersPositions;
    private ArrayList<Point> treesPositions;
    private Point wolfPosition;
    private Point caperucitaPosition;

    private final Point POSICION_INICIAL = null;

    public ArrayList<Point> getCakesPositions() {
        return cakesPositions;
    }

    public void setCakesPositions(ArrayList<Point> cakesPositions) {
        this.cakesPositions = cakesPositions;
    }

    public ArrayList<Point> getFlowersPositions() {
        return flowersPositions;
    }

    public void setFlowersPositions(ArrayList<Point> flowersPositions) {
        this.flowersPositions = flowersPositions;
    }

    public ArrayList<Point> getTreesPositions() {
        return treesPositions;
    }

    public void setTreesPositions(ArrayList<Point> treesPositions) {
        this.treesPositions = treesPositions;
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

    public Point getPOSICION_INICIAL() {
        return POSICION_INICIAL;
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
