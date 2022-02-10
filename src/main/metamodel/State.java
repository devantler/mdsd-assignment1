package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	private final String name;
    private final List<Transition> transitions = new ArrayList<>();

	public State(String name) {
		this.name = name;
    }

    public Object getName() {
		return name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String event) {
		for (Transition transition : transitions) {
			if(transition.getEvent() == event){
				return transition;
			}
		}
		return null;
	}

}
