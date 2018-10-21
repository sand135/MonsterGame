package se.iths.sandra.monsters;


public class DragonMama extends HardMonster {


    /**
     * Constructor for DragonMama. Will give it its name: DragonMama and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    public DragonMama(int hp) {
        super(hp , "DragonMama");
    }

    @Override
    public String attackTalk(){
        return "Come to Mama!!";
    }
}
