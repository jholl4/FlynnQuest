package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;

public class WardrobeRoom extends Scene {
	
	// TODO fix wardrobe loop...if you try again after already picking the lock it says you dont have the skill

	private static int gold = DungeonMaster.rollDice(20);
	private static String description = String.format(
			"There is an old dusty wardrobe in the corner of the room, and a trapdoor in the floor to the right.%n");
	private static boolean hasLockBeenTried = false;
	private static boolean hasLockBeenPicked = false;
	private static boolean isTrapDoorOpen = false;
	
	
	public static void run() {
		System.out.println("You manage to squeeze your way to the other side of the crevice without getting stuck...");
		System.out.printf("You find yourself in a sort of dressing room, with a%n"
				+ "large, elegant carpet covering almost the entire stone floor.%n"
				+ "Numerous other carpets are scattered across the room, some rolled%n"
				+ "neatly while others were carelessly thrown into the room.%n");
		
		do {
			System.out.println(description);
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("(1) Attempt to open the wardrobe");
			System.out.println("(2) Check out the trap door");
			int input = DungeonMaster.readInt("-->", 2);
			
			switch (input) {
			case 1:
				if (!DungeonMaster.player.hasLockPick()) {
					System.out.println(
							"Blast! The wardrobe is locked shut and it seems that you don't have a lock pick.");
					hasLockBeenTried = true;
					DungeonMaster.pressAnyKey();
				}else {
					if (!hasLockBeenTried) {
						int dexCheck = DungeonMaster.skillCheck(20, "dexterity", DungeonMaster.player.getDex());
						if(dexCheck >= 15){
							System.out.println(
									"Eureka! You pick the lock and find a small pile of gold and a healing potion!");
							DungeonMaster.player.lootGold(gold);
							DungeonMaster.player.lootHpPot();
							hasLockBeenTried = true;
							hasLockBeenPicked = true;
							DungeonMaster.pressAnyKey();
						}else {
							System.out.println("Gadzooks! This is a complex locking mechanism! Unfortunately you are unable to pick it.");
							hasLockBeenTried = true;
							DungeonMaster.pressAnyKey();
						}
					}else if (hasLockBeenPicked){
						System.out.println(
								"You open the wardrobe and remember that you already looted it. Silly adventurer!");
						DungeonMaster.pressAnyKey();
					}else {
						System.out.println("No matter how many times you try, this lock is beyond your level of skill.");
						DungeonMaster.pressAnyKey();
					}
				}
				break;
			case 2:
				System.out.printf("The trap door opens easily, and below stretches%n"
						+ "a ladder, extending down so far that you can't see the bottom.%n");
				System.out.printf("You are unsure if this is really a good idea,%n"
						+ "but your options are limited. You begin the long climb down...%n");
				DungeonMaster.pressAnyKey();
				isTrapDoorOpen = true;
				break;
			}
			DungeonMaster.clearConsole();
			
		}while(!isTrapDoorOpen);
		
		DungeonMaster.scene = 3;
	}

}
