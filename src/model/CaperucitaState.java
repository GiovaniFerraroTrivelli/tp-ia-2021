package model;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import scenary.Scenary;

import java.awt.*;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

public class CaperucitaState extends SearchBasedAgentState {
    private Point posicionActual;
    private Integer vidas;
    private Integer tortas;
    private CaperucitaPerception perceptionActual;
    private ArrayList<Point> flowersPositions;

    private Point POSICION_INICIAL;

    public CaperucitaState() {
    }

    public CaperucitaState(Scenary scenary) {
        this.flowersPositions = scenary.getFlowersPosition();
        this.posicionActual = scenary.getCaperucitaPosition();
        this.POSICION_INICIAL = scenary.getCaperucitaPosition();

        this.initState();
    }

    @Override
    public boolean equals(Object obj) {
        CaperucitaState estadoComparado = (CaperucitaState) obj;

        if (estadoComparado.posicionActual.x != this.posicionActual.x ||
                estadoComparado.posicionActual.y != this.posicionActual.y)
            return false;
        if (!estadoComparado.vidas.equals(this.vidas))
            return false;
        else return estadoComparado.tortas.equals(this.tortas);
    }

    @Override
    public SearchBasedAgentState clone() {
        CaperucitaState caperucitaState = new CaperucitaState();
        caperucitaState.flowersPositions = (ArrayList<Point>) this.flowersPositions.stream().map(Point::new).collect(toList());
        caperucitaState.vidas = this.vidas;
        caperucitaState.tortas = this.tortas;
        caperucitaState.posicionActual = new Point(this.posicionActual.x, this.posicionActual.y);
        caperucitaState.perceptionActual = this.perceptionActual.clone();

        return caperucitaState;
    }

    @Override
    public void updateState(Perception p) {
        CaperucitaPerception perception = (CaperucitaPerception) p;
        this.perceptionActual = perception;
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

    public CaperucitaPerception getPerceptionActual() {
        return perceptionActual;
    }

    public void setPerceptionActual(CaperucitaPerception perceptionActual) {
        this.perceptionActual = perceptionActual;
    }

    public Point getPosicionInicial() {
        return POSICION_INICIAL;
    }

    public ArrayList<Point> getFlowersPositions() {
        return flowersPositions;
    }

    public void setFlowersPositions(ArrayList<Point> flowersPositions) {
        this.flowersPositions = flowersPositions;
    }

}
