package animals;

import aviary.Size;
import interfaces.*;

public class Duck extends Herbivore implements Fly, Swim, Voice {

    public Duck(String name, Size size) {
        super(name, size);
    }

    @Override
    public void fly() {
        System.out.println("Утка летает");
    }
    @Override
    public void swim(){
        System.out.println("Утка плавает");
    }
    @Override
    public String voice() {
        return "Утка крякает";
    }
}