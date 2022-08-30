package stream.group.model;

public class Dish {

    private String name;

    private String type;

    private int calories;

    private CarloricLevel carloricLevel;

    public Dish(String name, String type, int calories, CarloricLevel carloricLevel) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.carloricLevel = carloricLevel;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public CarloricLevel getCarloricLevel() {
        return carloricLevel;
    }
}
