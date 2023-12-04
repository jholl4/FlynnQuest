package flynnquest.dungeonmaster;

import java.util.Scanner;

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
	 * Method to clear the console
	 */
	public static void clearConsole() {
		for(int i=0; i<100;i++) {
			System.out.println();
		}
	}
	
	/**
	 * Prints a separator line
	 */
	public static void printSeparator() {
		for(int i=0; i<30; i++)
			System.out.print("-");
		System.out.println();
	}
	
	public static void printHeading(String title) {
		printSeparator();
		System.out.println(title);
		printSeparator();
	}
	
	public static void pressAnyKey() {
		System.out.print("\nEnter anything to continue>>>");
		scanner.next();
	}

}
