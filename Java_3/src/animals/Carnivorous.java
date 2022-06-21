package animals;

import food.*;

import java.util.Objects;

public abstract class Carnivorous extends Animals{

    public Carnivorous(String name) {
        super(name);
    }

//    public void eat (Food food){
//        if (food instanceof Meat){
//            System.out.println("Хищник ест мясо");
//        } else System.out.println("Хищник не ест траву");
//    }
    @Override
    public String eat(Food food) throws WrongFoodException {
        if(food instanceof Meat){
            return "Жищник ест мясо!";
        }
        else{
            throw new WrongFoodException("Эта еда не подходит хищнику!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carnivorous that = (Carnivorous) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}