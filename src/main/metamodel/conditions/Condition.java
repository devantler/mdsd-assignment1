package main.metamodel.conditions;

public abstract class Condition {
    private String name;
    private Integer comparedValue;

    public Condition(String name, Integer comparedValue) {
        this.name = name;
        this.comparedValue = comparedValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getComparedValue() {
        return comparedValue;
    }

    public void setComparedValue(Integer comparedValue) {
        this.comparedValue = comparedValue;
    }
}
