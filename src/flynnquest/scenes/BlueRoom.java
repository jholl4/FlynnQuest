package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;

public class BlueRoom extends Scene {
	
	private static int gold = DungeonMaster.rollDice(30);
	private static boolean haveBarrelsBeenLooted = false;
	private static boolean hasPlayerCrossedWater = false;
	private static String description = String.format(
			"Directly in front of you is a fast-moving river, and across the%n"
			+ "river you see a cave opening. Could this be a way out??%n"
			+ "To your left, there is a pile of old barrels and crates.%n"
			+ "To your right, there is an old decrepit-looking rowboat.%n"
			+ "It's hard to tell if it is seaworthy or not...%n");
	
	public static void run() {
		System.out.printf(
				"Thankful for clearing the previous room, you push through a narrow cave.%n"
				+ "Eventually you hear the sound of rushing water.%n"
				+ "Its volume increases until the cave finally widens and you see your next obstacle...%n");
		
		do {
			System.out.println(description);
			DungeonMaster.pressAnyKey();
			
			System.out.println("What will you do?");
			System.out.println("(1) Try to swim across the river");
			System.out.println("(2) Try your luck with the boat");
			System.out.println("(3) Use magic to float across the river");
			System.out.println("(4) See if you can find something useful in the pile of barrels");
			int input = DungeonMaster.readInt("-->", 4);
			
			switch(input) {
			case 1:
				System.out.println("You plunge into the water to find that it is ice cold...");
				int strCheck1 = DungeonMaster.skillCheck(20, "strength", DungeonMaster.player.getStr());
				int strCheck2 = DungeonMaster.skillCheck(20, "strength", DungeonMaster.player.getStr());
				if(strCheck1 >= 12) {
					System.out.println("As you reach the middle of the river, you realize you can't feel your fingers and your strength is waning.");
					System.out.println("You're not sure if you can make it to the other side. What do you do?");
					System.out.println("(1) Turn around");
					System.out.println("(2) Push through the pain");
					int swimInput = DungeonMaster.readInt("-->", 2);
					if(swimInput == 1) {
						if(strCheck2 >= 15) {
							System.out.printf("You fight the icy current and win. you find yourself%n"
									+ " gasping for air on the other side of the river.%n");
							System.out.printf(
									"Once you have had some time to catch your breath, you make your%n"
									+ "way out through the cave mouth and head back to town.%n");
							DungeonMaster.pressAnyKey();
							hasPlayerCrossedWater = true;
							DungeonMaster.player.setHasEscaped(true);
							break;
						}else {
							System.out.println("You give it your best, but unfortunately your best is not enough.");
							System.out.println("Choking on the dark water, you drift further underground, never to be seen again.");
							DungeonMaster.pressAnyKey();
							DungeonMaster.player.setAlive(false);
							hasPlayerCrossedWater = true;
						}
						
					}else if(swimInput == 2) {
						System.out.println("You decide to play it safe and turn back the way you came.");
						break;
					}
				}
			case 2:
				System.out.println("You push the boat into the water and hop in, frantically paddling to the other side.");
				int boatCheck = DungeonMaster.rollDice(20);
				if(boatCheck >= 15) {
					System.out.printf(
							"Luckily, the boat hangs on just long enough for you to cross the river.%n"
							+ "It sinks into the water just as you jump out.%n");
					System.out.printf(
							"You've made it to the other side, and freedom!%n"
							+ "Grateful for a successful escape, you make your way back to town.%n");
					DungeonMaster.pressAnyKey();
					hasPlayerCrossedWater = true;
					DungeonMaster.player.setHasEscaped(true);
					break;
				}
				System.out.println("The boat rapidly takes on water as you paddle. Maybe this wasn't a good idea...");
				System.out.printf(
						"You try to jump the rest of the way but it's too far. The dark waters of the%n"
						+ "river carry you away, deeper underground. You don't make it.%n");
				DungeonMaster.pressAnyKey();
				hasPlayerCrossedWater = true;
				DungeonMaster.player.setAlive(false);
			case 3:
				System.out.printf(
						"You muster all of the magical potency that you can, and take a leap of faith%n"
						+ "out over the river as you concentrate on being light as a feather.%n");
				int magCheck = DungeonMaster.skillCheck(20, "magic", DungeonMaster.player.getMag());
				if(magCheck >= 18) {
					System.out.println("You can hardly believe it, but your body gracefully glides across the water!");
					System.out.printf("You've made it to the other side, to freedom!%n"
							+ "Just to prove that it wasn't a fluke, you float your way back to town.%n");
					DungeonMaster.pressAnyKey();
					hasPlayerCrossedWater = true;
					DungeonMaster.player.setHasEscaped(true);
					break;
				}
				System.out.printf(
						"As you fly out over the water, you realize you aren't floating,%n"
						+ "as your trajectory rapidly declines toward the water below.%n");
				System.out.println(
						"You plunge deep into the water, and lose your sense of up and down.%n"
						+ "You try to gasp for air, but there is only water. Goodbye, cruel world...%n");
				DungeonMaster.pressAnyKey();
				DungeonMaster.player.setAlive(false);
				hasPlayerCrossedWater = true;
				break;
			case 4:
				if(!haveBarrelsBeenLooted) {
					System.out.println("You rummage through the pile of barrels.");
					int lootCheck = DungeonMaster.skillCheck(20, "dexterity", DungeonMaster.player.getDex());
					if(lootCheck >= 15) {
						System.out.printf("You manage to find %d gold scattered through the pile!%n", gold);
						DungeonMaster.player.lootGold(gold);
						DungeonMaster.pressAnyKey();
						haveBarrelsBeenLooted = true;
						break;
					}
					System.out.println("It's all worthless junk!");
					haveBarrelsBeenLooted = true;
				}else {
					System.out.println(
							"You've already checked the barrels...it doesn't look like you'll find anything else.");
				}
				break;
			}
			
		}while(!hasPlayerCrossedWater);
		
		DungeonMaster.scene = 7;
	}

}
