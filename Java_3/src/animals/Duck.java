package animals;

import aviary.Size;
import food.Food;
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

    @Override
    public String eat(Food food) {

        return null;
    }
    public Size getSize() {
        return Size.SECOND;
    }

 }