package animals;

import food.Food;
import food.Grass;
import food.Meat;

public class Fish extends Carnivorous implements Swim{
    @Override
    public String swim() {
        String swim = "Рыба плавает";
        System.out.println(swim);
        return swim;
    }
    public void eat(Food food) {
        if (food instanceof Meat){
            System.out.println("Рыба является хищником");
        } else System.out.println("Рыба не ест траву");

    }
}
