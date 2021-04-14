package model;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.awt.*;
import static constants.Constants.*;

public class CaperucitaPerception extends Perception {
	private Point caperucitaPosition;
	/*private int[] filaActual = new int[SCENARY_WIDTH];
	private int[] columnaActual = new int[SCENARY_HEIGHT];*/
	private int[][] scenary = new int[SCENARY_WIDTH][SCENARY_HEIGHT];

	public CaperucitaPerception() {

	}
	
	public CaperucitaPerception(Agent agent, Environment environment) {
		super(agent, environment);
		initPerception(agent, environment);
	}
	
	@Override
	public void initPerception(Agent agent, Environment environment) {
		CaperucitaEnvironment caperucitaEnvironment = (CaperucitaEnvironment) environment;
		//int[][] scenary = caperucitaEnvironment.getEnvironmentState().getForest();
		this.scenary = caperucitaEnvironment.getEnvironmentState().getForest();

		this.caperucitaPosition = caperucitaEnvironment.getEnvironmentState().getCaperucitaPosition();

		/*this.filaActual = scenary[caperucitaPosition.y];
		this.columnaActual = scenary[caperucitaPosition.x];*/
	}

	@Override
	public String toString() {
		return "";
	}

	public CaperucitaPerception clone() {
		CaperucitaPerception newCaperucitaPerception = new CaperucitaPerception();
		newCaperucitaPerception.setCaperucitaPosition(new Point(this.caperucitaPosition.x, this.caperucitaPosition.y));

		for(int i = 0; i < SCENARY_HEIGHT; i++) {
			System.arraycopy(this.scenary[i], 0, newCaperucitaPerception.scenary[i], 0, SCENARY_WIDTH);
		}

		return newCaperucitaPerception;
	}

	public Point getCaperucitaPosition() {
		return caperucitaPosition;
	}

	public void setCaperucitaPosition(Point caperucitaPosition) {
		this.caperucitaPosition = caperucitaPosition;
	}

	public int[][] getScenary() {
		return scenary;
	}

	public void setScenary(int[][] scenary) {
		this.scenary = scenary;
	}

	/*public int[] getFilaActual() {
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
	}*/
}
