package se.iths.sandra.monsters;

public class DefaultMonster extends EasyMonster {

    /**
     * Constructor for DefaultMonster. Will give it its name: Monster, and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    DefaultMonster(int hp) {
        super(hp, "Monster");
    }

}
