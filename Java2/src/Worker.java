import animals.*;
import food.Food;
import interfaces.Voice;

public class Worker {
    public void feed (Animals animals, Food food){
        animals.eat(food);
    }
    public String getVoice(Voice voice) {
        return voice.voice();
    }
}