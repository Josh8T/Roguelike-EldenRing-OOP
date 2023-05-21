package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Trader;
import game.actors.enemies.GodrickTheGrafted;
import game.actors.players.StartingClass;
import game.enums.Status;
import game.grounds.*;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
import game.grounds.environments.SiteOfLostGrace;
import game.items.GoldPickledFowlFoot;
import game.items.GoldenRunes;
import game.items.GoldenSeed;

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
				new GustOfWind(), new PuddleOfWater(), new Barrack(), new Cage(),
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
				"..........+++.....................#________................................",
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

		GameMap limgraveMap = new GameMap(groundFactory, limgrave);
		world.addGameMap(limgraveMap);

		GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastle);
		world.addGameMap(stormveilCastleMap);

		GameMap roundtableHoldMap = new GameMap(groundFactory, roundtableHold);
		world.addGameMap(roundtableHoldMap);

		GameMap bossRoomMap = new GameMap(groundFactory, bossRoom);
		world.addGameMap(bossRoomMap);

		// Add Merchant Kale to the Limgrave map
		Trader kale = new Trader("Merchant Kale", 'K');
		limgraveMap.at(40, 12).addActor(kale);

		// Add Finger Reader Enia to the Roundtable Hold map
		Trader enia = new Trader("Finger Reader Enia", 'E');
		enia.removeCapability(Status.WILLING_TO_SELL);
		roundtableHoldMap.at(9, 1).addActor(enia);

		// Add Godrick The Grafted to the Boss Room map
		GodrickTheGrafted boss = new GodrickTheGrafted();
		bossRoomMap.at(12, 4).addActor(boss);
		boss.setSpawnLocation(new Location(bossRoomMap, 12, 4));

		// Create The First Step in Limgrave
		Location theFirstStepLocation = limgraveMap.at(38, 11);
		SiteOfLostGrace theFirstStep = new SiteOfLostGrace("The First Step", theFirstStepLocation);
		theFirstStepLocation.setGround(theFirstStep);

		// Create Stormveil Main Gate in Stormveil Castle
		Location stormveilMainGateLocation = stormveilCastleMap.at(38, 20);
		SiteOfLostGrace stormveilMainGate = new SiteOfLostGrace("Stormveil Main Gate", stormveilMainGateLocation);
		stormveilMainGateLocation.setGround(stormveilMainGate);

		// Create Table of Lost Grace in Roundtable Hold
		Location tableOfLostGraceLocation = roundtableHoldMap.at(9, 5);
		SiteOfLostGrace tableOfLostGrace = new SiteOfLostGrace("Table of Lost Grace", tableOfLostGraceLocation);
		tableOfLostGraceLocation.setGround(tableOfLostGrace);

		Destination fromLimgraveToRoundtableHold = new Destination("Roundtable Hold", roundtableHoldMap, roundtableHoldMap.at(9,10));
		Destination fromRoundtableHoldToLimgrave = new Destination("Limgrave", limgraveMap, limgraveMap.at(6,23));
		// Create Golden Fog Door in Limgrave to travel to Roundtable Hold
		limgraveMap.at(6, 23).setGround(new GoldenFogDoor(fromLimgraveToRoundtableHold));
		// Create Golden Fog Door in Roundtable Hold to travel to Limgrave
		roundtableHoldMap.at(9, 10).setGround(new GoldenFogDoor(fromRoundtableHoldToLimgrave));

		Destination fromLimgraveToStormveilCastle = new Destination("Stormveil Castle", stormveilCastleMap, stormveilCastleMap.at(38, 23));
		Destination fromStormveilCastleToLimgrave = new Destination("Limgrave", limgraveMap, limgraveMap.at(30, 0));
		// Create Golden Fog Door in Limgrave to travel to Stormveil Castle
		limgraveMap.at(30, 0).setGround(new GoldenFogDoor(fromLimgraveToStormveilCastle));
		// Create Golden Fog Door in Stormveil Castle to travel to Limgrave
		stormveilCastleMap.at(38, 23).setGround(new GoldenFogDoor(fromStormveilCastleToLimgrave));

		Destination fromStormveilCastleToGodrickTheGrafted = new Destination("Godrick the Grafted", bossRoomMap, bossRoomMap.at(0, 4));
		// Create Golden Fog Door in Stormveil Castle to travel to Godrick the Grafted
		stormveilCastleMap.at(5, 0).setGround(new GoldenFogDoor(fromStormveilCastleToGodrickTheGrafted));

		// Scatter Golden Runes in Limgrave
		limgraveMap.at(3, 21).addItem(new GoldenRunes());
		limgraveMap.at(26, 2).addItem(new GoldenRunes());
		limgraveMap.at(38, 10).addItem(new GoldenRunes());
		limgraveMap.at(69, 19).addItem(new GoldenRunes());
		limgraveMap.at(73, 11).addItem(new GoldenRunes());

		// Scatter Golden Runes in Stormveil Castle
		stormveilCastleMap.at(0, 4).addItem(new GoldenRunes());
		stormveilCastleMap.at(8, 10).addItem(new GoldenRunes());
		stormveilCastleMap.at(38, 21).addItem(new GoldenRunes());
		stormveilCastleMap.at(74, 1).addItem(new GoldenRunes());
		stormveilCastleMap.at(74, 10).addItem(new GoldenRunes());

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
		// Register the player's runes
		player.registerRune();
		// Set The First Step as the first Site of Lost Grace
		player.setCheckpoint(theFirstStep.getLocation());
		// Set The First Step to discovered as default
		theFirstStep.discover();
		// Register player as resettable
		ResetManager.getInstance().registerResettable(player);
		// Add player to Limgrave
		world.addPlayer(player, limgraveMap.at(36, 10));


		// testing pickled fowl consumable item is working
		// TODO: To be removed
		bossRoomMap.locationOf(player).setGround(new Cage());
		bossRoomMap.at(3,4).addItem(new GoldPickledFowlFoot());

//		StartingClass player = StartingClassMenu.getInstance().chooseStartingClass();
//		// adding First Step Grace as first checkpoint
//		player.setCheckpoint(bossRoomMap.at(1, 1));
//		ResetManager.getInstance().registerResettable(player);
//		world.addPlayer(player, bossRoomMap.at(1, 1));

		world.run();
	}
}