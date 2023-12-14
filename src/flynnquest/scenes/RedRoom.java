package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;

public class RedRoom extends Scene {

	private static int gold = DungeonMaster.rollDice(150);
	private static int fingerChopperDamage = 10;
	private static int loreChallenge = 16;
	private static String description = String.format(
			"You are in a dimly lit room with a small pedestal in the center.%n"
			+ "On top of the pedestal, there is a bowl covered in dark stains%n"
			+ "that you can only assume are dried blood. Above the bowl, there%n"
			+ "is a stone slab with a hole in it, large enough for a finger.%n"
			+ "You see an inscription on the slab, written in plain English:%n%n"
					+ "ONLY THOSE WHO PAY THE PRICE OF PASSAGE MAY PROCEED. INSERT YOUR FINGER TO PAY THE PRICE.%n%n"
					+ "You shudder at the thought of losing a finger, but you%n"
					+ "wonder if there is any other way out of this room. You%n"
					+ "look around and see a door on the opposite wall, but it%n"
					+ "is locked and has no handle.");
	private static boolean isRoomResolved = false;
	private static boolean hasTriedToDecipher = false;

	public static void run() {
		System.out.println("As you enter the room, the door slams behind you.");

		do {
			System.out.println(description);
			DungeonMaster.pressAnyKey();
			System.out.println("What will you do?");
			System.out.println("(1) Insert your finger into the hole");
			System.out.println("(2) Look for another option");
			int input = DungeonMaster.readInt("-->", 2);
			switch (input) {
			case 1:
				System.out.printf(
						"As much as you hate the idea of losing a finger, it's%n"
						+ "better than being trapped in this dungeon. You%n"
						+ "insert your least favorite finger into the hole,%n"
						+ "and a large CHOP removes your finger! You recoil in%n"
						+ "pain as your blood is added to the bowl, and the%n"
						+ "door on the opposite side of the room grinds open.%n");
				DungeonMaster.player.damage(fingerChopperDamage);
				DungeonMaster.pressAnyKey();
				isRoomResolved = true;
				DungeonMaster.player.setHasEscaped(true);
				break;
			case 2:
				if (!hasTriedToDecipher) {
					hasTriedToDecipher = true;
					System.out.printf(
							"You decide to look for another solution, hoping to%n"
									+ "avoid the gruesome fate of losing a finger. You%n"
									+ "examine the pedestal more closely, and notice a%n"
									+ "faint inscription at the base. It seems to be%n"
									+ "written in an ancient and forgotten language,%n"
									+ "that only a few scholars can decipher.%n");
					DungeonMaster.pressAnyKey();
					int loreCheck = DungeonMaster.skillCheck(20, "magic",
												DungeonMaster.player.getMag());

					if (loreCheck >= loreChallenge) {
						System.out.printf(
								"Luckily, you have done your fair share of lore%n"
								+ "studies through the years. You read the inscription, and it says:%n%n"
										+ "THOSE WHO SEEK THE HIDDEN TREASURE MUST FIND THE SECRET LEVER;%n"
										+ "BEHIND THE WALL OF STONE AND MORTAR LIES A CHEST OF GOLD AND SILVER.%n%n"
										+ "You realize that there is a hidden compartment in the wall of%n"
										+ "this room! You search for the wall that matches the description,%n"
										+ "and find a loose brick that you are able to push. You hear a click,%n"
										+ "and a section of the wall slides open, revealing a chest and a lever.%n"
										+ "You open the chest and see a pile of gold coins. You take as much as you%n"
										+ "can carry, and pull the lever. You rush out the door and into the open air.%n"
										+ "You have escaped the dungeon!%n");
						DungeonMaster.player.lootGold(gold);
						DungeonMaster.pressAnyKey();
						DungeonMaster.player.setHasEscaped(true);
						isRoomResolved = true;
						break;
					} else {
						System.out.println(
								"Unfortunately you are unable to read the text. Perhaps you should have paid more attention in ancient lore studies...");
						DungeonMaster.pressAnyKey();
						break;
					}
				} else {
					System.out.println("No matter how hard you squint at it, you still don't understand the text.");
					DungeonMaster.pressAnyKey();
					break;
				}
			}

		} while (!isRoomResolved);
		
		DungeonMaster.scene = 7;

	}

}
