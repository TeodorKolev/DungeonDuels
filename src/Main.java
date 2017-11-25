import models.Mage;
import models.Warrior;

public class Main {

    public static void main(String[] args) {

        Warrior mediv = new Warrior("Mediv");
        System.out.println(mediv.getDamage());
        mediv.doDamage();
    }
}
