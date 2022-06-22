package aviary;

import animals.Animals;

import java.util.HashMap;
import java.util.Map;

public class Aviary<A extends Animals> {
    private Size size;
    private Map<String, A> map = new HashMap<>();

    public Aviary(Size size) {
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void addAnimal(A animals)  {
        if (animals.getSize().ordinal() <= size.ordinal()) {
            map.put(animals.getName(), (A) animals);
        }
        else {
            throw new WrongSizeException("Не подходит размер вольера!");}
    }

    public A removeAnimal (String name){
        return map.remove(name);
    }

    public A getAnimal(String name){
        return map.get(name);
    }
 }