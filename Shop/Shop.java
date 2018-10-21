package se.iths.sandra.Shop;

import se.iths.sandra.Player.Player;

import java.util.Scanner;



public class Shop {

    private Scanner sc;
    private final int amuletPrice = 3;
    private final int strengthPotionPrice = 10;
    private final int healthPotionPrice = 5;
    private int healthPotionEffect = 20;

    public Shop(Scanner sc) {
        this.sc = sc;
    }

    public void startShop(Player p) {
        boolean continueShopping = true;
        do {
            shopMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showShopItemInfo();
                    pause();
                    break;
                case 2:
                    sellAmulet(p);
                    pause();
                    break;
                case 3:
                    sellStrengthPotion(p);
                    pause();
                    break;
                case 4:
                    sellHealthPotion(p);
                    pause();
                    break;
                case 5:
                    continueShopping = false;
                    break;
            }
        } while (continueShopping);
    }

    public void sellHealthPotion(Player p) {
        if(p.hasEnoughMoney(healthPotionPrice)) {
            p.buyHealthpotion(healthPotionEffect);
            System.out.println("You bought on bottle of health-potion!\n" +
                               "You increased your hp with "+ healthPotionEffect +
                               "You've got "+ p.getGold() + " gold left");
        }else{
            System.out.println("Not enough gold!");
        }
    }

    public void sellStrengthPotion(Player p) {
        if(p.hasEnoughMoney(strengthPotionPrice)) {
            p.buyStrengthpotion();;
            System.out.println("You bought on bottle of strengthpotion!\n" +
                    "You've got "+ p.getGold() + " gold left");
        }else{
            System.out.println("Not enough gold!");
        }
    }

    public void shopMenu(){
        System.out.println("Welcome to the shop! \n" +
                           "What do you want to do?\n" +
                           "1. Show information about the items in the shop.\n" +
                           "2. Buy amulets " + "("+ amuletPrice + " gold) \n" +
                           "3. Buy strengthpotion (" + strengthPotionPrice + " gold)\n" +
                           "4. Buy Healthpotion (" + healthPotionPrice+ " gold)\n" +
                           "5. Return to game.");
    }

    public void showShopItemInfo(){
        System.out.println("you can buy: \n" +
                           "- Amulets that shields you from monster-attacks by reducing the attack-strength of the Monster.\n" +
                           "- Strength-potions that increases your attack-strength.\n" +
                           "- Health-potions that increases your hp instantly with 20");
    }

    public void sellAmulet(Player p){
        if(p.hasEnoughMoney(amuletPrice)) {
            p.buyAmulet();
            System.out.println("You bought an amulet!\n" +
                    "You've got "+ p.getGold() + " gold left");
        }else{
            System.out.println("Not enough gold!");
        }
    }


    private void pause(){
        System.out.println("\n[press Enter to continue]");
        sc.nextLine();
    }

}
