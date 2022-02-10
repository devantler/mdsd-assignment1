package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;
import main.metamodel.operations.SetOperation;

import java.util.Objects;

public class MachineInterpreter {
	Machine machine;

	public void run(Machine m) {
		machine = m;
	}

	public State getCurrentState() {
		return machine.getCurrentState();
	}

	public void processEvent(String eventName) {
		for (Transition transition : machine.getCurrentState().getTransitions()) {
			if (transition.getEvent() == eventName) {
				var integers = machine.getIntegers();
				if (transition.isConditional()) {
					var variableName = transition.getConditionVariableName().toString();
					var currentValue = integers.get(variableName);
					var valueToCompareTO = transition.getConditionComparedValue();
					if (transition.isConditionEqual()) {
						if (!Objects.equals(currentValue, valueToCompareTO)) {
							continue;
						}
					} else if (transition.isConditionGreaterThan()) {
						if (currentValue <= valueToCompareTO) {
							continue;
						}
					} else if (transition.isConditionLessThan()) {
						if (currentValue >= valueToCompareTO) {
							continue;
						}
					}
				}
				if (transition.hasOperation()) {
					var variableName = transition.getOperationVariableName().toString();
					var currentValue = integers.get(variableName);
					if (transition.hasSetOperation()) {
						var valueToSet = ((SetOperation) transition.getOperation()).getValue();
						integers.put(variableName, valueToSet);
					} else if (transition.hasIncrementOperation()) {
						integers.put(variableName, ++currentValue);
					} else if (transition.hasDecrementOperation()) {
						integers.put(variableName, --currentValue);
					}
				}
				machine.setCurrentState(transition.getTarget());
				return;
			}
		}
	}

	public int getInteger(String string) {
		return machine.getIntegers().get(string);
	}
}
