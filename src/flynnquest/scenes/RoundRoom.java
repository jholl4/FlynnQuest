package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.dungeonmaster.DungeonMaster;

public class RoundRoom extends Scene{
	
	private static String name = "Round Room";
	private static int sceneId = 0;
	private static  Monster monster = null;
	private static int scenePointer = -1;
	private static int gold = 0;
	
	public RoundRoom() {
		
	}

	public static void run() {
		
		DungeonMaster.place = 4;
	}

}
