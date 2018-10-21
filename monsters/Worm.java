package se.iths.sandra.monsters;

public class Worm extends EasyMonster {

    /**
     * Constructor for Worm. Will give it its name: Worm Mikey, and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    Worm(int hp) {
        super(hp, "Worm Mikey");
    }

    @Override
    public String attackTalk(){
        return "Slurp!!";
    }
}
