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
		int[] filaActual = caperucitaState.getRow();

		if (filaActual[posicionActual.x - 1] == SCENARY_TREE)
			return null;

		int[] newRow = new int[SCENARY_WIDTH];
		boolean sigueRecorriendo = true;

		for(int i = posicionActual.x; i >= 0; i--) {
			switch(filaActual[i]) {
				case SCENARY_CAKE -> {
					caperucitaState.setTortas(caperucitaState.getTortas() + 1);
					newRow[i] = 0;
				}
				case SCENARY_TREE -> {
					caperucitaState.setPosicionActual(new Point(i + 1, posicionActual.y));
					sigueRecorriendo = false;
					newRow[i] = SCENARY_TREE;
				}
				case SCENARY_FLOWER -> {
					newRow[i] = SCENARY_FLOWER;
					caperucitaState.setPosicionActual(new Point(i, posicionActual.y));
					sigueRecorriendo = false;
				}
				case SCENARY_WOLF -> {
					return null;
				}
			}

			if (!sigueRecorriendo)
				break;
		}

		if(sigueRecorriendo) {
			caperucitaState.setPosicionActual(new Point(1, posicionActual.y));
		}

		caperucitaState.updateRow(newRow, false);
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
		int[] filaActual = caperucitaState.getRow();

		int[][] scenary = caperucitaEnvironment.getCurrentForest();

		boolean sigueRecorriendo = true;
		for(int i = posicionActual.x; i >= 0; i--) {
			switch(filaActual[i]) {
				case SCENARY_CAKE -> {
					scenary[posicionActual.y][i] = 0;
					caperucitaEnvironment.setScenary(scenary);
					caperucitaState.setTortas(caperucitaState.getTortas() + 1);
				}
				case SCENARY_TREE -> {
					Point posActual = new Point(i + 1, posicionActual.y);

					caperucitaState.setPosicionActual(posActual);
					caperucitaEnvironment.setCaperucitaPosition(posActual);
					sigueRecorriendo = false;
				}
				case SCENARY_FLOWER -> {
					Point posActual = new Point(i, posicionActual.y);

					caperucitaState.setPosicionActual(posActual);
					caperucitaEnvironment.setCaperucitaPosition(posActual);
					sigueRecorriendo = false;
				}
				case SCENARY_WOLF -> {
					return null;
				}
			}

			if(!sigueRecorriendo)
				break;
		}

		return caperucitaEnvironment;
	}

	@Override
	public String toString() {
		return "irIzquierda";
	}

}
