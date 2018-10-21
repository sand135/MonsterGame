package se.iths.sandra.monsters;

public class CookieMonster extends EasyMonster {


    /**
     * Constructor for CookieMonster. Will give it its name and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    public CookieMonster (int hp){
        super(hp, "CookieMonster");
    }

    @Override
    public String attackTalk(){
        return "Attack! Eat my crunches!";
    }
}
