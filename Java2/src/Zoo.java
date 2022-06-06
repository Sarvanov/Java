import animals.*;
import food.*;
import interfaces.Swim;

import java.util.ArrayList;
import java.util.Arrays;

public class Zoo {
    public static void main(String[] args) {
        Caw caw = new Caw("Корова");
        Duck duck = new Duck("Утка");
        Fish fish = new Fish("Рыба щука");
        Horse horse = new Horse("Лошадь");
        Tiger tiger = new Tiger("Тигр");
        Wolf wolf = new Wolf("Волк");
        Worker worker = new Worker();

        Food food = new Food();
        Grass grass = new Grass();
        Meat meat = new Meat();

        duck.voice();
        System.out.println(duck.voice());
        duck.fly();
        duck.swim();

        caw.run();
        caw.voice();
        System.out.println(caw.voice());

        fish.swim();

        horse.run();
        horse.voice();
        System.out.println(horse.voice());

        tiger.run();
        tiger.voice();
        System.out.println(tiger.voice());

        wolf.run();
        wolf.voice();
        System.out.println(wolf.voice());

        worker.feed(caw, grass);
        worker.feed(caw, meat);
        worker.feed(duck, grass);
        worker.feed(duck, meat);
        worker.feed(fish, grass);
        worker.feed(fish, meat);
        worker.feed(horse, grass);
        worker.feed(horse, meat);
        worker.feed(tiger, grass);
        worker.feed(tiger, meat);
        worker.feed(wolf, grass);
        worker.feed(wolf, meat);

        worker.getVoice(caw);
        worker.getVoice(duck);
        worker.getVoice(horse);
        worker.getVoice(tiger);
        worker.getVoice(wolf);

//        String[] swim = new String[]{Animals};
//
//        for (int i = 0; i < swim.length; i++){
//            System.out.println(swim[i]);}

//        String[] pond = new String[2];
//        pond[0] = "duck";
//        pond[1] = "fish";
//        for (int i = 0; i < 2 ; i++);{
//            System.out.println(pond[0][1]);
//        }


   /*     String [] pond = new String[] {duck.swim(), fish.swim()};

        for (int i = 0; i < pond.length; i++) {
            System.out.println(pond[i]);
        }*/

    }
}