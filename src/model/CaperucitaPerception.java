package model;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.awt.*;
import static constants.Constants.*;

public class CaperucitaPerception extends Perception {
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
		initPerception(agent, environment);
	}
	
	@Override
	public void initPerception(Agent agent, Environment environment) {
		CaperucitaEnvironment caperucitaEnvironment = (CaperucitaEnvironment) environment;
		Point caperucitaPosition = caperucitaEnvironment.getEnvironmentState().getCaperucitaPosition();
		int[][] scenary = caperucitaEnvironment.getEnvironmentState().getForest();

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

		// horizontal
		for(int i = caperucitaPosition.x; i >= 0; i--) {
			if(scenary[caperucitaPosition.y][i] == SCENARY_FLOWER)
				this.hayFloresIzquierda = 1;
			else if(scenary[caperucitaPosition.y][i] == SCENARY_WOLF)
				this.hayLoboIzquierda = 1;
			else if(scenary[caperucitaPosition.y][i] == SCENARY_CAKE)
				this.cantidadTortasIzquierda++;
			else if(scenary[caperucitaPosition.y][i] == SCENARY_TREE) {
				distanciaArbolIzquierda = caperucitaPosition.x - i - 1;
				break;
			}
		}

		for(int i = caperucitaPosition.x; i < SCENARY_WIDTH; i++) {
			if(scenary[caperucitaPosition.y][i] == SCENARY_FLOWER)
				this.hayFloresDerecha = 1;
			else if(scenary[caperucitaPosition.y][i] == SCENARY_WOLF)
				this.hayLoboDerecha = 1;
			else if(scenary[caperucitaPosition.y][i] == SCENARY_CAKE)
				this.cantidadTortasDerecha++;
			else if(scenary[caperucitaPosition.y][i] == SCENARY_TREE) {
				distanciaArbolDerecha = i - caperucitaPosition.x - 1;
				break;
			}
		}

		// vertical
		for(int j = caperucitaPosition.y; j >= 0; j--) {
			if(scenary[j][caperucitaPosition.x] == SCENARY_FLOWER)
				this.hayFloresArriba = 1;
			else if(scenary[j][caperucitaPosition.x] == SCENARY_WOLF)
				this.hayLoboArriba = 1;
			else if(scenary[j][caperucitaPosition.x] == SCENARY_CAKE)
				this.cantidadTortasArriba++;
			else if(scenary[j][caperucitaPosition.x] == SCENARY_TREE) {
				distanciaArbolArriba = caperucitaPosition.y - j - 1;
				break;
			}
		}

		for(int j = caperucitaPosition.y; j < SCENARY_HEIGHT; j++) {
			if(scenary[j][caperucitaPosition.x] == SCENARY_FLOWER)
				this.hayFloresAbajo = 1;
			else if(scenary[j][caperucitaPosition.x] == SCENARY_WOLF)
				this.hayLoboAbajo = 1;
			else if(scenary[j][caperucitaPosition.x] == SCENARY_CAKE)
				this.cantidadTortasAbajo++;
			else if(scenary[j][caperucitaPosition.x]== SCENARY_TREE) {
				distanciaArbolAbajo = j - caperucitaPosition.y - 1;
				break;
			}
		}
	}

	@Override
	public String toString() {
		String res = "";
		res += "\n- cantidadTortasArriba: " + cantidadTortasArriba;
		res += "\n- cantidadTortasDerecha: " + cantidadTortasDerecha;
		res += "\n- cantidadTortasIzquierda: " + cantidadTortasIzquierda;
		res += "\n- cantidadTortasAbajo: " + cantidadTortasAbajo;

		res += "\n- hayFloresArriba: " + hayFloresArriba;
		res += "\n- hayFloresDerecha: " + hayFloresDerecha;
		res += "\n- hayFloresAbajo: " + hayFloresAbajo;
		res += "\n- hayFloresIzquierda: " + hayFloresIzquierda;

		res += "\n- hayLoboArriba: " + hayLoboArriba;
		res += "\n- hayLoboDerecha: " + hayLoboDerecha;
		res += "\n- hayLoboAbajo: " + hayLoboAbajo;
		res += "\n- hayLoboIzquierda: " + hayLoboIzquierda;

		res += "\n- distanciaArbolArriba: " + distanciaArbolArriba;
		res += "\n- distanciaArbolDerecha: " + distanciaArbolDerecha;
		res += "\n- distanciaArbolAbajo: " + distanciaArbolAbajo;
		res += "\n- distanciaArbolIzquierda: " + distanciaArbolIzquierda;

		return res;
	}

	public CaperucitaPerception clone() {
		CaperucitaPerception newCaperucitaPerception = new CaperucitaPerception();

		newCaperucitaPerception.cantidadTortasArriba = this.cantidadTortasArriba;
		newCaperucitaPerception.cantidadTortasDerecha = this.cantidadTortasDerecha;
		newCaperucitaPerception.cantidadTortasIzquierda = this.cantidadTortasIzquierda;
		newCaperucitaPerception.cantidadTortasAbajo = this.cantidadTortasAbajo;
		newCaperucitaPerception.hayFloresArriba = this.hayFloresArriba;
		newCaperucitaPerception.hayFloresDerecha = this.hayFloresDerecha;
		newCaperucitaPerception.hayFloresIzquierda = this.hayFloresIzquierda;
		newCaperucitaPerception.hayFloresAbajo = this.hayFloresAbajo;
		newCaperucitaPerception.hayLoboArriba = this.hayLoboArriba;
		newCaperucitaPerception.hayLoboDerecha = this.hayLoboDerecha;
		newCaperucitaPerception.hayLoboIzquierda = this.hayLoboIzquierda;
		newCaperucitaPerception.hayLoboAbajo = this.hayLoboAbajo;
		newCaperucitaPerception.distanciaArbolArriba = this.distanciaArbolArriba;
		newCaperucitaPerception.distanciaArbolDerecha = this.distanciaArbolDerecha;
		newCaperucitaPerception.distanciaArbolIzquierda = this.distanciaArbolIzquierda;
		newCaperucitaPerception.distanciaArbolAbajo = this.distanciaArbolAbajo;

		return newCaperucitaPerception;
	}

	public int getCantidadTortasArriba() {
		return cantidadTortasArriba;
	}

	public void setCantidadTortasArriba(int cantidadTortasArriba) {
		this.cantidadTortasArriba = cantidadTortasArriba;
	}

	public int getCantidadTortasDerecha() {
		return cantidadTortasDerecha;
	}

	public void setCantidadTortasDerecha(int cantidadTortasDerecha) {
		this.cantidadTortasDerecha = cantidadTortasDerecha;
	}

	public int getCantidadTortasAbajo() {
		return cantidadTortasAbajo;
	}

	public void setCantidadTortasAbajo(int cantidadTortasAbajo) {
		this.cantidadTortasAbajo = cantidadTortasAbajo;
	}

	public int getCantidadTortasIzquierda() {
		return cantidadTortasIzquierda;
	}

	public void setCantidadTortasIzquierda(int cantidadTortasIzquierda) {
		this.cantidadTortasIzquierda = cantidadTortasIzquierda;
	}

	public int getHayFloresArriba() {
		return hayFloresArriba;
	}

	public void setHayFloresArriba(int hayFloresArriba) {
		this.hayFloresArriba = hayFloresArriba;
	}

	public int getHayFloresDerecha() {
		return hayFloresDerecha;
	}

	public void setHayFloresDerecha(int hayFloresDerecha) {
		this.hayFloresDerecha = hayFloresDerecha;
	}

	public int getHayFloresAbajo() {
		return hayFloresAbajo;
	}

	public void setHayFloresAbajo(int hayFloresAbajo) {
		this.hayFloresAbajo = hayFloresAbajo;
	}

	public int getHayFloresIzquierda() {
		return hayFloresIzquierda;
	}

	public void setHayFloresIzquierda(int hayFloresIzquierda) {
		this.hayFloresIzquierda = hayFloresIzquierda;
	}

	public int getHayLoboArriba() {
		return hayLoboArriba;
	}

	public void setHayLoboArriba(int hayLoboArriba) {
		this.hayLoboArriba = hayLoboArriba;
	}

	public int getHayLoboDerecha() {
		return hayLoboDerecha;
	}

	public void setHayLoboDerecha(int hayLoboDerecha) {
		this.hayLoboDerecha = hayLoboDerecha;
	}

	public int getHayLoboAbajo() {
		return hayLoboAbajo;
	}

	public void setHayLoboAbajo(int hayLoboAbajo) {
		this.hayLoboAbajo = hayLoboAbajo;
	}

	public int getHayLoboIzquierda() {
		return hayLoboIzquierda;
	}

	public void setHayLoboIzquierda(int hayLoboIzquierda) {
		this.hayLoboIzquierda = hayLoboIzquierda;
	}

	public int getDistanciaArbolArriba() {
		return distanciaArbolArriba;
	}

	public void setDistanciaArbolArriba(int distanciaArbolArriba) {
		this.distanciaArbolArriba = distanciaArbolArriba;
	}

	public int getDistanciaArbolDerecha() {
		return distanciaArbolDerecha;
	}

	public void setDistanciaArbolDerecha(int distanciaArbolDerecha) {
		this.distanciaArbolDerecha = distanciaArbolDerecha;
	}

	public int getDistanciaArbolAbajo() {
		return distanciaArbolAbajo;
	}

	public void setDistanciaArbolAbajo(int distanciaArbolAbajo) {
		this.distanciaArbolAbajo = distanciaArbolAbajo;
	}

	public int getDistanciaArbolIzquierda() {
		return distanciaArbolIzquierda;
	}

	public void setDistanciaArbolIzquierda(int distanciaArbolIzquierda) { this.distanciaArbolIzquierda = distanciaArbolIzquierda; }
}
