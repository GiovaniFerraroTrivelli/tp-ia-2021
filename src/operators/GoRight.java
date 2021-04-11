package operators;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import model.CaperucitaEnvironmentState;
import model.CaperucitaPerception;
import model.CaperucitaState;

import java.awt.*;

import static constants.Constants.SCENARY_CAKE;

public class GoRight extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CaperucitaState caperucitaState = (CaperucitaState) s;
        Point posicionActual = caperucitaState.getPosicionActual();
        CaperucitaPerception perceptionActual = caperucitaState.getPerceptionActual();

        if (caperucitaState.getPerceptionActual().getHayLoboDerecha() == 1) {
            //caperucitaState.deathRespawn();
            return null;
        } else {
            caperucitaState.setPosicionActual(new Point(
                            posicionActual.x + perceptionActual.getDistanciaArbolDerecha(),
                            posicionActual.y
                    )
            );

            caperucitaState.setTortas(caperucitaState.getTortas() + perceptionActual.getCantidadTortasDerecha());
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
        CaperucitaPerception perceptionActual = caperucitaState.getPerceptionActual();
        Integer distanciaDerecha = perceptionActual.getDistanciaArbolDerecha();

        if (caperucitaState.getPerceptionActual().getHayLoboDerecha() == 1) {
            //caperucitaState.deathRespawn();
            //caperucitaEnvironment.setScenary(caperucitaEnvironment.getInicialScenary());
            return null;
        } else {
            caperucitaState.setPosicionActual(new Point(
                            posicionActual.x + distanciaDerecha,
                            posicionActual.y
                    )
            );

            caperucitaState.setTortas(caperucitaState.getTortas() + perceptionActual.getCantidadTortasDerecha());

            caperucitaEnvironment.setCaperucitaPosition(caperucitaState.getPosicionActual());
            for(int i = posicionActual.x ; i <= posicionActual.x + distanciaDerecha ; i++)
                if(caperucitaEnvironment.getForest()[posicionActual.y][i] == SCENARY_CAKE)
                    caperucitaEnvironment.getForest()[posicionActual.y][i] = 0;
        }

        return caperucitaEnvironment;
    }

    @Override
    public String toString() {
        return "irDerecha";
    }

}
