package se.iths.sandra.monsters;

import se.iths.sandra.RandomHelper;

/**
 * HardMonsters has higher attacking-strength and gives more exp-points and gold than EasyMonsters.
 */
public abstract class HardMonster implements Monster {

    private int hp;
    private String name;

    //region Constructor
    HardMonster(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }
    //endregion

    //region Getters and setters
    public int getHp() {
        return hp;
    }

    public String getName(){
        return name;
    }
    //endregion

    @Override
    public String attackTalk(){
        return "MONSTER-attack!!!";
    }

    @Override
    public int attack() {
        return RandomHelper.getInt(7,20);
    }

    @Override
    public void takeDamage(int amountOfdamage) {
        hp = hp - amountOfdamage;
    }

    public boolean isDead(){
        if (hp<=0){
            return true;
        }
        return false;
    }

    @Override
    public int giveExp() {
        return RandomHelper.getInt(7, 15);
    }

    @Override
    public int giveGold() {
        return RandomHelper.getInt(5,10);
    }

    @Override
    public String toString(){
        return name + " (hp: " + hp + ", attackingpowers: 7-20) ";
    }
}
