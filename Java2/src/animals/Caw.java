package animals;

import food.*;


public class Caw extends Herbivore implements Run, Voice {
    @Override
    public void run(){
        System.out.println("Корова бегает");
    }
    @Override
    public String voice(){
        String voice = "Корова мычит";
                return voice;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Grass){
            System.out.println("Корова ест траву");
        } else System.out.println("Корова не ест мясо");

    }
}
