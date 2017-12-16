package utils;

public class Printer {

    public static String invalidPlayerClass = "Invalid Player Class: ";

    public static void chooseClass() {
        System.out.println("Type number for choosing class: 1 - Warrior, 2 - Mage, 3 - Warlock");
    }

    public static void invalidInput() {
        System.out.println("Invalid input!");
    }

    public static void chooseName() {
        System.out.println("Type your name and press Enter");
    }

    public static void faceEnemy(String playerName, String monsterName) {
        System.out.println(playerName + " have faced " + monsterName);
    }

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

    public static void soulTradePenalty(String name, String spellName, int spellDamageDealt) {
        System.out.println(name + " cast " + spellName + " and suffers " + spellDamageDealt + " from it");
    }

    public static void warlockCastSpecial(String name, String spellName, int spellDamageDealt) {
        System.out.println(name + " deal " + spellDamageDealt + " from " + spellName);
    }

    public static void giantSpiderCastSpecial(String name, String spellName, int spellDamageDealt) {
        System.out.println(name + " cast " + spellName + " deal " + spellDamageDealt + " damage");
    }

    public static void minotaurCastSpecial(String name, String spellName) {
        System.out.println(name + " get " + spellName + "!!!" );
    }

    public static void stepDeeper() {
        System.out.println("Press Enter to step deeper in the dungeon...");
    }

    public static void processDuelPhase() {
        System.out.println("Press Enter to process next duel phase...");
    }

    public static void playerDefeatMonster(String playerName, String monsterName) {
        System.out.println("==================== " + playerName + " has defeated " + monsterName + " ====================");
    }

    public static void monsterDefeatPlayer(String playerName) {
        System.out.println("============================================================");
        System.out.println("====================  Game Over ====================");
        System.out.println("==================== " + playerName + " is dead. ====================");
        System.out.println("============================================================");
    }

    public static void victory(String playerName) {
        System.out.println("============================================================");
        System.out.println("==================== Congratulations!!! ====================");
        System.out.println("==================== " + playerName + " is now master of the dungeon! ====================");
        System.out.println("============================================================");
    }

}
