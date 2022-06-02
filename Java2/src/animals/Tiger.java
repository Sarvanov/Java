package animals;

import food.Food;
import food.Meat;

public class Tiger extends Carnivorous implements Run, Voice{
    @Override
    public void run() {
        System.out.println("Тигр бегает");
    }

    @Override
    public String voice() {
        String voice = "Тигр рычит";
        return voice;
    }
    public void eat(Food food) {
        if (food instanceof Meat){
            System.out.println("Тигр ест мясо");
        } else System.out.println("Тигр не травоядное животное");

    }
}
