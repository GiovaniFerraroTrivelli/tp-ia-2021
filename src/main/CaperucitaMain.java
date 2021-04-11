package main;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import model.CaperucitaEnvironment;
import model.Caperucita;
import scenary.Scenary;
import scenary.Scenary1;

public class CaperucitaMain {

	public static void main(String[] args) throws PrologConnectorException {
		Scenary scenary = new Scenary1();

		Caperucita agent = new Caperucita(scenary);
		CaperucitaEnvironment environment = new CaperucitaEnvironment(scenary);
		
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
		
		simulator.start();
	}

}
