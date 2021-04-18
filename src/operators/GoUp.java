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

public class GoUp extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CaperucitaState caperucitaState = (CaperucitaState) s;
        Point posicionActual = caperucitaState.getPosicionActual();

        int[] columnaActual = caperucitaState.getColumn();

        if (columnaActual[posicionActual.y - 1] == SCENARY_TREE)
            return null;

        int[] newColumn = new int[SCENARY_HEIGHT];
        boolean sigueRecorriendo = true;

        for (int i = posicionActual.y; i >= 0; i--) {
            switch (columnaActual[i]) {
                case SCENARY_CAKE -> {
                    caperucitaState.setTortas(caperucitaState.getTortas() + 1);
                    newColumn[i] = 0;
                }
                case SCENARY_TREE -> {
                    caperucitaState.setPosicionActual(new Point(posicionActual.x, i + 1));
                    sigueRecorriendo = false;
                    newColumn[i] = SCENARY_TREE;
                }
                case SCENARY_FLOWER -> {
                    newColumn[i] = SCENARY_FLOWER;
                    caperucitaState.setPosicionActual(new Point(posicionActual.x, i));
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
            caperucitaState.setPosicionActual(new Point(posicionActual.x, 1));
        }

        caperucitaState.updateColumn(newColumn, false);
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
        int[] columnaActual = caperucitaState.getColumn();

        int[][] scenary = caperucitaEnvironment.getCurrentForest();

        boolean sigueRecorriendo = true;
        for (int i = posicionActual.y; i >= 0; i--) {
            switch (columnaActual[i]) {
                case SCENARY_CAKE -> {
                    scenary[i][posicionActual.x] = 0;
                    caperucitaEnvironment.setScenary(scenary);
                    caperucitaState.setTortas(caperucitaState.getTortas() + 1);
                }
                case SCENARY_TREE -> {
                    Point posActual = new Point(posicionActual.x, i + 1);
                    caperucitaState.setPosicionActual(posActual);
                    caperucitaEnvironment.setCaperucitaPosition(posActual);
                    sigueRecorriendo = false;
                }
                case SCENARY_FLOWER -> {
                    Point posActual = new Point(posicionActual.x, i);
                    caperucitaState.setPosicionActual(posActual);
                    caperucitaEnvironment.setCaperucitaPosition(posActual);
                    sigueRecorriendo = false;
                }
                case SCENARY_WOLF -> {
                    caperucitaState.setTortas(0);
                    caperucitaState.setVidas(caperucitaState.getVidas() - 1);
                    caperucitaState.setPosicionActual(caperucitaState.getPosicionInicial());
                    caperucitaEnvironment.setScenary(caperucitaEnvironment.getInicialScenary());
                    caperucitaEnvironment.setWolfPosition(caperucitaEnvironment.getWolfInitialPosition());
                    caperucitaState.setKnownScenary(caperucitaState.getInicialKnownScenary());
                }
            }

            if (!sigueRecorriendo)
                break;
        }

        caperucitaEnvironment.moveWolf();
        caperucitaState.removeWolfFromForest();

        return caperucitaEnvironment;
    }

    @Override
    public String toString() {
        return "irArriba";
    }

}
