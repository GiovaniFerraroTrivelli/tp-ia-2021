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

public class GoDown extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CaperucitaState caperucitaState = (CaperucitaState) s;
        Point posicionActual = caperucitaState.getPosicionActual();
        CaperucitaPerception perceptionActual = caperucitaState.getPerceptionActual();

        if (caperucitaState.getPerceptionActual().getHayLoboAbajo() == 1) {
            //caperucitaState.deathRespawn();
            return null;
        } else {
            caperucitaState.setPosicionActual(new Point(
                            posicionActual.x,
                            posicionActual.y + perceptionActual.getDistanciaArbolAbajo()
                    )
            );
            caperucitaState.setTortas(caperucitaState.getTortas() + perceptionActual.getCantidadTortasAbajo());
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
        int distanciaAbajo = perceptionActual.getDistanciaArbolAbajo();

        if (caperucitaState.getPerceptionActual().getHayLoboAbajo() == 1) {
            //caperucitaState.deathRespawn();
            //caperucitaEnvironment.setScenary(caperucitaEnvironment.getInicialScenary());
            return null;
        } else {
            caperucitaState.setPosicionActual(new Point(
                            posicionActual.x,
                            posicionActual.y + distanciaAbajo
                    )
            );
            caperucitaState.setTortas(caperucitaState.getTortas() + perceptionActual.getCantidadTortasAbajo());

            caperucitaEnvironment.setCaperucitaPosition(caperucitaState.getPosicionActual());
            for(int i = posicionActual.y ; i <= posicionActual.y + distanciaAbajo ; i++)
                if(caperucitaEnvironment.getForest()[i][posicionActual.x] == SCENARY_CAKE)
                    caperucitaEnvironment.getForest()[i][posicionActual.x] = 0;
        }

        return caperucitaEnvironment;
    }

    @Override
    public String toString() {
        return "irAbajo";
    }

}
