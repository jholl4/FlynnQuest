package flynnquest.main;

import flynnquest.dungeonmaster.DungeonMaster;

public class Main {
	
	public static boolean isRunning = true;

	public static void main(String[] args) {
		
		
		// TODO see about adding music
		do {
			DungeonMaster.startGame();
			DungeonMaster.gameLoop();
		}while(isRunning);
		
		DungeonMaster.scanner.close();
		
	}

}
