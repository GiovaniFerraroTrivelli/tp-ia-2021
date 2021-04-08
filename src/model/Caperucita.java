package model;

import java.awt.*;
import java.util.Vector;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import operators.*;

public class Caperucita extends SearchBasedAgent {

	public Caperucita() {
		CaperucitaGoal caperucitaGoal = new CaperucitaGoal();
		
		CaperucitaState caperucitaState = new CaperucitaState();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
