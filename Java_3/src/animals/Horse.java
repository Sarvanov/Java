package animals;

import aviary.Size;
import interfaces.*;

public class Horse extends Herbivore implements Run, Voice {

    public Horse(String name, Size size) {
        super(name, size);
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