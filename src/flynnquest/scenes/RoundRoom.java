package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.characters.monsters.Ogre;
import flynnquest.dungeonmaster.DungeonMaster;

public class RoundRoom extends Scene{
	
	/*
	 * If I had the time, I would re-factor this to make the code blocks for each stone re-usable
	 */
	
	private static  Monster monster = new Ogre();
	private static int gold = DungeonMaster.rollDice(15);
	private static boolean isBlueChosen = false;
	private static boolean isGreenChosen = false;
	private static boolean isRedChosen = false;
	private static boolean isDoorOpen = false;
	private static String description = String.format(
			"In the center of the large round room, there is a small white altar adorned with many candles.%n"
			+ "Upon the altar there are three stones, each a different color: red, green, and blue.%n"
			+ "Behind the altar, on the edge of the room, there are three doors with large crystals%n"
			+ "matching the stones on the altar.");
	
	public static void run() {
		isBlueChosen = false;
		isGreenChosen = false;
		isRedChosen = false;
		isDoorOpen = false;
		System.out.println("A large, round room opens up before you.");
		
		if(!isBlueChosen && !isGreenChosen && !isRedChosen) {
			int stonePicker = DungeonMaster.rollDice(3);
			switch(stonePicker) {
			case 1:
				isBlueChosen = true;
				break;
			case 2:
				isGreenChosen = true;
				break;
			case 3:
				isRedChosen = true;
				break;
			}
			
		}
		
		do {								
			System.out.println(description);
			
			if(isBlueChosen)
				System.out.println("The blue stone has a faint glow to it...");
			if(isGreenChosen)
				System.out.println("The green stone has a faint glow to it...");
			if(isRedChosen)
				System.out.println("The red stone has a faint glow to it...");
				
			DungeonMaster.pressAnyKey();
			System.out.println("What would you like to do?");
			System.out.println("(1) Touch the blue stone");
			System.out.println("(2) Touch the green stone");
			System.out.println("(3) Touch the red stone");
			int input = DungeonMaster.readInt("-->", 3);
			switch(input) {
			case 1:
				System.out.println("You reach out and lightly touch the blue stone...");
				if(isBlueChosen) {
					System.out.printf(
							"The stone's radiance violently increases until you can see nothing else but blue!%n"
							+ "After a few moments, your vision returns and you realize that the door with the blue crystal%n"
							+ "has opened. The stones are gone from the altar, and in their place, a small pile of gold. You%n"
							+ "take the %d gold and safely exit the room.%n", RoundRoom.gold);
					DungeonMaster.player.lootGold(RoundRoom.gold);
					DungeonMaster.pressAnyKey();
					isDoorOpen = true;
					break;
				}
				System.out.printf(
						"An ear-shattering crash resounds behind you. As you turn around, you see that an ogre%n"
						+ "has descended from somewhere above.\n"
						+ "YOU HAVE NO RESPECT FOR THE HOLY STOOOOOOONES!!!!! it screams. Prepare for battle!");
				DungeonMaster.pressAnyKey();
				DungeonMaster.combat(DungeonMaster.player, monster);
				isDoorOpen = true;
				break;
			case 2:
				System.out.println("You reach out and lightly touch the green stone...");
				if(isGreenChosen) {
					System.out.printf(
							"The stone's radiance violently increases until you can see nothing else but green!%f"
							+ "After a few moments, your vision returns and you realize that the door with the green crystal%n"
							+ "has opened. The stones are gone from the altar, and in their place, a small pile of gold. You%n"
							+ "take the %d gold and safely exit the room.\n", RoundRoom.gold);
					DungeonMaster.pressAnyKey();
					DungeonMaster.player.lootGold(RoundRoom.gold);
					isDoorOpen = true;
					break;
				}
				System.out.printf(
						"An ear-shattering crash resounds behind you. As you turn around, you see that an ogre%n"
						+ "has descended from somewhere above.\n"
						+ "YOU HAVE NO RESPECT FOR THE HOLY STOOOOOOONES!!!!! it screams. Prepare for battle!");
				DungeonMaster.pressAnyKey();
				DungeonMaster.combat(DungeonMaster.player, monster);
				isDoorOpen = true;
				break;
			case 3:
				System.out.println("You reach out and lightly touch the red stone...");
				if(isRedChosen) {
					System.out.printf(
							"The stone's radiance violently increases until you can see nothing else but red!%n"
							+ "After a few moments, your vision returns and you realize that the door with the%n"
							+ "red crystal has opened. The stones are gone from the altar, and in their place,%n"
							+ "a small pile of gold. You take the %d gold and safely exit the room.\n", RoundRoom.gold);
					DungeonMaster.player.lootGold(RoundRoom.gold);
					DungeonMaster.pressAnyKey();
					isDoorOpen = true;
					break;
				}
				System.out.printf(
						"An earth-shattering crash resounds behind you. As you turn around, you see that an ogre%n"
						+ "has descended from somewhere above.%n"
						+ "YOU HAVE NO RESPECT FOR THE HOLY STOOOOOOONES!!!!! it screams. Prepare for battle!");
				DungeonMaster.pressAnyKey();
				DungeonMaster.combat(DungeonMaster.player, monster);
				isDoorOpen = true;
				break;
			}
		}while(!isDoorOpen);
		
		if(!DungeonMaster.player.isAlive()) {
			DungeonMaster.scene = 7;
			return;
		}
		
		if(isBlueChosen) {
			DungeonMaster.scene = 4;
		}else if(isGreenChosen){
			DungeonMaster.scene = 5;
		}else if(isRedChosen) {
			DungeonMaster.scene = 6;
		}
		
	}

}
