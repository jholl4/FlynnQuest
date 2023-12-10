package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.dungeonmaster.DungeonMaster;

public class JailScene extends Scene {
	
	private static String name = "Jail";
	private static int sceneId = 0;
	private static  Monster monster = null;
	private static int scenePointer = -1;
	private static int gold = 0;

	private static boolean isDoorOpen = false;
	private static String description = "It's difficult to tell in the dimly lit dungeon that you"
			+ " seem to have found yourself in, but it seems that there is nothing "
			+ "but a dirty pile of straw to sleep on, and the cell is padlocked shut.";

	public static void run() {

		System.out.println("You awaken to discover yourself in a jail cell.");
		System.out.println("You survey the cell to get an idea of your situation.");
		
		do {
			System.out.println(description);
			System.out.println("What do you do?");
			System.out.println("(1) search the pile of straw for something useful");
			System.out.println("(2) Attempt to force the door open");
			System.out.println("(3) Cast a spell on the padlock");
			int input = DungeonMaster.readInt("-->", 3);
			switch (input) {
			case 1:
				System.out.println("You find a lockpick!");
				if (DungeonMaster.rollDice(20, "dexterity", DungeonMaster.player.getDex()) >= 15) {
					System.out.println("You manage to pick the lock and make your way out of the jail area.");
					isDoorOpen = true;
					break;
				} else {
					System.out.println("Too bad you don't know how to use it...");
					break;
				}
			case 2:
				System.out.println("You throw all of your strength at the door!");
				if(DungeonMaster.rollDice(20, "strength", DungeonMaster.player.getStr()) >= 15) {
					System.out.println("After a few bashes to the cell's door, it gives way and you exit the cell.");
					isDoorOpen = true;
					break;
				}else {
					System.out.println("Your frail body makes a strange cracking sound as it impacts the door...lose 10 hp.");
					DungeonMaster.player.damage(10);
					break;
				}
			case 3:
				System.out.println("You sense a power deep inside you and call to it.");
				if(DungeonMaster.rollDice(20, "magic", DungeonMaster.player.getMag()) >= 15) {
					System.out.println("Intense cold air suddenly flows from your fingertips into the lock. You tap on the lock and it shatters!");
					isDoorOpen = true;
					break;
				}else {
					System.out.println("You let out a weird-sounding moan, and nothing happens. Not sure what that was...");
					break;
				}
			}
			DungeonMaster.pressAnyKey();
			DungeonMaster.clearConsole();
		}while(!isDoorOpen);
		System.out.println("As you leave the jail cells behind you, there are two hallways ahead. Which way do you go?");
		System.out.println("(1) Left");
		System.out.println("(2) Right");
		int input = DungeonMaster.readInt("-->", 2);
		if(input == 1) {
			DungeonMaster.scene = 1;
		}else {
			DungeonMaster.scene = 2;
		}
		

	}

}
