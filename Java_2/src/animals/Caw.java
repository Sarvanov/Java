package animals;

import interfaces.*;

public class Caw extends Herbivore implements Run, Voice {

    @Override
    public void run(){
        System.out.println("Корова бегает");
    }
    @Override
    public String voice(){
        return "Корова мычит";
    }
}