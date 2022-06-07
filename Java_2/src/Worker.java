import animals.*;
import food.*;
import interfaces.*;

public class Worker {
    public void feed (Animals animals, Food food){
        animals.eat(food);
    }
    public String getVoice(Voice voice) {
        return voice.voice();
    }
}