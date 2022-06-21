package aviary;

import animals.Animals;
import animals.Carnivorous;
import animals.Herbivore;

import java.util.HashMap;
import java.util.Map;

public class Aviary<A extends Animals> {
    private Size size;
    private String name;

    public Aviary() {
        this.size = size;
    }
    public Size getSize() {
        return size;
    }

    private Map<String, A> map = new HashMap<>();

//    Aviary<Carnivorous> carnivorousAviary = new Aviary<>();
//
//    Aviary<Herbivore> herbivoreAviary = new Aviary<>();

   //    Map<Integer, Animals> animals = new HashMap<>();

//    Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.FOURTH);
//    Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.THIRD);

    public void addAnimal(A animals)  {
        if(size.equals(animals.getSize())){
            map.put(animals.getName(),animals);}
        else {
            throw new WrongSizeException("Не подходит размер вольера!");}
    }

//    public void removeAnimal (A animals){
//        A animals = map.remove(name);
//        System.out.println(animals);
//        return animals;
//    }

    public A getAnimal(String name){
        A animals = map.get(name);
        System.out.println(animals);
        return animals;
    }

    public <A> String getA(A a){
        return a.toString();
    }

}