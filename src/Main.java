import models.Mage;

public class Main {

    public static void main(String[] args) {

        Mage mediv = new Mage("Mediv");
        System.out.println(mediv.getDamage());
        mediv.castSpecial();
    }
}
