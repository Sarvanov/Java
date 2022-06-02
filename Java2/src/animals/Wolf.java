package animals;

import food.Food;
import food.Meat;

public class Wolf extends Carnivorous implements Run, Voice{
    @Override
    public void run() {
        System.out.println("Волк бегает");
    }

    @Override
    public String voice() {
        String voice = "Волк скулит";
        return voice;
    }
    public void eat(Food food) {
        if (food instanceof Meat){
            System.out.println("Волк ест мясо");
        } else System.out.println("Волк не травоядное животное");

    }
}
