import model.Kotik;
public class Application {

    public static void main(String[] args) {
        Kotik kotik = new Kotik("Барсик", "Мур", "Черный");

        Kotik kotik2 = new Kotik();
        kotik2.setName("Вася");
        kotik2.setMeow("Мурр");
        kotik2.setColor("Белый");

        kotik.liveAnotherDay();
        System.out.println("Котика зовут " + kotik.getName());
        if (kotik.getMeow().equals(kotik2.getMeow())) {
            System.out.println("Котики разговаривают одинаково");
        } else {
            System.out.println("Котики не разговаривают одинаково");
        }
        System.out.println("Всего создали " + Kotik.count + " котика");
    }
}