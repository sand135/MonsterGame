package se.iths.sandra.monsters;

public class DragonBaby extends EasyMonster {

    /**
     * Constructor for DragonBaby. Will give it its name: DragonBaby and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    DragonBaby(int hp) {
        super(hp, "DragonBaby");
    }

    @Override
    public String attackTalk(){
        return "BABY FIRE!! ";
    }
}
