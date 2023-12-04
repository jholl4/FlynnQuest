package flynnquest.dungeonmaster;

import java.util.Scanner;

import flynnquest.scenes.Scene;

public class DungeonMaster {
	
	static Scanner scanner = new Scanner(System.in);
	
	/*
	 * while loop to check player.isAlive
	 * 	if escaped
	 * 		add to high score list
	 * 		run victory scene
	 * 		reset player values
	 * 		return to main menu
	 * 	if alive
	 * 		use a switch to call next scene's run method based on previous scene's pointer
	 * 		1: Scene1_1
	 * 		2: Scene1_2
	 * 		3: Scene2_1
	 * 		4: Scene2_2
	 * 		5: Scene2_3
	 * 		6: Scene2_4
	 * 		7: Scene2_5
	 * 		8: Victory
	 * 		9: Failure
	 * 		10: MainMenu
	 * 		11: CharacterCreator
	 * 		
	 * 	if dead
	 * 		add to high score list
	 * 		run failure scene
	 * 		reset player values
	 * 		return to main menu
	 * 
	 * 
	 * 
	 * scene should set next pointer at scene end
	 */
	
	/**
	 * Method to get user input
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
			}catch(Exception e) {
				System.out.println("Please enter one of the available numbers!");
				input = -1;
			}
		}while(input < 1 || input > userChoices);
		return input;
	}
	
	/**
	 * Method to clear the console.
	 * Prints several empty lines.
	 */
	public static void clearConsole() {
		for(int i=0; i<100;i++) {
			System.out.println();
		}
	}
	
	/**
	 * Prints a separator line.
	 * Used for the printHeading method.
	 */
	public static void printSeparator() {
		for(int i=0; i<30; i++)
			System.out.print("-");
		System.out.println();
	}
	
	/**
	 * Prints a heading(param title) with separators above and below.
	 * @param title
	 */
	public static void printHeading(String title) {
		printSeparator();
		System.out.println(title);
		printSeparator();
	}
	
	/**
	 * Waits for the user to input any value and press enter.
	 * Gives them a chance to read what is on the screen if needed.
	 */
	public static void pressAnyKey() {
		System.out.print("\nEnter anything to continue>>>");
		scanner.next();
	}
	
	public static void runScene(Scene scene) {
		
		// read scene description
		if(scene.getDescription() != null) {
			System.out.println(scene.getDescription());
			pressAnyKey();
		}
		// Display scene menu and ask user for input
		System.out.println(scene.getMenu());
		int input = readInt(scene.getMenu(), scene.getUserChoices());
		
		// action happens from input. put a switch method in the scene to determine this?
		// param of user input here goes into switch method, then
		// is passed to switch and returns result for action?
	}

}
