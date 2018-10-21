package se.iths.sandra.monsters;

public class Snake extends HardMonster {

    /**
     * Constructor for Snake. Will give it its name: Snake, and hp-points.
     * @param hp the hp-points to give the monster at start.
     */
    Snake(int hp) {
        super(hp, "Snake");
    }

    @Override
    public String attackTalk(){
        return "SSSSSS..I will squeeeze you!";
    }
}
