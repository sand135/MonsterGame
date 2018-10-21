package se.iths.sandra.monsters;

/**
 * Interface Monster that defines the standard-methods for a Monster.
 */
public interface Monster {

    /**
    Tells the Monster to attack.
    @returns the amount of damage the attack made.
     */
    abstract int attack();

    /**
    Tells the Monster to take damage.
    This reduces the monster's hp.
    @param amountOfdamage - the amount of hp-points to subtract from current hp.
     */
    abstract void takeDamage(int amountOfdamage);

    /**
    Checks if the monster is dead or not.
    @returns true if monster's hp is equal to 0 or less(=dead), false if alive.
     */
    abstract boolean isDead();

    /**
    Tells the Monster to give exp.
    @returns the amount of exp- points the monster gives away.
     */
    abstract int giveExp();

    /**
     * Tells the Monster to give gold.
     * @returns the amount of gold the monster gives away.
     */
    public int giveGold();

    /**
     *
     * @return name of Monster.
     */
    public String getName();

    /**
     *
     * @returns Monsters battle cry.
     */
    public String attackTalk();

    /**
    Returns the current Hp of the Monster.
     */
    public int getHp();

}
