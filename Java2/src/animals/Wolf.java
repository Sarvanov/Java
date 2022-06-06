package animals;

import food.Food;
import food.Meat;
import interfaces.Run;
import interfaces.Voice;

public class Wolf extends Carnivorous implements Run, Voice {
    public Wolf(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Волк бегает");
    }

    @Override
    public String voice() {
        return "Волк скулит";
    }

}