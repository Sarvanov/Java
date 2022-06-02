package animals;

import food.Food;
import food.Grass;

public class Horse extends Herbivore implements Run, Voice {
    @Override
    public void run() {
        System.out.println("Лошадь бегает");
    }

    @Override
    public String voice() {
        String voice = "Лошадь говорит иго-го";
        return voice;
    }
    public void eat(Food food) {
        if (food instanceof Grass){
            System.out.println("Лошадь ест траву");
        } else System.out.println("Лошадь не ест мясо");

    }
}
