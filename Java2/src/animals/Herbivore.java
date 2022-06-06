package animals;

import food.Food;
import food.Grass;
import food.Meat;

public class Herbivore extends Animals {
    public Herbivore(String name) {
        super(name);
    }

    public void eat (Food food){
        if (food instanceof Grass){
            System.out.println("Травоядное животное ест траву");
        } else System.out.println("Травоядное животное не ест мясо");
    };
}