package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.items.FlaskOfCrimsonTears;
import game.items.Runes;
import game.Resettable;
import game.enums.Status;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public abstract class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addItemToInventory(new Runes(0));
		this.addItemToInventory(new FlaskOfCrimsonTears(2));
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		display.println(this.name + " HP = (" + this.hitPoints + "/" + this.maxHitPoints + ") ");
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void reset() {}
}
