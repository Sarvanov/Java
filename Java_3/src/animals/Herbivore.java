package animals;

import aviary.Size;
import food.*;

public abstract class Herbivore extends Animals {

    public Herbivore(String name, Size size) {
        super(name, size);
    }

    public void eat(Food food) throws WrongFoodException {
        if(food instanceof Grass){
            System.out.println("Травоядное ест траву");
        }
        else{
            throw new WrongFoodException("Эта еда не подходит травоядному!");
        }
    }
}