package game.items;

import game.actors.DropsRunes;

/**
 * A rune manager class that manages the player's runes.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class RuneManager {
    private Rune rune;
    /**
     * Only one instance of RuneManager is allowed.
     */
    private static RuneManager runeManager = null;

    /**
     * The constructor.
     */
    private RuneManager() {}

    /**
     * Sets the player's rune.
     * @param rune
     */
    public void registerRune(Rune rune) {
        this.rune = rune;
    }

    /**
     * Gets the player's rune.
     * @return rune
     */
    public Rune getRune() {
        return rune;
    }

    /**
     * Increases the player's runes when an enemy is defeated.
     * @param enemy actor that is able to drop runes
     */
    public void awardKill(DropsRunes enemy) {
        rune.increaseValue(enemy.generateRuneValue());
    }

    public void boostRuneAwardKill(DropsRunes enemy) {
        rune.increaseValue(enemy.generateRuneValue()*2);
    }

    /**
     * Factory method used to have only one instance of RuneManager.
     * @return the instance of runeManager.
     */
    public static RuneManager getInstance() {
        if (runeManager == null) { runeManager = new RuneManager(); }
        return runeManager;
    }
}
