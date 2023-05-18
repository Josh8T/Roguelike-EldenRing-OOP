package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Trader;
import game.actors.players.StartingClass;
import game.enums.Status;
import game.grounds.*;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
import game.grounds.environments.SiteOfLostGrace;
import game.items.RemembranceOfTheGrafted;

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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(),
				new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace(), new Barrack(), new Cage(),
				new SummonSign(), new Cliff());

		List<String> limgrave = Arrays.asList(
				"..nnnn................#.............#.................~~~~~....+++.........",
				"......................#.............#.................~~~~~.+++++..........",
				"..nnnn................#..___....____#.................~~~~~...+++++........",
				"......................#...........__#.................~~~~~......++........",
				"......................#_____........#.............................+++......",
				"......................#............_#..............................+++.....",
				"......................######...######......................................",
				"...........................................................................",
				"...........................=...............................................",
				"........++++......................###___###................................",
				"........+++++++...................________#....nnnn........................",
				"..........+++.....................#___U____................................",
				"~~~~........+++...................#_______#....nnnn........................",
				"~~~~.........+....................###___###................................",
				"~~~~........++......................#___#..................................",
				"..............+...................=........................................",
				"..............++.................................................=.........",
				"..............................................++...........................",
				"..................++++......................+++......&&.......######..##...",
				"#####___######....++...........................+++...&&.......#....____....",
				"_____________#.....+&&+..........................+..............__.....#...",
				"_____________#.....+&&..++........................++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++..............................................");

		List<String> stormveilCastle = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");

		List<String> roundtableHold = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######");

		List<String> bossRoom = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				"..=......................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++");

		List<String> testMap = Arrays.asList(
				"U.=...................",
				"......................",
				"......................",
				"......................",
				"......................",
				"......................"
		);

		GameMap limgraveMap = new GameMap(groundFactory, limgrave);
		world.addGameMap(limgraveMap);

		GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastle);
		world.addGameMap(stormveilCastleMap);

		GameMap roundtableHoldMap = new GameMap(groundFactory, roundtableHold);
		world.addGameMap(roundtableHoldMap);

		GameMap bossRoomMap = new GameMap(groundFactory, roundtableHold);
		world.addGameMap(bossRoomMap);

		limgraveMap.at(6, 23).setGround(new GoldenFogDoor("Roundtable Hold", roundtableHoldMap, roundtableHoldMap.at(9,10)));
		roundtableHoldMap.at(9, 10).setGround(new GoldenFogDoor("Limgrave", limgraveMap, limgraveMap.at(6,23)));

		limgraveMap.at(30, 0).setGround(new GoldenFogDoor("Stormveil Castle", stormveilCastleMap, stormveilCastleMap.at(38, 23)));
		stormveilCastleMap.at(38, 23).setGround(new GoldenFogDoor("Limgrave", limgraveMap, limgraveMap.at(30, 0)));

		stormveilCastleMap.at(5, 0).setGround(new GoldenFogDoor("Godrick the Grafted", bossRoomMap, bossRoomMap.at(0, 4)));

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
		player.setCheckpoint(limgraveMap.at(38, 11));
		ResetManager.getInstance().registerResettable(player);
//		world.addPlayer(player, limgraveMap.at(36, 10));
		world.addPlayer(player, limgraveMap.at(28, 0));

		Trader kale = new Trader("Merchant Kale", 'K');
		limgraveMap.at(40, 12).addActor(kale);

		Trader enia = new Trader("Finger Reader Enia", 'E');
		enia.removeCapability(Status.WILLING_TO_SELL);
		roundtableHoldMap.at(9, 1).addActor(enia);

//		StartingClass player = StartingClassMenu.getInstance().chooseStartingClass();
//		// adding First Step Grace as first checkpoint
//		player.setCheckpoint(limgraveMap.at(0, 0));
//		ResetManager.getInstance().registerResettable(player);
//		world.addPlayer(player, limgraveMap.at(1, 1));

		world.run();
	}
}