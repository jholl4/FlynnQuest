package flynnquest.main;

import java.util.Random;

import flynnquest.characters.*;
import flynnquest.dungeonmaster.DungeonMaster;
import flynnquest.scenes.Scene;

public class Main {

	public static void main(String[] args) {
		
		
		// TODO see about adding music
		
		DungeonMaster.startGame();
		DungeonMaster.gameLoop();
		
		System.out.println("Thank you for playing!");
		
		
		
		DungeonMaster.scanner.close();
		
		

	}

}
