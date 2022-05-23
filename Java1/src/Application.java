import model.Kotik;

public class Application {

    public static void main(String[] args) {
        Kotik kotik = new Kotik("Barsik", "Mur", "Black");

        Kotik kotik2 = new Kotik();
        kotik2.setName("Vasya");
        kotik2.setMeow("Murr");
        kotik2.setColor("White");

        kotik.liveAnotherDay();
        System.out.println("Kotika zovut " + kotik.getName());
        if (kotik.getMeow().equals(kotik2.getMeow())) {
            System.out.println("Kotiki razgovarivayut odinakovo");
        } else {
            System.out.println("Kotiki ne razgovarivayut odinakovo");
        }
        System.out.println("Vsego sozdali " + Kotik.count + " kotikov");
    }
}