package animals;

import interfaces.*;

public class Wolf extends Carnivorous implements Run, Voice {

    @Override
    public void run() {
        System.out.println("Волк бегает");
    }

    @Override
    public String voice() {
        return "Волк скулит";
    }
}