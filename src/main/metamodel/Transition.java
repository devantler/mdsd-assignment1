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

	private final Object event;
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
		return operation instanceof SetOperation;
	}

	public boolean hasIncrementOperation() {
		return operation instanceof IncrementOperation;
	}

	public boolean hasDecrementOperation() {
		return operation instanceof DecrementOperation;
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
		return condition instanceof IfEqualsCondition;
	}

	public boolean isConditionGreaterThan() {
		return condition instanceof IfGreaterThanCondition;
	}

	public boolean isConditionLessThan() {
		return condition instanceof IfLessThanCondition;
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
