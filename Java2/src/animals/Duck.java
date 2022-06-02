package animals;

import food.Food;
import food.Grass;

public class Duck extends Herbivore implements Fly, Swim, Voice{
    @Override
    public void fly() {
        System.out.println("Утка летает");
    }
    @Override
    public String swim(){
        String swim = "Утка плавает";
        System.out.println(swim);
        return swim;
    }

    @Override
    public String voice() {
        String voice = "Утка крякает";
        return voice;
    }
    public void eat(Food food) {
        if (food instanceof Grass){
            System.out.println("Утка ест траву");
        } else System.out.println("Утка не ест мясо");

    }
}
