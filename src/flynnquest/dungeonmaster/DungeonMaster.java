package flynnquest.dungeonmaster;

import java.util.Random;
import java.util.Scanner;

import flynnquest.characters.Player;
import flynnquest.characters.monsters.Monster;
import flynnquest.main.Main;
import flynnquest.scenes.BlueRoom;
import flynnquest.scenes.GameEnd;
import flynnquest.scenes.GreenRoom;
import flynnquest.scenes.JailScene;
import flynnquest.scenes.RedRoom;
import flynnquest.scenes.RoundRoom;
import flynnquest.scenes.WardrobeRoom;
import flynnquest.scenes.WitchLair;

public final class DungeonMaster {
	
	/*
	 * This class houses the major game logic for Flynn Quest.
	 * I named it Dungeon Master to reflect how, in pen and paper role playing 
	 * games, the dungeon master has full control of the game's flow.
	 * 
	 * If I had time, I would implement a GUI and add music.
	 * I would also add ASCII art to each scene to make them a little more visually appealing.
	 * 
	 * I would also further refine the skill check system in this class.
	 * I might make character creation into a scene too.
	 */
	
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();
	public static Player player;
	public static boolean isRunning;
	
	// Story elements---scene is used in continueAdventure() to determine the
	// next scene and modified at the end of each scene
	public static int scene = 0;
	public static String[] scenes = { "Jail", "Round Room", "Wardrobe Room",
									"Witch's Lair", "Blue Room", "Green Room",
									"Red Room", "Game End" };

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
			try {
				System.out.print(prompt);
				input = Integer.parseInt(scanner.next());
			} catch (Exception e) {
				System.out.println("Please enter one of the available numbers!");
				input = -1;
			}
		} while (input < 1 || input > userChoices);
		clearConsole();
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
	 * Prints a heading from parameter title with separators above and below.
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
		DungeonMaster.clearConsole();
	}

	/**
	 * Shows a splash introduction screen and then prompts the player to create their
	 * character
	 */
	public static void startGame() {
		boolean isNameSet = false;
		boolean isVocationSet = false;
		String name;
		String vocation = null;
		isRunning = true;
//		Main.isRunning = true;
		// print title screen
		clearConsole();
		printSeparator(120);
		printSeparator(100);
		System.out.println("  _______  ___       ___  ___  _____  ___   _____  ___          ______    ____  ____   _______   ________  ___________  \r\n"
				+ " /\"     \"||\"  |     |\"  \\/\"  |(\\\"   \\|\"  \\ (\\\"   \\|\"  \\        /    \" \\  (\"  _||_ \" | /\"     \"| /\"       )(\"     _   \") \r\n"
				+ "(: ______)||  |      \\   \\  / |.\\\\   \\    ||.\\\\   \\    |      // ____  \\ |   (  ) : |(: ______)(:   \\___/  )__/  \\\\__/  \r\n"
				+ " \\/    |  |:  |       \\\\  \\/  |: \\.   \\\\  ||: \\.   \\\\  |     /  /    )  )(:  |  | . ) \\/    |   \\___  \\       \\\\_ /     \r\n"
				+ " // ___)   \\  |___    /   /   |.  \\    \\. ||.  \\    \\. |    (: (____/ //  \\\\ \\__/ //  // ___)_   __/  \\\\      |.  |     \r\n"
				+ "(:  (     ( \\_|:  \\  /   /    |    \\    \\ ||    \\    \\ |     \\         \\  /\\\\ __ //\\ (:      \"| /\" \\   :)     \\:  |     \r\n"
				+ " \\__/      \\_______)|___/      \\___|\\____\\) \\___|\\____\\)      \\\"____/\\__\\(__________) \\_______)(_______/       \\__|     \r\n"
				+ "                                                                                                                        ");
		System.out.println("BY JOSH AND FLYNN HOLLAND");
		printSeparator(100);
		printSeparator(120);
		pressAnyKey();
		
		// get the player's name
		do {
			clearConsole();
			printHeading("What is your hero's name?");
			name = scanner.next();
			// ask if player is sure about the name
			printHeading("Your hero's name is " + name + ". Is that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, I've changed my mind.");
			int input = readInt("-->", 2);
			if(input == 1)
				isNameSet = true;
		}while(!isNameSet);
		
		// get the player's vocation
		do {
			clearConsole();
			printHeading("What is your hero's vocation?");
			System.out.println("(1) Warrior");
			System.out.println("(2) Thief");
			System.out.println("(3) Mage");
			int input = readInt("-->", 3);
			if(input == 1)
				vocation = "Warrior";
			if(input == 2)
				vocation = "Thief";
			if(input == 3)
				vocation = "Mage";
			// ask if player is sure about their vocation
			printHeading("Your hero's vocation is " + vocation + ". Is that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, I've changed my mind.");
			input = readInt("-->", 2);
			if(input == 1) {
				isVocationSet = true;
			}
		}while(!isVocationSet);
		
		// create the player object with the name
		player = new Player(name, vocation);
		checkHeroStats();
		
		// show first story scene
//		JailScene.run();
		DungeonMaster.scene = 0;
		
//		isRunning = true;
	}
	
	/**
	 * Proceeds to next scene/room based on the place variable which was set
	 * by the previous room's outcome
	 */
	public static void continueAdventure() {
		clearConsole();
		switch(scene) {
		case 0:
			JailScene.run();
			break;
		case 1:
			RoundRoom.run();
			break;
		case 2:
			WardrobeRoom.run();
			break;
		case 3:
			WitchLair.run();
			break;
		case 4:
			BlueRoom.run();
			break;
		case 5:
			GreenRoom.run();
			break;
		case 6:
			RedRoom.run();
			break;
		case 7:
			GameEnd.run();
			if (DungeonMaster.scene == 0) {
				startGame();
			}
			break;
		}
	}
	
	/**
	 * check the hero's attributes and gold
	 */
	public static void checkHeroStats() {
		System.out.println(player);
		pressAnyKey();
	}
	
	/**
	 * main menu shown between scenes
	 */
	public static void printMenu() {
		clearConsole();
		printHeading("INTERMISSION...Approaching " + scenes[scene]);
		System.out.println("Choose an action:");
		printSeparator(20);
		if(player.getHpPotCount() < 0) {
			System.out.println("(1) Continue");
			System.out.println("(2) Check your hero's status");
			System.out.printf("(3) Drink an Hp Potion (you have %d)", player.getHpPotCount());
			System.out.println("(4) Exit the game");
		}else {
			System.out.println("(1) Continue");
			System.out.println("(2) Check your hero's status");
			System.out.println("(3) Exit the game");
			
		}
	}
	
	/**
	 * main game loop with menu to continue, check hero stats or exit the game
	 */
	public static void gameLoop(){
		while(isRunning) {
			printMenu();
			
			if(player.getHpPotCount() < 0) {
				int input = readInt("-->", 3);
				if(input == 1)
					continueAdventure();
				else if(input == 2)
					checkHeroStats();
				else if(input == 3)
					player.drinkHpPot();
				else
					System.out.println("Enjoy the real world!");
					isRunning = false;
					Main.isRunning = false;
			}else {
				int input = readInt("-->", 3);
				if(input == 1)
					continueAdventure();
				else if(input == 2)
					checkHeroStats();
				else
					isRunning = false;
					Main.isRunning = false;
					System.out.println("Enjoy the real world!");
			}
			
		}
	}
	
	public static int rollDice(int howManySides) {
		return  random.nextInt(howManySides)+1;
	}
	
	/**
	 * dice roll added to specified stat. howManySides refers to how many sides
	 *  on a die to "roll".
	 *  
	 * @param howManySides
	 * @param statName
	 * @param statValue
	 * @return
	 */
	public static int skillCheck(int howManySides, String statName,
									int statValue) {
		System.out.printf("Time to make a %s check!%n", statName);
		pressAnyKey();
		int result =  player.rollDice();
		int total = result + statValue;
		System.out.printf("Combined with your %d %s you got a"
				+ " %d!%n%n", statValue, statName, total);
		return total;
	}
	
	/**
	 * Opposing "dice rolls* determine damage to player and monster until only
	 * one remains
	 * @param player
	 * @param monster
	 */
	public static void combat(Player player, Monster monster) {
		printHeading(monster.getName() + " BATTLE!");
		while(player.isAlive() && monster.isAlive()) {
			pressAnyKey();
			// player attacks, monster defends then check isAlive for both
			System.out.printf("%n%s attacks the %s!%n", player.getName(),
								monster.getName());
			int pAtk = player.attack();
			System.out.printf("The %s braces against the attack!%n",
								monster.getName());
			int mDef = monster.defend();
			// if player's attack meets or exceeds monster defense,
			// reduce monster's health
			if(pAtk > mDef) {
				printHeading(String.format("%s's attack strikes the %s, dealing"
						+ " %d damage!", player.getName(), monster.getName(),
							pAtk-mDef));
				monster.damage(pAtk - mDef);
				pressAnyKey();
			}else if(!(pAtk > mDef)) {
				printHeading("Swing and a miss!");
				pressAnyKey();
			}
			if(!monster.isAlive()) {
				System.out.printf("The %s has been defeated!%n",
									monster.getName());
				System.out.printf("You recieve %d gold! Way to go!%n",
									monster.getGoldReward());
				player.lootGold(monster.getGoldReward());
				pressAnyKey();
				return;
			}
			
			// monster attacks, player defends then check isAlive for both
			System.out.printf("%nThe %s attacks %s!%n", monster.getName(),
								player.getName());
			int mAtk = monster.attack();
			int pDef = player.defend();
			// if monster's attack meets or exceeds player's defense,
			// reduce player's health
			if(mAtk > pDef) {
				printHeading(String.format("The %s's attack is successful and"
						+ " deals %d damage!", monster.getName(), mAtk-pDef,
							player.getName()));
				player.damage(mAtk - pDef);
			}else if(!(mAtk > pDef)) {
				printHeading("Swing and a miss!");
			}
			if(!player.isAlive()) {
				System.out.printf("Oh no! %s has been defeated in combat with"
						+ " the %s!%n", player.getName(), monster.getName());
				pressAnyKey();
				return;
			}
		}
		
	}


}
