package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actions.ConsumeAction;
import game.actions.RestAction;
import game.enums.GroundType;
import game.items.FlaskOfCrimsonTears;
import game.items.Rune;
import game.Resettable;
import game.enums.Status;
import game.items.RuneManager;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Aflah Hanif Amarlyadi, Josh Hernett Tan
 */
public abstract class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	private FlaskOfCrimsonTears flaskOfCrimsonTears;

	private Location checkpoint;

	/**
	 * Constructor.
	 *
	 * @param hitPoints   Player's starting number of hit points
	 */
	public Player(int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.FOLLOWABLE);
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

		Location playerLocation = map.locationOf(this);
		if (playerLocation.getGround().hasCapability(GroundType.SLG)){
			this.setCheckpoint(playerLocation);
		}

		display.println(this.name + " (" + this.hitPoints + "/" + this.maxHitPoints + "), Runes: " + RuneManager.getInstance().getRune().getValue());

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	public Location getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(Location checkpoint) {
		this.checkpoint = checkpoint;
	}



	@Override
	public void reset(GameMap map) {
		this.heal(250);
	}
}
