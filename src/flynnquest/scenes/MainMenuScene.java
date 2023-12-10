//package flynnquest.scenes;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import flynnquest.characters.Monster;
//import flynnquest.dungeonmaster.DungeonMaster;
//
//public class MainMenuScene extends Scene{
//	
//	private int sceneId = 0; // used by scene pointers
//	private String name = "Main Menu"; // name of scene
//	private String description = "Welcome to Flynn Quest!"; // description of scene, usually about a paragraph
//	private Monster monster = null; // monster object
//	private int scenePointer = 1; // ArrayList of Integers that will indicate what scene to load next
//	private int gold = 0; // amount of gold that may be used as a reward
//	private String menu = "Enter 1 to play or 2 to exit>>>"; // TODO figure out what to do with this
//	private int userChoices = 2; // TODO maybe use an array of ints to allow user input here
//	private int userInput = 0;
//	
//	
////	public MainMenuScene(int sceneId, String name, String description, Monster monster, int gold, String menu, int userChoices) {
////		super(sceneId, name, description, monster, gold, menu, userChoices);
////	}
//	
//	@Override
//	public int  pickNextScene(int userInput) {
//		int result = 0;
//		return result;
//	}
//
//
//	@Override
//	public void run() {
//		setUserInput(DungeonMaster.readInt(description + " \n" + menu, 2));
//		
//	}
//
//
//	@Override
//	public void resolve() {
//		// switch to affect the player
//		
//	}
//	
//
//
//}
