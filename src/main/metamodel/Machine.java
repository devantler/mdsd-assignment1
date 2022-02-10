package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	private final List<State> states = new ArrayList<>();
	private final Map<String, Integer> integers = new HashMap<>();
	private State currentState;

	public List<State> getStates() {
		return states;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public State getInitialState() {
		return currentState;
	}

	public void setInitialState(State state) {
		currentState = state;
	}

	public State getState(String name) {
		for (State state : states) {
			if(state.getName() == name) {
				return state;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {
		return integers.containsKey(string);
	}

	public Map<String, Integer> getIntegers(){
		return integers;
	}

}
