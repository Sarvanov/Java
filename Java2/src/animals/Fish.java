package animals;

import food.Food;
import food.Meat;
import interfaces.Swim;

public class Fish extends Carnivorous implements Swim {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("Рыба плавает");
    }

}