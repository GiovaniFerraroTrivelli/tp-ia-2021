package operators;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import model.CaperucitaEnvironmentState;
import model.CaperucitaPerception;
import model.CaperucitaState;

import java.awt.*;

import static constants.Constants.*;

public class GoLeft extends SearchAction {

	@Override
	public CaperucitaState execute(SearchBasedAgentState s) {
		CaperucitaState caperucitaState = (CaperucitaState) s;
		Point posicionActual = caperucitaState.getPosicionActual();
		int[] filaActual = new int[SCENARY_HEIGHT];
		filaActual = caperucitaState.getFilaActual();

		boolean sigueRecorriendo = true;
		for(int i = posicionActual.x; i >= 0; i--) {
			switch(filaActual[i]) {
				case SCENARY_CAKE -> caperucitaState.setTortas(caperucitaState.getTortas() + 1);
				case SCENARY_TREE -> {
					caperucitaState.setPosicionActual(new Point(i + 1, posicionActual.y));
					sigueRecorriendo = false;
				}
				case SCENARY_FLOWER -> {}
				case SCENARY_WOLF -> {
					return null;
				}
			}

			if(!sigueRecorriendo)
				break;
		}

		return caperucitaState;
	}

	@Override
	public Double getCost() {
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		CaperucitaEnvironmentState caperucitaEnvironment = (CaperucitaEnvironmentState) est;
		CaperucitaState caperucitaState = (CaperucitaState) ast;
		Point posicionActual = caperucitaState.getPosicionActual();
		int[] filaActual = new int[SCENARY_HEIGHT];
		filaActual = caperucitaState.getFilaActual();

		int[][] scenary = caperucitaEnvironment.getCurrentForest();

		boolean sigueRecorriendo = true;
		for(int i = posicionActual.y; i >= 0; i--) {
			switch(filaActual[i]) {
				case SCENARY_CAKE -> {
					scenary[posicionActual.y][i] = 0;
					caperucitaEnvironment.setScenary(scenary);
				}
				case SCENARY_TREE, SCENARY_FLOWER -> {}
				case SCENARY_WOLF -> {
					return null;
				}
			}
		}

		return caperucitaEnvironment;
	}

	@Override
	public String toString() {
		return "irIzquierda";
	}

}
