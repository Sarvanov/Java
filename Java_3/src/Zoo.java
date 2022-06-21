import animals.*;
import aviary.Aviary;
import aviary.Size;
import food.Food;
import food.Grass;
import food.Meat;
import interfaces.Swim;

import java.util.HashMap;
import java.util.Map;

public class Zoo {
    public static void main(String[] args) {
        Caw caw = new Caw("Буренка");
        Duck duck = new Duck("Дональд Дак");
        Fish fish = new Fish("Щука");
        Horse horse = new Horse("Пегас");
        Tiger tiger = new Tiger("Полосатик");
        Wolf wolf = new Wolf("Серый");
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

//        worker.feed(caw, grass);
//        worker.feed(caw, meat);
//        worker.feed(duck, grass);
//        worker.feed(duck, meat);
//        worker.feed(fish, grass);
//        worker.feed(fish, meat);
//        worker.feed(horse, grass);
//        worker.feed(horse, meat);
//        worker.feed(tiger, grass);
//        worker.feed(tiger, meat);
//        worker.feed(wolf, grass);
//        worker.feed(wolf, meat);

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
        Aviary<Carnivorous> carnivorousAviary = new Aviary<>();
        Aviary<Herbivore> herbivoreAviary = new Aviary<>();

//        Map<Integer, Carnivorous> carnivorousMap = new HashMap<>();
//        carnivorousMap.put(1, new Carnivorous("Щука"));
//        carnivorousMap.put(2, new Carnivorous("Полосатик"));
//        carnivorousMap.put(3, new Carnivorous("Серый"));
//        System.out.println(carnivorousMap);
//        System.out.println(carnivorousMap.get(1));
//        carnivorousMap.remove(1);
//        System.out.println(carnivorousMap);
//
//        Map<Integer, Herbivore> herbivoreMap = new HashMap<>();
//        herbivoreMap.put(1, new Herbivore("Буренка"));
//        herbivoreMap.put(2, new Herbivore("Дональд Дак"));
//        herbivoreMap.put(3, new Herbivore("Пегас"));
//        System.out.println(herbivoreMap);
//        herbivoreMap.remove(2);
//        System.out.println(herbivoreMap);

        Map<Integer, String> carnivorousMap = new HashMap<>();
        carnivorousMap.put(1, "Щука");
        carnivorousMap.put(2, "Полосатик");
        carnivorousMap.put(3, "Серый");
        System.out.println(carnivorousMap);
        System.out.println(carnivorousMap.get(1));
        carnivorousMap.remove(1);
        System.out.println(carnivorousMap);

        Map<Integer, String> herbivoreMap = new HashMap<>();
        herbivoreMap.put(1, "Буренка");
        herbivoreMap.put(2, "Дональд Дак");
        herbivoreMap.put(3, "Пегас");
        System.out.println(herbivoreMap);
        herbivoreMap.remove(2);
        System.out.println(herbivoreMap);

        System.out.println(caw.getSize().equals(Size.THIRD)); // false
        System.out.println(caw.getSize().equals(Size.FOURTH)); // true
        System.out.println(fish.getName());
    }
}