package flynnquest.main;

import flynnquest.dungeonmaster.DungeonMaster;

public class Main {

	public static void main(String[] args) {
		
		
		// TODO see about adding music
		
		DungeonMaster.startGame();
		DungeonMaster.gameLoop();
		
		System.out.println("Thank you for playing Flynn Quest!");
		
		DungeonMaster.scanner.close();
		
		

	}

}
