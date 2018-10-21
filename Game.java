package se.iths.sandra;

import se.iths.sandra.Player.DefaultPlayer;
import se.iths.sandra.Player.Player;
import se.iths.sandra.Shop.Shop;
import se.iths.sandra.monsters.Monster;
import se.iths.sandra.monsters.MonsterCollection;
import java.util.Scanner;

import static se.iths.sandra.RandomHelper.getBigChance;

/**
 * A class that starts up a new game where a player and monster can battle and player earn points to get to next level
 * Player can also go to shop and buy himself helping amulets and strength to defeat the monsters.
 */
public class Game {
    private boolean lostGame, wonGame;
    private Scanner sc;
    private Player player;
    private Shop shop;

    /**
     * Creates a new game
     * A Scanner an a shop will be created at the same time.
     */
    public Game() {
        sc = new Scanner(System.in);
        shop = new Shop(sc);
    }

    /**
     * Starts up the game and runs until player has won/lost the game or chooses to end game.
     */
    public void startGame() {

        System.out.println("************************");
        System.out.println("* Welcome to The Game! *");
        System.out.println("************************" + "\n");

        System.out.println("Enter your name?");
        String name = sc.nextLine();
        player = new DefaultPlayer(name);

        while (!lostGame && !wonGame) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    goAdventuring();
                    break;
                case 2:
                    printPlayer();
                    break;
                case 3:
                    startShop();
                    break;
                case 4:
                    System.out.println("Bye!");
                    return;

            }
        }
        if (wonGame) {
            System.out.println("***** Congratulations! You won the game! *****");
        }
    }


    /**
     * Prints out main-menu for the game
     */
    private void printMenu() {
        System.out.println("Choose what you want to do: \n" +
                "1. Go exploring\n" +
                "2. Show details about your character\n" +
                "3. Go to shop\n" +
                "4. Exit game");

    }

    /**
     * Simulates an adventure where there is an 90% chance that a random monster appears and 10% that nothing happens.
     * If a monster Appears, player gets two options: run or fight.
     */
    private void goAdventuring() {
        if (getBigChance()) {
            Monster monster = MonsterCollection.createNewMonster(RandomHelper.getInt(0, 7), player);
            System.out.println("Watch out!! In head of you stands the " + monster.toString() + "!!");
            fight(monster);

        } else {
            System.out.println("No Monster in sight. Just some grass waving in the wind. So calm...\n");
            pause();
        }
    }

    /**
     *Lets the player choose if he/she wants to fight or run away from monster.
     *There is still an approximately 50% chance the player will have to fight the monster even if he/she chooses to run.
     *Used as Helpmethod in fight().
     * @returns true if player chooses to run and false if player chooses to fight. Observe there is still an approximately 50% chance the method returns false even if player chooses to run.
     */
    private boolean runAway() {
        System.out.println("What do you want to do? \n " +
                " 1.Run away.\n " +
                " 2 Fight the Monster!");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                if (RandomHelper.get50Chance()) {
                    System.out.println("You got away..pjuuh! \n");
                    return true;
                } else {
                    System.out.println("You ran but the monster is fast! You need to fight it!");
                    pause();
                }
        }
        return false;
    }

    /**
     * Lets the player choose if he/she wants to use an amulet.
     * @return true if player chooses to use amulet, otherwise false.
     */
    private boolean WantToUseAmulet() {
        System.out.println("You have " + player.getAmulet() + " amulet(s). Would you like to use one? \n" +
                "Yes- press 1\n" +
                "No - press 2. \n");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            return true;
        }
        return false;

    }

    /**
     * Lets the player choose if he/she wants to use an strength-potion.
     * @return true if player chooses to use strength-potion, otherwise false.
     */
    private boolean wantToUseStrengthPotion(){
        System.out.println("You have " + player.getStrengthPotions() + " strength-potion(s). Would you like to use one? \n" +
                "Yes- press 1\n" +
                "No - press 2. \n");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice ==1){
            return true;
        }
        return false;
    }

    /**
     * Simulates a battle between player and Monster.
     * Runs until either player run away or Monster/player is dead.
     * Player has the opportunity to choose if he wants to use amulets or strength-potions if he has got any left.
     * Player and monster-status is printed out in the end of every battle-round that doesn't result in player or monster dying.
     * @param monster-the monster that player are fighting.
     */
    private void fight(Monster monster){

        if (runAway()) {
            return;
        }

        do {

            if (player.getAmulet() > 0) {
                if (WantToUseAmulet()) {
                    int amuletEffect = player.useAmulet();
                    monsterAttack(monster, (monster.attack() - amuletEffect));
                    System.out.println("Your amulet decreased monsters attack-strength with " + amuletEffect + ".");
                }else{
                    monsterAttack(monster, monster.attack());
                }
            } else {
                monsterAttack(monster, monster.attack());
            }


            if (player.getStrengthPotions() > 0) {
                if (wantToUseStrengthPotion()) {
                    int strengthPotionEffect = player.useStrengthPotion();
                    playerAttack(monster, (player.attack() + strengthPotionEffect));
                    System.out.println("Your strength-potion increased your strength with " + strengthPotionEffect);
                }
                else{
                    playerAttack(monster, player.attack());
                }
            } else {
                playerAttack(monster, player.attack());
            }

            if (player.isDead()) {
                System.out.println("You were killed by the monster :( \n " +
                        "Game over..");
                lostGame = true;
            }

            if (monster.isDead()){
                break;
            }
            else {
                System.out.println("Player hp : " + player.getHp() + ". \n" +
                        "Monster hp: " + monster.getHp() + ".");
                pause();
            }

        }while (true);

        int monsterExp = monster.giveExp();
        int monsterGold = monster.giveGold();
        player.earnExp(monsterExp);
        player.earnGold(monsterGold);

        System.out.println("You killed the monster earning " + monsterExp + " experience-points and " + monsterGold + " gold from the monster! \n" +
                           "Well done!\n");

        if (player.levelUp()) {
            System.out.println("\n Congratulations! You earned enough exp to get to the next level and also increased your attacking-skills!\n" +
                    "You are now on level: " + player.getLevel());

            if (player.getLevel() == 10) {
                wonGame = true;
            }else{
                pause();
            }

        } else {
            pause();
        }

    }

    /**
     * Simulates an attack from player and writes out the amount of damage it has on monster.
     * Is used as a helpmethod int fight().
     * @param monster- monster that the player attacks.
     * @param playerAttackStrength is the amount of damage players attack should do on monster
     */
    private void playerAttack(Monster monster, int playerAttackStrength) {
        System.out.println(player.attackTalk());
        monster.takeDamage(playerAttackStrength);
        System.out.println("You hit the monster dealing " + playerAttackStrength + " amount of damage\n");
    }

    /**
     * Simulates an attack of a Monster on player and writes out the amount of damage in has on player.
     * Is used as a helpmethod int fight().
     * @param m- monster that are attacking
     * @param monsterAttackStrength- the amount of damage monsters attack should do on player
     */
    private void monsterAttack(Monster m, int monsterAttackStrength) {
        System.out.println(m.attackTalk());
        player.takeDamage(monsterAttackStrength);
        System.out.println("The monster hit you dealing " + monsterAttackStrength + " amount of damage");
    }

    /**
     * Pauses the game until player press enter.
     */
    private void pause(){
        System.out.println("\n[press Enter to continue]");
        sc.nextLine();
    }

    /**
     * Prints out information about player.
     */
    private void printPlayer() {
        System.out.println(player.toString());
        pause();
    }

    /**
     * Simulates a shop where player can use his/her gold to buy more hp, more strength in fights or amulets that decreases the strength from a Monster-attack.
     */
    private void startShop() {
        shop.startShop(player);

    }
}
