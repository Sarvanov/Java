package animals;

import interfaces.*;

public class Horse extends Herbivore implements Run, Voice {

    @Override
    public void run() {
        System.out.println("Лошадь бегает");
    }

    @Override
    public String voice() {
        return "Лошадь говорит иго-го";
    }
}