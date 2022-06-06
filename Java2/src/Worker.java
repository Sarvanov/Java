import animals.*;
import food.Food;

public class Worker {
    public void feed (Animals animals, Food food){
        animals.eat(food);
    }
    public void getVoice(Caw caw){
        System.out.println(caw.voice());
    }
    public void getVoice(Duck duck) { System.out.println(duck.voice()); }
    public void getVoice(Horse horse){
        System.out.println(horse.voice());
    }
    public void getVoice(Tiger tiger){
        System.out.println(tiger.voice());
    }
    public void getVoice(Wolf wolf){
        System.out.println(wolf.voice());
    }
    
}