package model;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaEnvironment extends Environment {

    public CaperucitaEnvironment() {
        this.environmentState = new CaperucitaEnvironmentState();
    }

    public CaperucitaEnvironmentState getEnvironmentState() {
        return (CaperucitaEnvironmentState) this.environmentState;
    }

    @Override
    public Perception getPercept() {
        return new CaperucitaPerception();
    }

}
