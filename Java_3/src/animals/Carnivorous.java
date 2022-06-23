package animals;

import aviary.Size;
import food.*;

public abstract class Carnivorous extends Animals{

    public Carnivorous(String name, Size size) {
        super(name, size);
    }

    public void eat(Food food) throws WrongFoodException {
        if(food instanceof Meat){
            System.out.println("Жищник ест мясо!");
        }
        else{
            throw new WrongFoodException("Эта еда не подходит хищнику!");
        }
    }
}