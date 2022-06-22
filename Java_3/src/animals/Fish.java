package animals;

import aviary.Size;
import interfaces.Swim;

public class Fish extends Carnivorous implements Swim {

    public Fish(String name, Size size) {
        super(name, size);
    }

    @Override
    public void swim() {
        System.out.println("Рыба плавает");
    }
}