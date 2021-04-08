package model;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CaperucitaPerception extends Perception {

	public static int UNKNOWN_PERCEPTION = -1;
	
	private int cantidadTortasArriba;
	private int cantidadTortasDerecha;
	private int cantidadTortasAbajo;
	private int cantidadTortasIzquierda;
	private int hayFloresArriba;
	private int hayFloresDerecha;
	private int hayFloresAbajo;
	private int hayFloresIzquierda;
	private int hayLoboArriba;
	private int hayLoboDerecha;
	private int hayLoboAbajo;
	private int hayLoboIzquierda;
	private int distanciaArbolArriba;
	private int distanciaArbolDerecha;
	private int distanciaArbolAbajo;
	private int distanciaArbolIzquierda;
	
	public CaperucitaPerception() {
		cantidadTortasArriba = UNKNOWN_PERCEPTION;
		cantidadTortasDerecha = UNKNOWN_PERCEPTION;
		cantidadTortasAbajo = UNKNOWN_PERCEPTION;
		cantidadTortasIzquierda = UNKNOWN_PERCEPTION;
		hayFloresArriba = UNKNOWN_PERCEPTION;
		hayFloresDerecha = UNKNOWN_PERCEPTION;
		hayFloresAbajo = UNKNOWN_PERCEPTION;
		hayFloresIzquierda = UNKNOWN_PERCEPTION;
		hayLoboArriba = UNKNOWN_PERCEPTION;
		hayLoboDerecha = UNKNOWN_PERCEPTION;
		hayLoboAbajo = UNKNOWN_PERCEPTION;
		hayLoboIzquierda = UNKNOWN_PERCEPTION;
		distanciaArbolArriba = UNKNOWN_PERCEPTION;
		distanciaArbolDerecha = UNKNOWN_PERCEPTION;
		distanciaArbolAbajo = UNKNOWN_PERCEPTION;
		distanciaArbolIzquierda = UNKNOWN_PERCEPTION;
	}
	
	public CaperucitaPerception(Agent agent, Environment environment) {
		super(agent, environment);
	}
	
	@Override
	public void initPerception(Agent agent, Environment environment) {
		CaperucitaEnvironment caperucitaEnvironment = (CaperucitaEnvironment) environment;
		Point caperucitaPosition = caperucitaEnvironment.getEnvironmentState().getCaperucitaPosition();
		Point wolfPosition = caperucitaEnvironment.getEnvironmentState().getWolfPosition();
		ArrayList<Point> cakesPositions = caperucitaEnvironment.getEnvironmentState().getCakesPositions();
		ArrayList<Point> flowersPositions = caperucitaEnvironment.getEnvironmentState().getFlowersPositions();
		ArrayList<Point> treesPositions = caperucitaEnvironment.getEnvironmentState().getTreesPositions();

		this.cantidadTortasArriba = 0;
		this.cantidadTortasDerecha = 0;
		this.cantidadTortasAbajo = 0;
		this.cantidadTortasIzquierda = 0;

		this.hayLoboArriba = 0;
		this.hayLoboDerecha = 0;
		this.hayLoboAbajo = 0;
		this.hayLoboIzquierda = 0;

		this.hayFloresArriba = 0;
		this.hayFloresDerecha = 0;
		this.hayFloresAbajo = 0;
		this.hayFloresIzquierda = 0;

		if(caperucitaPosition.getX() == wolfPosition.getX()) {
			if(caperucitaPosition.getY() > wolfPosition.getY())
				this.hayLoboAbajo = 1;
			else if(caperucitaPosition.getY() < wolfPosition.getY())
				this.hayLoboArriba = 1;
		}
		else if(caperucitaPosition.getY() == wolfPosition.getY()) {
			if(caperucitaPosition.getX() > wolfPosition.getX())
				this.hayLoboIzquierda = 1;
			else if(caperucitaPosition.getX() < wolfPosition.getX())
				this.hayLoboDerecha = 1;
		}

		for(Point flowerPosition: flowersPositions) {
			if(flowerPosition.getX() == caperucitaPosition.getX()) {
				if(flowerPosition.getY() > caperucitaPosition.getY()) {
					hayFloresArriba = 1;
					break;
				}
				else if(flowerPosition.getY() > caperucitaPosition.getY()) {
					hayFloresAbajo = 1;
					break;
				}
			}
			else {
				if(flowerPosition.getX() > caperucitaPosition.getX()) {
					hayFloresDerecha = 1;
					break;
				}
				else if(flowerPosition.getX() > caperucitaPosition.getX()) {
					hayFloresIzquierda = 1;
					break;
				}
			}
		}

		for(Point cakePosition: cakesPositions) {
			if(cakePosition.getX() == caperucitaPosition.getX()) {
				if(cakePosition.getY() > caperucitaPosition.getY()) {
					this.cantidadTortasArriba++;
				}
				else if(cakePosition.getY() > caperucitaPosition.getY()) {
					this.cantidadTortasAbajo++;
				}
			}
			else {
				if(cakePosition.getX() > caperucitaPosition.getX()) {
					this.cantidadTortasDerecha++;
				}
				else if(cakePosition.getX() > caperucitaPosition.getX()) {
					this.cantidadTortasIzquierda++;
				}
			}
		}

		this.distanciaArbolDerecha = treesPositions.stream()
				.filter(p -> p.getY() == caperucitaPosition.getY())
				.filter(p -> p.getX() > caperucitaPosition.getX())
				.mapToInt(p -> (int) p.getX())
				.min().orElse((int) (caperucitaPosition.getX() + 1)) - (int)caperucitaPosition.getX() - 1;
	}
}
