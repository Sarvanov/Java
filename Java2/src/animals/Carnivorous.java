package animals;

import food.*;

public class Carnivorous extends Animals{

    public void eat (Food food){
        if (food instanceof Meat){
            System.out.println("Хищник ест мясо");
        } else System.out.println("Хищник не ест траву");
    }
}