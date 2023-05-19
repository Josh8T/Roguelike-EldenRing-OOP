package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.players.StartingClass;
import game.items.Rune;
import game.items.RuneManager;

public class DropRuneAction extends DropAction {

    private final Rune rune;

    private StartingClass player;

    /**
     * Constructor.
     * @param rune the rune to drop
     */
    public DropRuneAction(Rune rune, StartingClass player) {
        super(rune);
        this.rune = rune;
        this.player = player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Rune droppedRune = new Rune(rune.value(), player);
        player.getLastLocation().addItem(droppedRune);
        droppedRune.setLocation(player.getLastLocation());
        RuneManager.getInstance().getRune().resetValue();
        return menuDescription(actor);
    }
}
