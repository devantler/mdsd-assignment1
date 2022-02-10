package main.metamodel.operations;

public class SetOperation extends Operation {

    private final Integer value;

    public SetOperation(String name, Integer value) {
        super(name);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
