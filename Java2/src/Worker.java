import animals.Animals;
import food.Food;

public class Worker {
    public void feed (Animals animals, Food food){

        animals.eat(food);
    }
    public Animals getVoice(Animals animals){
        System.out.println(animals.voice());
        return animals;
    }
}
