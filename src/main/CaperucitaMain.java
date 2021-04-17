package main;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import model.CaperucitaEnvironment;
import model.Caperucita;
import scenary.Scenary;
import scenary.Scenary1;
import scenary.Scenary2;

public class CaperucitaMain {

	public static void main(String[] args) {
		Scenary scenary = new Scenary2();

		Caperucita agent = new Caperucita(scenary);
		CaperucitaEnvironment environment = new CaperucitaEnvironment(scenary);
		
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
		
		simulator.start();
	}

}
