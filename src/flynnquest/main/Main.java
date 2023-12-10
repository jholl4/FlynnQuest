package flynnquest.main;

import java.util.Random;

import flynnquest.characters.*;
import flynnquest.dungeonmaster.DungeonMaster;
import flynnquest.scenes.Scene;

public class Main {
	
	/*
	 * run scene (main menu first)
	 * scene runs and sets scenepointer in main
	 * loop continues, running current scenepointer each time
	 * until gameRunning it set to false
	 * 
	 * set gameRunning to false in win or loss scenes
	 * 
	 * after gameRunning loop exits, save score to leaderboard
	 * 
	 * then play exit message and close application
	 * 
	 */

	public static void main(String[] args) {
		
		
		// TODO see about adding music
		
		DungeonMaster.startGame();
		DungeonMaster.gameLoop();
		
		System.out.println("Thank you for playing!");
		
//		boolean gameRunning = true;
//		int mainScenePointer = 0;
//		Scene currentScene = DungeonMaster.sceneList.get(0);
//		Player player1 = new Player();
//		
//		// dm picks next scene based on current main pointer
//		// pointer is changed by dm scene picker
//		// dm runs new scene based on what pointer was changed to
//		// at end of each loop, player life status and escape status are checked
//		// if player has escaped or died, exit loop and run game over or victory scene
//		
//		while(gameRunning) {
//			DungeonMaster.runScene(DungeonMaster.sceneList.get(mainScenePointer));
//			if(!gameRunning || !player1.isAlive()) {
//				break;
//			}
//		}
		
		

	}

}
