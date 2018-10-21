package se.iths.sandra.monsters;

import se.iths.sandra.RandomHelper;

/**
 * An abstract class that specifies the methods of an easyMonster
 * every Easymonster has an name and hp-points.
 * EasyMonsters has lower attacking-strength and gives less exp-points and gold than hardMonster.
 */
public abstract class EasyMonster implements Monster {

    private int hp;
    private String name;

    //region Constructor

    /**
     * The contructor of an easymonster that needs to be implemented in subclasses of it
     * @param hp the hp-points of the monster.
     * @param name the name of the monster
     */
    EasyMonster(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }
    //endregion

    //region Getters and setters
    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public String getName(){
        return name;
    }
    //endregion


    @Override
    public String attackTalk(){
        return "Monster-attack!!!";
    }

    @Override
    public int attack() {
        return RandomHelper.getInt(1,10);
    }

    @Override
    public void takeDamage(int amountOfdamage) {
        hp = hp - amountOfdamage;
    }

    @Override
    public boolean isDead(){
        if (hp<=0){
            return true;
        }
        return false;
    }

    @Override
    public int giveExp() {
        return RandomHelper.getInt(1, 10);
    }

    @Override
    public int giveGold() {
        return RandomHelper.getInt(1,5);
    }

    @Override
    public String toString(){
        return name + " (hp: " + hp + ", attackingPower: 1-10)";
    }


}