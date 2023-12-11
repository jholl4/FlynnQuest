package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.dungeonmaster.DungeonMaster;

public class WardrobeRoom extends Scene {

	private static String name = "Blue Room";
	private static int sceneId = 6;
	private static  Monster monster = null;
	private static int gold = DungeonMaster.rollDice(30);
	private static boolean haveBarrelsBeenLooted = false;
	private static boolean hasPlayerCrossedWater = false;
	private static String description = String.format("Directly in front of you is a fast-moving river, and across the river you see a cave opening. Could this be a way out??%n"
			+ "To your left, there is a pile of old barrels and crates.%n"
			+ "To your right, there is an old decrepit-looking rowboat. It's hard to tell if it is seaworthy or not...%n");
	
	public static void run() {
		
	}

}
