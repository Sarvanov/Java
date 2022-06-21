package animals;

import aviary.Size;
import interfaces.*;

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
    public Size getSize() {
        return Size.FOURTH;
    }
}