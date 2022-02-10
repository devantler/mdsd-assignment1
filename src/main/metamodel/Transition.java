package main.metamodel;

import main.metamodel.conditions.Condition;
import main.metamodel.conditions.IfEqualsCondition;
import main.metamodel.conditions.IfGreaterThanCondition;
import main.metamodel.conditions.IfLessThanCondition;
import main.metamodel.operations.DecrementOperation;
import main.metamodel.operations.IncrementOperation;
import main.metamodel.operations.Operation;
import main.metamodel.operations.SetOperation;

public class Transition {

	private Object event;
	private State target;
	private Operation operation;
	private Condition condition;

	public Transition(String event) {
		this.event = event;
	}

	public Object getEvent() {
		return event;
	}

	public State getTarget() {
		return target;
	}

	public void setTarget(State target) {
		this.target = target;
	}

	public boolean hasSetOperation() {
		if (operation instanceof SetOperation) {
			return true;
		}
		return false;
	}

	public boolean hasIncrementOperation() {
		if (operation instanceof IncrementOperation) {
			return true;
		}
		return false;
	}

	public boolean hasDecrementOperation() {
		if (operation instanceof DecrementOperation) {
			return true;
		}
		return false;
	}

	public Object getOperationVariableName() {
		return operation.getName();
	}

	public boolean isConditional() {
		return condition != null;
	}

	public Object getConditionVariableName() {
		return condition.getName();
	}

	public Integer getConditionComparedValue() {
		return condition.getComparedValue();
	}

	public boolean isConditionEqual() {
		if (condition instanceof IfEqualsCondition) {
			return true;
		}
		return false;
	}

	public boolean isConditionGreaterThan() {
		if (condition instanceof IfGreaterThanCondition) {
			return true;
		}
		return false;
	}

	public boolean isConditionLessThan() {
		if (condition instanceof IfLessThanCondition) {
			return true;
		}
		return false;
	}

	public boolean hasOperation() {
		return operation != null;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
}
