package animals;

import aviary.Size;
import food.Food;
import food.WrongFoodException;

import java.util.Objects;

public abstract class Animals {

    public abstract void eat(Food food) throws WrongFoodException;

    protected String name;
    protected Size size;

    public Animals(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
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
        return Objects.equals(name, animals.name) && size == animals.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}