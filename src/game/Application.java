package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Trader;
import game.actors.players.StartingClass;
import game.grounds.*;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
import game.grounds.environments.SiteOfLostGrace;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Aflah Hanif Amarlyadi, David Lee
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace(), new Barrack(), new Cage());

		List<String> map = Arrays.asList(
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
				"..................................__#....................~~~~~~~~~~~~~~~~~~",
				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
				"......................#............_#......................~~~~~~~~~~~~~~~~",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~~~......................________#....nnnn........................",
				"~~~~~~~~~~~~~.....................#___U____................................",
				"~~~~~~~~~~~~......................#_______#....nnnn........................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~..........................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##...........................................&&&......######..##...",
				"..#.....__...........................................&&&......#....____....",
				"..#___..............&&&..............................&&&........__.....#...",
				"..####__###.........&&&......................................._.....__.#...",
				"....................&&&.......................................###..__###...",
				"...........................................................................");

		List<String> testMap = Arrays.asList(
				"U.....................",
				"......................",
				"......................",
				"......................",
				"......................",
				"......................"
		);

		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

//		GameMap gameMap = new GameMap(groundFactory, testMap);
//		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		StartingClass player = StartingClassMenu.getInstance().chooseStartingClass();
		// adding First Step Grace as first checkpoint
		player.setCheckpoint(gameMap.at(38, 11));
		ResetManager.getInstance().registerResettable(player);
		world.addPlayer(player, gameMap.at(36, 10));
		Trader trader = new Trader("Merchant Kale", 'K');
		gameMap.at(40, 12).addActor(trader);

//		StartingClass player = StartingClassMenu.getInstance().chooseStartingClass();
//		// adding First Step Grace as first checkpoint
//		player.setCheckpoint(gameMap.at(0, 0));
//		ResetManager.getInstance().registerResettable(player);
//		world.addPlayer(player, gameMap.at(1, 1));

		world.run();
	}
}