package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;

public class JailScene extends Scene {
	
	private static boolean isDoorOpen = false;
	private static boolean hasStrawBeenChecked;
	private static String description = String.format(
			"It's difficult to tell in the dimly lit dungeon that you%n"
			+ "seem to have found yourself in, but it seems that there is nothing%n"
			+ "but a dirty pile of straw to sleep on, and the cell is padlocked shut.%n");

	public static void run() {

		System.out.println("You awaken to discover yourself in a jail cell.");
		System.out.println("You survey the cell to get an idea of your situation.");
		
		do {
			System.out.println(description);
			System.out.println("What do you do?");
			System.out.println("(1) Search the pile of straw for something useful");
			System.out.println("(2) Attempt to force the door open");
			System.out.println("(3) Cast a spell on the padlock");
			int input = DungeonMaster.readInt("-->", 3);
			switch (input) {
			case 1:
				if (!hasStrawBeenChecked) {
					hasStrawBeenChecked = true;
					System.out.println("You find a lockpick!");
					DungeonMaster.player.setHasLockPick(true);
					System.out.println("Hopefully you know how to use one of these things...");
					DungeonMaster.pressAnyKey();
					if (DungeonMaster.skillCheck(20, "dexterity", DungeonMaster.player.getDex()) >= 15) {
						System.out.println("You manage to pick the lock and make your way out of the jail.");
						isDoorOpen = true;
						break;
					} else {
						System.out.println("You aren't too good with a lock pick are you...");
					}
				}else {
					System.out.printf(
							"You've already checked the straw pile. You found%n"
							+ "that lock pick, but this lock is too complex for%n"
							+ "your skill level. Sorry!%n");
				}
				break;
			case 2:
				System.out.println("You throw all of your strength at the door!");
				if(DungeonMaster.skillCheck(20, "strength", DungeonMaster.player.getStr()) >= 15) {
					System.out.println("After a few bashes to the cell's door, it gives way and you exit the cell.");
					isDoorOpen = true;
					break;
				}else {
					System.out.println("Your frail body makes a strange cracking sound as it impacts the door...lose 10 hp.");
					DungeonMaster.player.damage(5);
					break;
				}
			case 3:
				System.out.println("You sense a power deep inside you and call to it.");
				if(DungeonMaster.skillCheck(20, "magic", DungeonMaster.player.getMag()) >= 15) {
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
		System.out.printf(
				"As you leave the jail cells behind you, there is a hallway out, but out of the corner of you eye,%n"
				+ "you spot a gap in the corner of the wall to your right. Which way do you go?%n");
		System.out.println("(1) Take the hallway to the left");
		System.out.println("(2) Attempt to squeeze through the crevice to the right");
		int input = DungeonMaster.readInt("-->", 2);
		if(!DungeonMaster.player.isAlive()) {
			DungeonMaster.scene = 7;
			return;
		}
		if(input == 1) {
			DungeonMaster.scene = 1;
		}else {
			DungeonMaster.scene = 2;
		}
		

	}

}
