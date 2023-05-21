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

	/**
	 * Menu of actions that the player can perform
	 */
	private final Menu menu = new Menu();

	/**
	 * The Flask of Crimson Tears the player has
	 */
	public static FlaskOfCrimsonTears flaskOfCrimsonTears;

	/**
	 * The Runes the player has
	 */
	private Rune runes;

	/**
	 * The spawn point of player if game resets
	 */
	private Location checkpoint;

	/**
	 * Last Location of the player
	 */
	private Location lastLocation;

	private int statusCount;


	public void setStatusCount(int statusCount) {
		this.statusCount = statusCount;
	}

	/**
	 * Constructor.
	 * @param hitPoints Starting Class's number of hit points
	 */
	public StartingClass(int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.FOLLOWABLE);

		this.runes = new Rune(0, this);
		this.addItemToInventory(this.runes);

		this.flaskOfCrimsonTears = new FlaskOfCrimsonTears(2);
		this.addItemToInventory(this.flaskOfCrimsonTears);
		ResetManager.getInstance().registerResettable(this.flaskOfCrimsonTears);
		statusCount = 0;
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		this.lastLocation = map.locationOf(this);
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		actions.add(new ConsumeAction(flaskOfCrimsonTears));

		if (this.hasCapability(Status.RUNE_BOOST)){
			statusCount++;
		} else if (this.statusCount >= 50 && this.hasCapability(Status.RUNE_BOOST)){
			this.removeCapability(Status.RUNE_BOOST);
			this.setStatusCount(0);
		}

		display.println(this + ": " + printHp() + ", Runes: " + RuneManager.getInstance().getRune().value());
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Getter for the checkpoint of the player
	 * @return checkpoint of the player
	 */
	public Location getCheckpoint() {
		return checkpoint;
	}

	/**
	 * Setter for the checkpoint of the player
	 * @param location Location to be set as the player's checkpoint
	 */
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
	 * This method calls the getMaxHp() method of the Actor class.
	 * @return Maximum hit points of this Starting Class
	 */
	public int getHp() {
		return getMaxHp();
	}

	/**
	 * Getter for last Location of the player
	 * @return Last Location of the player
	 */
	public Location getLastLocation() {
		return this.lastLocation;
	}

	/**
	 * This method registers the runes of the player to the Rune Manager
	 */
	public void registerRune() {
		RuneManager.getInstance().registerRune(runes);
	}
}
