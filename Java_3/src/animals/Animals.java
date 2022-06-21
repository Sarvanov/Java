package animals;

import aviary.Size;
import food.Food;
import food.WrongFoodException;

import java.util.Objects;

public abstract class Animals {

    public abstract String eat(Food food) throws WrongFoodException;

    protected String name;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public abstract Size getSize();
}