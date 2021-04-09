package model;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

import java.awt.*;

public class CaperucitaState extends SearchBasedAgentState {
    private Point posicionActual;
    private Integer vidas;
    private Integer tortas;
    private CaperucitaPerception perceptionActual;

    private final Point POSICION_INICIAL = null;

    public CaperucitaState() {
        this.initState();


    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public SearchBasedAgentState clone() {
        // TODO Auto-generated method stub
        CaperucitaState caperucitaState = new CaperucitaState();


        return caperucitaState;
    }

    @Override
    public void updateState(Perception p) {
        // TODO Auto-generated method stub

        CaperucitaPerception perception = (CaperucitaPerception) p;

        int tortasDerecha, tortasIzquierda, tortasArriba, tortasAbajo;
        tortasDerecha = perception.getCantidadTortasDerecha();
        tortasIzquierda = perception.getCantidadTortasIzquierda();
        tortasArriba = perception.getCantidadTortasArriba();
        tortasAbajo = perception.getCantidadTortasAbajo();


    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initState() {
        // TODO Auto-generated method stub
        this.posicionActual = null;
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

    public CaperucitaPerception getPerceptionActual() { return perceptionActual; }

    public void setPerceptionActual(CaperucitaPerception perceptionActual) { this.perceptionActual = perceptionActual; }

    public Point getPOSICION_INICIAL() { return POSICION_INICIAL; }
}
