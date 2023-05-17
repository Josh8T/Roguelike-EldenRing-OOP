package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actions.ConsumeAction;
import game.items.FlaskOfCrimsonTears;
import game.items.Rune;
import game.Resettable;
import game.enums.Status;
import game.items.RuneManager;

/**
 * Class representing the Starting Class. It implements the Resettable interface.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Aflah Hanif Amarlyadi, Josh Hernett Tan, David Lee
 */
public abstract class StartingClass extends Actor implements Resettable {

	private final Menu menu = new Menu();

	private FlaskOfCrimsonTears flaskOfCrimsonTears;

	private Location checkpoint;

	/**
	 * Constructor.
	 *
	 * @param hitPoints Starting Class's number of hit points
	 */
	public StartingClass(int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.FOLLOWABLE);
		this.addCapability(Status.RESTING);
		Rune rune = new Rune(0);
		this.addItemToInventory(rune);
		RuneManager.getInstance().registerRune(rune);
		this.flaskOfCrimsonTears = new FlaskOfCrimsonTears(2);
		ResetManager.getInstance().registerResettable(this.flaskOfCrimsonTears);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		actions.add(new ConsumeAction(flaskOfCrimsonTears, this));

		display.println(printHp() + ", Runes: " + RuneManager.getInstance().getRune().value());

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	public Location getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(Location location) {
		this.checkpoint = location;
	}

	@Override
	public void reset(GameMap map) {
		if (!(map.locationOf(this) == this.getCheckpoint())) {
			map.moveActor(this, this.getCheckpoint());

		}
		this.heal(10000);
	}

	/**
	 * This method returns the name of the starting class
	 */
	public abstract String getClassName();

	/**
	 * This method calls the getMaxHp() method of the Actor class.
	 * @return Maximum hit points of this Starting Class
	 */
	public int getHp() {
		return getMaxHp();
	}
}