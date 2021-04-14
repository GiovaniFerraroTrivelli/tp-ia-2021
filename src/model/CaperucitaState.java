package model;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import scenary.Scenary;

import java.awt.*;
import java.util.ArrayList;

import static constants.Constants.SCENARY_HEIGHT;
import static constants.Constants.SCENARY_WIDTH;
import static java.util.stream.Collectors.toList;

public class CaperucitaState extends SearchBasedAgentState {
    private Point posicionActual;
    private Integer vidas;
    private Integer tortas;
    private ArrayList<Point> flowersPositions;

    private int[] filaActual;
    private int[] columnaActual;

    private Point POSICION_INICIAL;
    private Scenary scenary;

    public CaperucitaState() {
    }

    public CaperucitaState(Scenary scenary) {
        this.scenary = scenary;

        this.filaActual = new int[SCENARY_WIDTH];
        this.columnaActual = new int[SCENARY_HEIGHT];

        this.flowersPositions = scenary.getFlowersPosition();
        this.posicionActual = scenary.getCaperucitaPosition();
        this.POSICION_INICIAL = scenary.getCaperucitaPosition();

        this.initState();
    }

    @Override
    public boolean equals(Object obj) {
        CaperucitaState estadoComparado = (CaperucitaState) obj;

        boolean posicionX = estadoComparado.posicionActual.x == this.posicionActual.x;
        boolean posicionY = estadoComparado.posicionActual.y == this.posicionActual.y;
        boolean vidas = estadoComparado.vidas.equals(this.vidas);
        boolean tortas = estadoComparado.tortas.equals(this.tortas);

        return (posicionX && posicionY && vidas && tortas);
    }

    @Override
    public SearchBasedAgentState clone() {
        CaperucitaState caperucitaState = new CaperucitaState(this.scenary);
        caperucitaState.flowersPositions = this.flowersPositions;
        caperucitaState.vidas = this.vidas;
        caperucitaState.tortas = this.tortas;
        System.arraycopy(this.filaActual, 0, caperucitaState.filaActual, 0, this.filaActual.length);
        System.arraycopy(this.columnaActual, 0, caperucitaState.columnaActual, 0, this.columnaActual.length);
        caperucitaState.posicionActual = new Point(this.posicionActual.x, this.posicionActual.y);

        return caperucitaState;
    }

    @Override
    public void updateState(Perception p) {
        CaperucitaPerception perception = (CaperucitaPerception) p;

        this.filaActual = perception.getScenary()[this.posicionActual.y];

        for(int i = 0; i < SCENARY_HEIGHT; i++) {
            this.columnaActual[i] = perception.getScenary()[i][this.posicionActual.x];
        }

        /*this.filaActual = perception.getFilaActual();
        this.columnaActual = perception.getColumnaActual();*/
    }

    @Override
    public String toString() {
        return "Estado Caperucita [x=" + this.posicionActual.x + ", y=" + this.posicionActual.y + "] [tortas=" + this.tortas + ", vidas=" + this.vidas + "]";
    }

    @Override
    public void initState() {
        this.vidas = 3;
        this.tortas = 0;
    }

    public Point getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Point posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Integer getVidas() {
        return vidas;
    }

    public void setVidas(Integer vidas) {
        this.vidas = vidas;
    }

    public Integer getTortas() {
        return tortas;
    }

    public void setTortas(Integer tortas) {
        this.tortas = tortas;
    }

    public void deathRespawn() {
        this.setPosicionActual(this.getPosicionInicial());
        this.setTortas(0);
        this.setVidas(this.vidas - 1);
    }

    public Point getPosicionInicial() {
        return POSICION_INICIAL;
    }

    public ArrayList<Point> getFlowersPositions() {
        return flowersPositions;
    }

    public int[] getFilaActual() {
        return filaActual;
    }

    public void setFilaActual(int[] filaActual) {
        this.filaActual = filaActual;
    }

    public int[] getColumnaActual() {
        return columnaActual;
    }

    public void setColumnaActual(int[] columnaActual) {
        this.columnaActual = columnaActual;
    }

    public void setFlowersPositions(ArrayList<Point> flowersPositions) {
        this.flowersPositions = flowersPositions;
    }

}
