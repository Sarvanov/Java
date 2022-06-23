package animals;

import aviary.Size;
import interfaces.Run;
import interfaces.Voice;

public class Caw extends Herbivore implements Run, Voice {

    public Caw(String name, Size size) {
        super(name, size);
    }

      @Override
    public void run(){
        System.out.println("Корова бегает");
    }
    @Override
    public String voice(){
        return "Корова мычит";
    }
}