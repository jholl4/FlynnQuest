package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;

public class RoundRoom extends Scene{
	
	public RoundRoom() {
		
	}

	public static void run() {
		System.out.println("Testing round room");
		DungeonMaster.pressAnyKey();
		DungeonMaster.place = 4;
	}

}
