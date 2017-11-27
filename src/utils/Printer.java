package utils;

public class Printer {

    public static void printDealDamage(String name, int damage) {
        System.out.println(name + " deal " + damage + " damage.");
    }

    public static void printTakeDamage(String name, int damage, int health) {
        System.out.println(name + " gets " + damage + " damage. Remaining life: " + health + " health.");
    }

}
