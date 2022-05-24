import model.Kotik;
public class Application {

    public static void main(String[] args) {
        Kotik kotik = new Kotik("������", "���", "׸����");

        Kotik kotik2 = new Kotik();
        kotik2.setName("����");
        kotik2.setMeow("����");
        kotik2.setColor("�����");

        kotik.liveAnotherDay();
        System.out.println("������ ����� " + kotik.getName());
        if (kotik.getMeow().equals(kotik2.getMeow())) {
            System.out.println("������ ������������� ���������");
        } else {
            System.out.println("������ �� ������������� ���������");
        }
        System.out.println("����� ������� " + Kotik.count + " ������");
    }
}