package animals;

import aviary.Size;
import interfaces.*;

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
    public Size getSize() {
        return Size.THIRD;
    }
}