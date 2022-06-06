package animals;

import food.Food;
import food.Grass;
import interfaces.Run;
import interfaces.Voice;

public class Horse extends Herbivore implements Run, Voice {
    public Horse(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Лошадь бегает");
    }

    @Override
    public String voice() {
        return "Лошадь говорит иго-го";
    }

}