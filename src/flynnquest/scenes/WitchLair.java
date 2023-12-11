package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.dungeonmaster.DungeonMaster;

public class WitchLair extends Scene {

	private static String name = "Witch's Lair";
	private static int sceneId = 3;
	private static  Monster monster = null;
	private static int gold = DungeonMaster.rollDice(75);
	private static String description = String.format("The mysterious witch%n");
	private static boolean isRoomResolved = false;
	private static int riddlesGuessed;
	
	private static String[] riddleList = { 
			"You have heard me but not seen me. I never speak back unless you speak to me. Who am I?",
			"If you feed me, I will live, but if you make me drink, I will die. What am I?",
			"What can you keep when not needed and throw when it is needed?",
			"I am wasted by the foolish, spent by the average, and invested by the wise. Everyone succumbs to me. Who am I?",
			"Towns without any houses, mountains without rocks, forests without trees, and seas without water. What am I?",
			"It can pierce armor and destroy swords with just a rub. But it is harmless. What is it?",
			"",
			"",
			"",
			"",
	};
	
	private static String[] answerList = { 
			"An echo.",
			"Fire.",
			"An anchor",
			"Time.",
			"A map.",
			"Rust.",
			"",
			"",
			"",
			"",
	};
	
	private static String[] fakeAnswerList = {
			"The wind.",
			"A cactus.",
			"A hammer.",
			"Gold.",
			"Nothing.",
			"A dragon.",
			"",
			"",
			"",
			"",
	};
	
	public static void run() {
		System.out.println("Testing witch lair");
		
			System.out.println(description);
			System.out.println("What do ");
			
		switch (riddlesGuessed) {
		case 0:
			DungeonMaster.scene = 1;
		case 1:
			DungeonMaster.scene = 7;
			break;
		case 2:
			DungeonMaster.scene = 6;
			break;
		case 3:
			DungeonMaster.scene = 1;
			break;
		}
	}

}
