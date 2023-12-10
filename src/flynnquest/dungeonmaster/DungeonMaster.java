package flynnquest.dungeonmaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import flynnquest.characters.Player;
import flynnquest.characters.monsters.Monster;
import flynnquest.scenes.BlueRoom;
import flynnquest.scenes.JailScene;
import flynnquest.scenes.RoundRoom;
import flynnquest.scenes.Scene;
import flynnquest.scenes.WitchLair;

public final class DungeonMaster {
	
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();
	
	public static Player player;
	
	public static boolean isRunning;
	
	// Story elements---place is used in continueAdventure() to determine the next scene
	public static int place = 0;
	public static String[] places = { "Jail", "Round Room", "Wardrobe Room", "Witch's Lair", "Blue Room", "Green Room", "Red Room" };

	/**
	 * Method to get user input
	 * 
	 * @param prompt
	 * @param userChoices
	 * @return USER INPUT
	 */
	public static int readInt(String prompt, int userChoices) {
		int input;

		do {
			System.out.print(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			} catch (Exception e) {
				System.out.println("Please enter one of the available numbers!");
				input = -1;
			}
		} while (input < 1 || input > userChoices);
		return input;
	}

	/**
	 * Method to clear the console. Prints several empty lines.
	 */
	public static void clearConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	/**
	 * Prints a separator line. Used for the printHeading method.
	 */
	public static void printSeparator(int size) {
		for (int i = 0; i < size; i++)
			System.out.print("-");
		System.out.println();
	}

	/**
	 * Prints a heading(param title) with separators above and below.
	 * 
	 * @param title
	 */
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}

	/**
	 * Waits for the user to input any value and press enter. Gives them a chance to
	 * read what is on the screen if needed.
	 */
	public static void pressAnyKey() {
		System.out.print("\nEnter anything to continue>>>");
		scanner.next();
	}

	public static void pickNextScene(int scenePointer) {

		switch (scenePointer) {
		case 0:
			
			break;

		default:
			break;
		}

	}

//	public static void runScene(Scene scene) {
//
//		// read scene description
//		if(scene.getDescription() != null) {
//			printHeading(scene.getDescription());
//			pressAnyKey();
//		}
//		
//		// Display scene menu and ask user for input
//		printHeading(scene.getMenu());
//		scene.setUserInput(readInt(scene.getMenu(), scene.getUserChoices()));
//
//		// action happens from input. put a switch method in the scene to determine
//		// this?
//		scene.run();
//		
//		// param of user input here goes into switch method, then
//		// is passed to switch and returns result for action?
//	}
	
	public static void startGame() {
		boolean isNameSet = false;
		boolean isVocationSet = false;
		String name;
		String vocation = null;
		// print title screen
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("FLYNN QUEST");
		System.out.println("BY JOSH AND FLYNN HOLLAND");
		printSeparator(30);
		printSeparator(40);
		pressAnyKey();
		
		// get the player's name
		do {
			clearConsole();
			printHeading("What is your heroe's name?");
			name = scanner.next();
			// ask if player is sure about the name
			printHeading("Your name is " + name + ". Is that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, I've changed my mind.");
			int input = readInt("-->", 2);
			if(input == 1)
				isNameSet = true;
		}while(!isNameSet);
		
		// get the player's vocation
		do {
			clearConsole();
			printHeading("What is your heroe's vocation?");
			System.out.println("(1) Warrior");
			System.out.println("(2) Thief");
			System.out.println("(3) Mage");
			int input = readInt("-->", 3);
			if(input == 1)
				vocation = "Warrior";
			if(input == 2)
				vocation = "Thief";
			if(input == 3)
				vocation = "Wizard";
			// ask if player is sure about their vocation
			printHeading("Your vocation is " + vocation + ". Is that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, I've changed my mind.");
			input = readInt("-->", 2);
			if(input == 1)
				isVocationSet = true;
		}while(!isNameSet);
		
		// create the player object with the name
		player = new Player(name, vocation);
		checkHeroStats();
		
		// show first story scene
		JailScene.run();
		
		isRunning = true;
	}
	
	// method to continue the adventure
	public static void continueAdventure() {
		switch(place) {
		case 0:
			JailScene.run();
			break;
		case 1:
			RoundRoom.run();
			break;
//		case 2:
//			WardrobeRoom.run();
//			break;
		case 3:
			WitchLair.run();
			break;
		case 4:
			BlueRoom.run();
			break;
//		case 5:
//			GreenRoom.run();
//			break;
//		case 6:
//			RedRoom.run();
//			break;
		}
	}
	
	// check the hero's attributes and gold
	public static void checkHeroStats() {
		System.out.println(player);
		pressAnyKey();
		clearConsole();
	}
	
	// main menu
	public static void printMenu() {
		clearConsole();
		printHeading("Approaching " + places[place]);
		System.out.println("Choose an action:");
		printSeparator(20);
		System.out.println("(1) Continue your adventure");
		System.out.println("(2) Check your hero's status");
		System.out.println("(3) Exit the game");
	}
	
	// main game loop with menu to continue, check hero stats or exit the game
	public static void gameLoop(){
		while(isRunning) {
			printMenu();
			int input = readInt("-->", 3);
			if(input == 1)
				continueAdventure();
			else if(input == 2)
				checkHeroStats();
			else
				isRunning = false;
		}
	}
	
	// dice roll added to specified stat
	public static int rollDice(int howManySides, String statName, int statValue) {
		int result =  random.nextInt(howManySides);
		int total = result + statValue;
		System.out.printf("Rolling d%d for %s...%n", howManySides, statName);
		System.out.printf("You rolled %d; combined with your %d %s you got a %d!%n", result, statValue, statName, total);
		return total;
	}
	
	public static void combat(Player player, Monster monster) {
		
	}


}
