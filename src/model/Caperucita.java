package model;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import operators.GoDown;
import operators.GoLeft;
import operators.GoRight;
import operators.GoUp;
import scenary.Scenary;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.net.StandardSocketOptions;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caperucita extends SearchBasedAgent {

    public Caperucita(Scenary scenary) {
        CaperucitaGoal caperucitaGoal = new CaperucitaGoal();

        CaperucitaState caperucitaState = new CaperucitaState(scenary);
        this.setAgentState(caperucitaState);

        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.add(new GoRight());
        operators.add(new GoLeft());
        operators.add(new GoUp());
        operators.add(new GoDown());

        Problem problem = new Problem(caperucitaGoal, caperucitaState, operators);
        this.setProblem(problem);
    }

    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);

    }

    @Override
    public Action selectAction() {
        BreathFirstSearch strategy = new BreathFirstSearch();

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;

        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(Caperucita.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

}
