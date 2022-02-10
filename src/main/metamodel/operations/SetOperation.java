package main.metamodel.operations;

public class SetOperation extends Operation {

    private Integer value;

    public SetOperation(String name, Integer value) {
        super(name);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
