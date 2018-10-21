package se.iths.sandra.Player;

/**
 * Interface that defines the standard methods for a player.
 */
public interface Player {

    /**
     * Tells the Player to attack.
     * @returns the amount of damage the attack made.
     */
    public int attack();

    /**
     * Decreases player Hp- points
     * @param amountOfDamage- the amount of hp-points to subtract from the current hp of player.
     */
    public void takeDamage(int amountOfDamage);

    /**
     * Increases player exp-points
     * @param newExp -the amount of exp-points to add to player exp.
     */
    public void earnExp(int newExp);

    /**
     * Increases player's amount of gold.
     * @param gold- the amount of gold to add to player's total amount of gold.
     */
    public void earnGold(int gold);

    /**
     * Increases Player's hp.
     * @param health the amount of hp-points to add to Players current hp-points.
     */
    public void earnHealth(int health);

    /**
     * Checks if player is dead
     * @returns true if player's hp is 0 or less. False if players'hp is greater than 0.
     */
    public boolean isDead();

    /**
     *
     * @returns players current hp-points
     */
    public int getHp();

    /**
     *
     * @returns players current (total) amount of Exp-points.
     */
    public int getExp();

    /**
     *
     * @returns the amount of exp that player has earned in the current level.
     */
    public int getExpCounter();

    /**
     *
     * @returns the current level Players's on.
     */
    public int getLevel();

    /**
     *
     * @returns the current amount of gold player has.
     */
    public int getGold();

    /**
     * Checks if player has earned enough exp-points to get to next level and increases level with 1 if that is the case.
     * @returns true if player has earned enough exp-points to reach the next level and false if not.
     */
    public boolean levelUp();

    /**
     *
     * @returns player's battle cry.
     */
    public String attackTalk();

    /**
     *
     * @returns the amount of strengthpotions player got.
     */
    public int getStrengthPotions();

    /**
     *
     * @returns the amount of amulets player got.
     */
    public int getAmulet();

    /**
     * Lets player use one amulet to shield himself from monster attack.
     * @returns the amount of shielding-points that should be reduced from monsterHp.
     */
    int useAmulet();

    /**
     * Lets player use one strength-potion to increase his/hers amount of damage the attack makes.
     * @returns the amount of strength that should be added to players attack-method.
     */
    int useStrengthPotion();

    /**
     * Lets player buy an amulet that is added to his total amount of amulets.
     */
    void buyAmulet();

    /**
     * lets player buy hp-points that increases his/hers total hp-points.
     * @param amountOfHp the amount of hp that should be added to players hp.
     */
    void buyHealthpotion(int amountOfHp);

    /**
     * lets the player buy on strengthpotion and adds it to his/hers total amount of potions.
     */
    void buyStrengthpotion();

    /**
     * Checks if player has enough gold to buy items.
     * @param price- the price of the item
     * @return true if player has enough gold, and false if not.
     */
    boolean hasEnoughMoney(int price);
}
