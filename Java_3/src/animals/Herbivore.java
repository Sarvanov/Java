package animals;

import food.*;

import java.util.Objects;

public abstract class Herbivore extends Animals {

    public Herbivore(String name) {
        super(name);
    }

//    public String eat (Food food){
//        if (food instanceof Grass){
//            System.out.println("Травоядное животное ест траву");
//        } else System.out.println("Травоядное животное не ест мясо");
//        return null;
//    };
    @Override
    public String eat(Food food) throws WrongFoodException {
        if(food instanceof Grass){
            return "Травоядное ест траву!";
        }
        else{
            throw new WrongFoodException("Эта еда не подходит травоядному!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herbivore herbivore = (Herbivore) o;
        return Objects.equals(name, herbivore.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}