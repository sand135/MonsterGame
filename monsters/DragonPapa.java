package se.iths.sandra.monsters;


public class DragonPapa extends HardMonster {


    /**
     * Constructor for Dragonpapa. Will give it its name: DragonPapaand hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    DragonPapa(int hp) {
        super(hp, "DragonPapa");
    }

    @Override
    public String attackTalk(){
        return "Come to papa!!";
    }
}
