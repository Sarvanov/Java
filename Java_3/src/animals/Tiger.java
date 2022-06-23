package animals;

import aviary.Size;
import interfaces.*;

public class Tiger extends Carnivorous implements Run, Voice {

    public Tiger(String name, Size size) {
        super(name, size);
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