package operators;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import model.CaperucitaEnvironment;
import model.CaperucitaEnvironmentState;
import model.CaperucitaPerception;
import model.CaperucitaState;

import java.awt.*;

public class GoDown extends SearchAction {

	public static int SCENARY_TREE = 1;
	public static int SCENARY_CAKE = 2;
	public static int SCENARY_WOLF = 3;
	public static int SCENARY_FLOWER = 4;

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		CaperucitaState caperucitaState = (CaperucitaState) s;
		Point posicionActual = caperucitaState.getPosicionActual();
		CaperucitaPerception perceptionActual = caperucitaState.getPerceptionActual();
		Integer cantTortas = caperucitaState.getTortas();
		Integer vidas = caperucitaState.getVidas();
		if(caperucitaState.getPerceptionActual().getHayLoboAbajo() == 1){
			caperucitaState.setPosicionActual(caperucitaState.getPOSICION_INICIAL());
			caperucitaState.setTortas(0);
			caperucitaState.setVidas(vidas-1);
		}
		else{
			//Fijarse los signos de la actualizacion de la posicion
			caperucitaState.setPosicionActual(new Point(
					posicionActual.x, posicionActual.y - perceptionActual.getDistanciaArbolAbajo()));
			caperucitaState.setTortas(cantTortas + perceptionActual.getCantidadTortasAbajo());

		}
		return caperucitaState;
	}

	@Override
	public Double getCost() {
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
