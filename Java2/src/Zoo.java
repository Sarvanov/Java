import animals.*;
import food.*;
import interfaces.*;

public class Zoo {
    public static void main(String[] args) {
        Caw caw = new Caw();
        Duck duck = new Duck();
        Fish fish = new Fish();
        Horse horse = new Horse();
        Tiger tiger = new Tiger();
        Wolf wolf = new Wolf();
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

        Swim[] pond = {duck, fish};
        for (int i = 0; i < pond.length; i++) {
            Swim animal = pond[i];
            animal.swim();
        }

    }
}