package model;

public class Kotik {
    private String name;
    private String meow;

    private String color;
    private int satiety;

    public static int count;

    public Kotik() {
        count++;
    }

    public Kotik(String name, String meow, String color) {
        count++;
        this.name = name;
        this.meow = meow;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;

    }

    public void liveAnotherDay() {
        for (var i = 0; i < 24; i++) {
            System.out.print("Time " + i + ":00 (satiety = " + satiety + ") ");
            if (satiety <= 0) {
                System.out.println("Kotik " + name + " hochet est'");
                eat();
            } else {
                perfomAction();
                decreaseSatietyRandomly();
            }
        }
    }

    private void perfomAction() {
        var result = random(1, 5);
        switch (result) {
            case (1):
                play();
                break;
            case (2):
                sleep();
                break;
            case (3):
                chaseMouse();
                break;
            case (4):
                walkStreet();
                break;
            case (5):
                washPaws();
                break;
            default:
                break;
        }
    }

    private void decreaseSatietyRandomly() {
        satiety = random(-3, 0);
    }

    private void eat(String foodName, int satiety) {
        this.satiety += satiety;
        System.out.println("Kotik " + name + " s'el " + foodName + " v kolichestve " + satiety + " shtuk");
    }

    private void eat(int satiety) {
        String foodName = randomFoodName();
        eat(foodName, satiety);
    }

    private void eat() {
        int satiety = random(1, 5);
        String foodName = randomFoodName();
        eat(foodName, satiety);
    }

    private void play() {
        System.out.println("Kotik " + name + " igraet");
    }

    private void walkStreet() {
        System.out.println("Kotik " + name + " gulyaet na ulitse");
    }

    private void chaseMouse() {
        System.out.println("Kotik " + name + " gonitsya za myshkoy");
    }

    private void sleep() {
        System.out.println("Kotik " + name + " spit");
    }

    private void washPaws() {
        System.out.println("Kotik " + name + " moet lapy");
    }

    private int random(int min, int max) {
        max -= min;
        return (int) (Math.random() * max + min);
    }

    private String randomFoodName() {
        int random = random(1, 5);
        switch (random) {
            case (1):
                return "Whiskas";
            case (2):
                return "Fish";
            case (3):
                return "Kitekat";
            case (4):
                return "Felix";
            case (5):
                return "Friskies";
            default:
                return "Pedigree";
        }
    }
}