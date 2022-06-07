package animals;

import food.*;

public class Herbivore extends Animals {

    public void eat (Food food){
        if (food instanceof Grass){
            System.out.println("Травоядное животное ест траву");
        } else System.out.println("Травоядное животное не ест мясо");
    };
}