import animals.Animals;
import food.Food;
import food.WrongFoodException;
import interfaces.Voice;

public class Worker {
    public void feed (Animals animals, Food food) throws WrongFoodException {
        animals.eat(food);
    }
    public String getVoice(Voice voice) {
        return voice.voice();
    }
}