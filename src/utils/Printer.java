package utils;

public class Printer {

    public static void dealDamage(String name, int damage) {
        System.out.println(name + " deal " + damage + " damage.");
    }

    public static void takeDamage(String name, int damage, int health) {
        System.out.println(name + " gets " + damage + " damage. Remaining life: " + health + " health.");
    }

    public static void startLogo() {
        System.out.println(ASCIIArt.START_LOGO);
    }

    public static void warriorCastSpecial(String name, String spellName, int spellDamageDealt) {
        System.out.println(name + " cast " + spellName + " deal " + spellDamageDealt + " damage");
    }

    public static void mageCastSpecial(String name, String spellName, int spellDamageDealt) {
        System.out.println(name + " cast " + spellName + " deal " + spellDamageDealt + " damage");
    }

    public static void playerDefeatMonster(String playerName, String monsterName) {
        System.out.println(playerName + " has defeated " + monsterName);
    }

    public static void monsterDefeatPlayer(String playerName) {
        System.out.println(playerName + " is dead. Game Over! ");
    }

}
