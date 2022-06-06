package animals;

import food.*;
import interfaces.*;

public class Duck extends Herbivore implements Fly, Swim, Voice {
    public Duck(String name) {
        super(name);
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