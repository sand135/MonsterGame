package se.iths.sandra.Player;
import se.iths.sandra.RandomHelper;

/**
 * A class that represents a player.
 * A player has a name, hp-points, exp-points, gold, amulets etc. and various different methods implemented from the interface Player.
 */
public class DefaultPlayer implements Player {

    private String name;
    private int hp;
    private int exp;
    private int level;
    private int gold;
    private int amulet;
    private int expCounter;
    private int strengthPotions;



    //region Constructors
    private DefaultPlayer(String name, int hp, int exp) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.level = 1;
    }

    /**
     * a constructor that instantializes a new player giving him a name, 200 hp-points and 0 exp-points.
     * @param name- the name of the player.
     */
    public DefaultPlayer(String name){
        this(name, 200, 0);
    }
    //endregion

    //region Getters and setters

    @Override
    public int getAmulet() {
        return amulet;
    }

    @Override
    public int getStrengthPotions() {
        return strengthPotions;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public int getExpCounter() {
        return expCounter;
    }
    //endregion


    @Override
    public boolean levelUp() {
        if(expCounter >=20){
            expCounter = 0;
            level++;
            return true;
        }
        return false;
    }

    @Override
    public int attack() {

        switch (level){
            case 1:
                return RandomHelper.getInt(1,10);
            case 2:
                return RandomHelper.getInt(3, 13);
            case 3:
                return RandomHelper.getInt(6,16);
            case 4:
                return RandomHelper.getInt(9, 19);
            case 5:
                return RandomHelper.getInt(12,21);
            case 6:
                return RandomHelper.getInt(15,24);
            case 7:
                return RandomHelper.getInt(18,27);
            case 8:
                return RandomHelper.getInt(15,30);
            case 9:
                return RandomHelper.getInt(18,33);
            default:
                return 0;
        }

    }

    @Override
    public void takeDamage(int amountOfDamage) {
        hp = hp - amountOfDamage;
    }

    @Override
    public void earnExp(int newExp) {
        exp = exp + newExp;
        expCounter = expCounter + newExp;
    }

    @Override
    public void earnGold(int gold) {
        this.gold = this.gold + gold;
    }

    @Override
    public void earnHealth(int health) {
        hp = hp + health;
    }

    @Override
    public boolean isDead(){
        if (hp <= 0){
            return true;
        }
        return false;
    }

    @Override
    public String attackTalk(){
        return "Take that you ugly Monster!!";
    }

    @Override
    public int useAmulet(){
        amulet--;
        return 10;
    }

    @Override
    public int useStrengthPotion() {
        if(strengthPotions > 0) {
            strengthPotions--;
            return 30;
        }
        return 0;
    }

    @Override
    public void buyAmulet() {
            amulet++;
    }

    @Override
    public void buyHealthpotion(int amountOfHP) {

        hp = hp + amountOfHP;

    }

    @Override
    public void buyStrengthpotion() {
            strengthPotions++;
    }

    @Override
    public boolean hasEnoughMoney(int price){
        if (gold >= price) {
            gold = gold - price;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String s = "\n"+"Player info:"+"\n\n"+
                "Level      : " + level +"\n"+
                "Name       : " + name +"\n"+
                "Hp         : "+ hp +"\n"+
                "Exp        : " +exp +"\n"+
                "Gold       : "+ gold+"\n" +
                "Amulets    : " + amulet + "\n"+
                "Strength-potions: "+ strengthPotions+ "\n";
        return s;
    }


}
