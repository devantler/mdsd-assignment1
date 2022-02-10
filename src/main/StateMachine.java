package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;
import main.metamodel.conditions.IfEqualsCondition;
import main.metamodel.conditions.IfGreaterThanCondition;
import main.metamodel.conditions.IfLessThanCondition;
import main.metamodel.operations.DecrementOperation;
import main.metamodel.operations.IncrementOperation;
import main.metamodel.operations.SetOperation;

public class StateMachine {
	Machine machine = new Machine();
	State currentStateWorkedOn;
	Transition currentTransitionWorkedOn;

	public Machine build() {
		return machine;
	}

	public StateMachine state(String name) {
		State newState = machine.getState(name);
		if (newState == null) {
			newState = new State(name);
			machine.getStates().add(newState);
		}
		currentStateWorkedOn = newState;
		return this;
	}

	public StateMachine initial() {
		machine.setInitialState(currentStateWorkedOn);
		return this;
	}

	public StateMachine when(String name) {
		Transition newTransition = new Transition(name);
		currentStateWorkedOn.getTransitions().add(newTransition);
		currentTransitionWorkedOn = newTransition;
		return this;
	}

	public StateMachine to(String name) {
		State target = machine.getState(name);
		if (target == null) {
			State newState = new State(name);
			target = newState;
			machine.getStates().add(newState);
		}
		currentTransitionWorkedOn.setTarget(target);
		return this;
	}

	public StateMachine integer(String name) {
		machine.getIntegers().put(name, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		currentTransitionWorkedOn.setOperation(new SetOperation(string, i));
		return this;
	}

	public StateMachine increment(String string) {
		currentTransitionWorkedOn.setOperation(new IncrementOperation(string));
		return this;
	}

	public StateMachine decrement(String string) {
		currentTransitionWorkedOn.setOperation(new DecrementOperation(string));
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTransitionWorkedOn.setCondition(new IfEqualsCondition(string, i));
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTransitionWorkedOn.setCondition(new IfGreaterThanCondition(string, i));
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTransitionWorkedOn.setCondition(new IfLessThanCondition(string, i));
		return this;
	}

}
