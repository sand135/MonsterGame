package se.iths.sandra.monsters;

public class CinnamonBunMonster extends HardMonster {

    /**
     * Constructor for CinnamonBunMonster. Will give it its name and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    public CinnamonBunMonster(int hp){
        super(hp,"CinnamonBunMonster" );
    }

    @Override
    public String attackTalk(){
        return "Come here you little thing! I will make a Cinnamon bun out of you!!";
    }
}
