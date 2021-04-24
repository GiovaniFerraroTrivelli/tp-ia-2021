
package main;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import model.CaperucitaState;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Heuristic implements IEstimatedCostFunction {

    @Override
    public double getEstimatedCost(NTree node) {
        CaperucitaState ag = (CaperucitaState) node.getAgentState();
        Point caperucitaPosition = ag.getPosicionActual();
        double distancia = ag.getFlowersPositions().stream()
                .mapToDouble(flower -> Math.abs(flower.getX() - caperucitaPosition.getX()) + Math.abs(flower.getY() - caperucitaPosition.getY()))
                .min().getAsDouble();

        return distancia;
    }
}
