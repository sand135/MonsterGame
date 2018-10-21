package se.iths.sandra.monsters;

import se.iths.sandra.Player.Player;
import se.iths.sandra.RandomHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that helps to create new Monstercollection of Classes; Worm, Snake, CinnamonBunmonster, CookieMonster,
 * DragonBaby, DragonMama, DragonPapa and DeafultMonster.
 */
public class MonsterCollection {

    /**
     * Creates a new Monster based on type.
     * @param type - insert number between 0-7. Numbers between 0-6 creates specific Monster. 7 or more will create a DefaultMonster.
     * @returns a new Monster.
     */
    private static Monster createNewMonster(int type){
        switch(type){
            case 0:
                return new CookieMonster(RandomHelper.getInt(3,10));
            case 1:
                return new Worm(RandomHelper.getInt(3,10));

            case 2:
                return new DragonBaby (RandomHelper.getInt(3,10));

            case 3:
                return new DragonMama(RandomHelper.getInt(8,15));

            case 4:
                return new DragonPapa(RandomHelper.getInt(20,40));

            case 5:
                return new Snake(RandomHelper.getInt(8,15));

            case 6:
                return new CinnamonBunMonster(RandomHelper.getInt(8,15));
            default:
                return new DefaultMonster(10);

        }
    }

    /**
     * Creates a new monster. Based on what level player is on it creates monster with higher hp for higher levels.
     * @param type- insert number between 0-7. 0-6 creates specifik Monster. 7 or more will create a defaultmonster.
     * @param player- insert player to check for player level.
     * @return Monster
     */
    public static Monster createNewMonster(int type, Player player){

        if (player.getLevel() <= 4) {
            switch (type) {
                case 0:
                    return new CookieMonster(RandomHelper.getInt(3,10));
                case 1:
                    return new Worm(RandomHelper.getInt(3,10));

                case 2:
                    return new DragonBaby (RandomHelper.getInt(3,10));

                case 3:
                    return new DragonMama(RandomHelper.getInt(6,15));

                case 4:
                    return new DragonPapa(RandomHelper.getInt(10,20));

                case 5:
                    return new Snake(RandomHelper.getInt(8,15));

                case 6:
                    return new CinnamonBunMonster(RandomHelper.getInt(8,15));
                default:
                    return new DefaultMonster(10);
            }

        } else {
            switch (type) {
                case 0:
                    return new CookieMonster(RandomHelper.getInt(10, 16));
                case 1:
                    return new Worm(RandomHelper.getInt(13, 15));

                case 2:
                    return new DragonBaby(RandomHelper.getInt(4, 10));

                case 3:
                    return new DragonMama(RandomHelper.getInt(15, 40));

                case 4:
                    return new DragonPapa(RandomHelper.getInt(20, 50));

                case 5:
                    return new Snake(RandomHelper.getInt(18, 20));

                case 6:
                    return new CinnamonBunMonster(RandomHelper.getInt(13, 45));

                default:
                    return new DefaultMonster(20);
            }
        }
    }

    /**
     * Creates a List with different monsters in.
     * @return a list with Monsters
     */
    public static List<Monster> getMonsterCollection() {
        List<Monster> monsterCollection = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            monsterCollection.add(MonsterCollection.createNewMonster(i));
        }
        return monsterCollection;
    }
}
