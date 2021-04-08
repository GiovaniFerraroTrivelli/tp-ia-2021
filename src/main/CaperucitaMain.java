package main;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import model.CaperucitaEnvironment;
import model.Caperucita;

public class CaperucitaMain {

	public static void main(String[] args) throws PrologConnectorException {
		Caperucita agent = new Caperucita();
		
		CaperucitaEnvironment environment = new CaperucitaEnvironment();
		
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
		
		simulator.start();
	}

}
