package animals;

import aviary.Size;
import food.Food;
import interfaces.Run;
import interfaces.Voice;

public class Caw extends Herbivore implements Run, Voice {

    public Caw(String name) {
        super(name);
    }

      @Override
    public void run(){
        System.out.println("Корова бегает");
    }
    @Override
    public String voice(){
        return "Корова мычит";
    }

    @Override
    public String eat(Food food) {

        return null;
    }
    public Size getSize() {
        return Size.FOURTH;
    }

 }