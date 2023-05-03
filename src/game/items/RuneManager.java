package game.items;

import game.actors.enemies.Enemy;

/**
 * A rune manager class that manages the player's runes.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class RuneManager {
    private Rune rune;
    private static RuneManager runeManager = null;

    private RuneManager() {}

    public void registerRune(Rune rune) {
        this.rune = rune;
    }

    public Rune getRune() {
        return rune;
    }

    public void awardKill(Enemy enemy) {
        rune.increaseValue(enemy.generateRuneValue());
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
