import animals.*;
import aviary.Aviary;
import aviary.Size;
import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;
import interfaces.Swim;

public class Zoo {
    public static void main(String[] args) throws WrongFoodException {
        Caw caw = new Caw("Буренка", Size.EXTRALARGE);
        Duck duck = new Duck("Дональд Дак", Size.MEDIUM);
        Fish fish = new Fish("Щука", Size.SMALL);
        Horse horse = new Horse("Пегас", Size.EXTRALARGE);
        Tiger tiger = new Tiger("Полосатик", Size.LARGE);
        Wolf wolf = new Wolf("Серый", Size.LARGE);
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
        Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.EXTRALARGE);
        Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.LARGE);

        carnivorousAviary.addAnimal(fish);
        carnivorousAviary.addAnimal(tiger);
        carnivorousAviary.addAnimal(wolf);
        System.out.println(carnivorousAviary);
        carnivorousAviary.getAnimal("Щука");
        carnivorousAviary.removeAnimal("Полосатик");

        herbivoreAviary.addAnimal(caw);
        herbivoreAviary.addAnimal(duck);
        herbivoreAviary.addAnimal(horse);
        System.out.println(herbivoreAviary);
        herbivoreAviary.getAnimal("Дональд Дак");
        herbivoreAviary.removeAnimal("Буренка");

        System.out.println(fish.getName());
        System.out.println(horse.getSize());
    }
}