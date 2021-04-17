package main;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import model.Caperucita;
import model.CaperucitaEnvironment;
import scenary.Scenary;
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
