package animals;

import food.Food;
import food.Meat;
import interfaces.Run;
import interfaces.Voice;

public class Tiger extends Carnivorous implements Run, Voice {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Тигр бегает");
    }

    @Override
    public String voice() {
        return "Тигр рычит";
    }

}