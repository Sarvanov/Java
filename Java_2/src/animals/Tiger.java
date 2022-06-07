package animals;

import interfaces.*;

public class Tiger extends Carnivorous implements Run, Voice {

    @Override
    public void run() {
        System.out.println("Тигр бегает");
    }

    @Override
    public String voice() {
        return "Тигр рычит";
    }
}