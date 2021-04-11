package model;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import scenary.Scenary;

public class CaperucitaEnvironment extends Environment {

    public CaperucitaEnvironment(Scenary scenary) {
        this.environmentState = new CaperucitaEnvironmentState(scenary);
    }

    public CaperucitaEnvironmentState getEnvironmentState() {
        return (CaperucitaEnvironmentState) this.environmentState;
    }

    @Override
    public Perception getPercept() {
        return new CaperucitaPerception(null, this);
    }

    public String toString() {
        return environmentState.toString();
    }

}
