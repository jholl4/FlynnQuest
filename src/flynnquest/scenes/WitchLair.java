package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.characters.monsters.ShieldGuardian;
import flynnquest.dungeonmaster.DungeonMaster;

public class WitchLair extends Scene {

	private static String name = "Witch's Lair";
	private static int sceneId = 3;
	private static  Monster monster = new ShieldGuardian();
	private static int gold = DungeonMaster.rollDice(75);
	private static String description = String.format("In the middle of the room, a huge cauldron is bubbling and boiling with a strange liquid. A sulfurous smell fills the air. A witch is standing next to the cauldron, stirring it with a long wooden spoon. She has a pointy hat, a crooked nose, and a wicked grin.%n");
	private static int riddlesGuessed;
	
	private static String[] riddleList = { 
			"You have heard me but not seen me. I never speak back unless you speak to me. Who am I?",
			"If you feed me, I will live, but if you make me drink, I will die. What am I?",
			"What can you keep when not needed and throw when it is needed?",
			"I am wasted by the foolish, spent by the average, and invested by the wise. Everyone succumbs to me. Who am I?",
			"Towns without any houses, mountains without rocks, forests without trees, and seas without water. What am I?",
			"It can pierce armor and destroy swords with just a rub. But it is harmless. What is it?",
			"You cannot enter this room. What room is it?",
			"Unlike ice that melts when it is heated, I solidify when I am heated. What am I?",
			"I can cross a river, but I cannot move? What am I?",
			"What falls but never breaks, and what breaks but never falls?",
	};
	
	private static String[] answerList = { 
			"An echo.",
			"Fire.",
			"An anchor",
			"Time.",
			"A map.",
			"Rust.",
			"A mushroom.",
			"An egg.",
			"A bridge.",
			"Night and day.",
	};
	
	private static String[] fakeAnswerList = {
			"The wind.",
			"A cactus.",
			"A hammer.",
			"Gold.",
			"Nothing.",
			"A dragon.",
			"A Jail cell.",
			"Wood.",
			"A fish.",
			"An egg.",
	};
	
	public static void run() {
		//These ints used to randomize what riddles are pulled from the arrays
		int riddle1 = DungeonMaster.rollDice(riddleList.length);
		int riddle2 = DungeonMaster.rollDice(riddleList.length);
		while(riddle2==riddle1) {
			riddle2 = DungeonMaster.rollDice(riddleList.length);
		}
		int riddle3 = DungeonMaster.rollDice(riddleList.length);
		while (riddle3 == riddle1 || riddle3 == riddle2) {
			riddle3 = DungeonMaster.rollDice(riddleList.length);
		}
		// answerFlipper will be used to determine which of the two answers (correct or incorrect) are first
//		int answerFlipper = DungeonMaster.rollDice(2);
		
		System.out.println("You finally reach the bottom of the ladder and enter a medium-sized, square room. In the middle of the room, a huge cauldron is bubbling and boiling with a strange liquid. A sulfurous smell fills the air. A witch is standing next to the cauldron, stirring it with a long wooden spoon. She has a pointy hat, a crooked nose, and a wicked grin. She looks at you and cackles.");
		DungeonMaster.pressAnyKey();
		DungeonMaster.clearConsole();
		
		System.out.println("'Welcome, welcome, my dear guest!', she says. 'I've been expecting you. I have prepared a little game for your entertainment! I will ask you three riddles, and you must answer them correctly. If you do, you will be rewarded. If you don't you will be punished. Do you accept the challenge?'");
		
		System.out.println("You look around the room and see no other way out. You have no choice but to agree.");
		DungeonMaster.pressAnyKey();
		DungeonMaster.clearConsole();
		
		System.out.println("'Very well then. Let us begin! Here is the first riddle:");
		
//		System.out.println(riddleList[riddle1]);
//		System.out.println("What is your answer?");
//		if (answerFlipper==1) {
//			System.out.printf("(1) %s%n", answerList[riddle1]);
//			System.out.printf("(2) %s%n", fakeAnswerList[riddle1]);
//			int input = DungeonMaster.readInt("-->", 2);
//			// Check is correct answer was picked
//			if (input==1) {
//				riddlesGuessed++;
//				System.out.println("The witch nods and smiles.");
//			}else {
//				System.out.println("Incorrect!");
//			}
//		}else {
//			System.out.printf("(2) %s%n", fakeAnswerList[riddle1]);
//			System.out.printf("(1) %s%n", answerList[riddle1]);
//			int input = DungeonMaster.readInt("-->", 2);
//			// Check is correct answer was picked
//			if (input==2) {
//				riddlesGuessed++;
//				System.out.println("The witch nods and smiles.");
//			}else {
//				System.out.println("Incorrect!");
//			}
//		}
		
		riddleAsk(riddle1);
		riddleAsk(riddle2);
		riddleAsk(riddle3);
		
		
			
		switch (riddlesGuessed) {
		case 0:
			System.out.println("The witch cackles, 'It seems that games of the mind are not your thing! Perhaps you would rather play with my friend, the shield guardian!'");
			DungeonMaster.combat(DungeonMaster.player, monster);
			if (!DungeonMaster.player.isAlive()) {
				System.out.println("As the shield guardian clatters to the floor, the witch says 'Very well! You have earned another chance to live. But your journey is not over!' The witch tosses you a healing potion and starts waving her arms wildly and chanting, and your vision flashes all colors of the spectrum as you are whisked away to another part of the dungeon.");
				DungeonMaster.player.lootHpPot();
				DungeonMaster.pressAnyKey();
				DungeonMaster.scene = 1;
			}else {
				DungeonMaster.scene = 7;
			}
			break;
		case 1:
			System.out.println("The witch laughs, 'Well, at least you tried!' She waves a hand and you suddenly find yourself standing on the side of a mountain overlooking your home town. Well, at least you made it out of the dungeon!");
			DungeonMaster.pressAnyKey();
			DungeonMaster.player.setHasEscaped(true);
			DungeonMaster.scene = 7;
			break;
		case 2:
			System.out.println("The witch hums, 'So close, but not quite close enough! You will live, but your journey is not quite complete!' She waves her hand and the rooms disappears before you. All goes black before suddenly you are somewhere else.");
			DungeonMaster.pressAnyKey();
			DungeonMaster.clearConsole();
			DungeonMaster.scene = 6;
			break;
		case 3:
			System.out.println("'You are brilliant, indeed. You have answered all of my riddles correctly. Your reward is well-earned. Here, take this pouch of gold.");
			DungeonMaster.player.lootGold(50);
			System.out.println("'And here is the other part of your reward!' She waves a hand and a portal opens up on the wall. You see your home town on the other side. You grab the gold, thank the witch for her kindness, and step through the portal.");
			DungeonMaster.pressAnyKey();
			DungeonMaster.clearConsole();
			DungeonMaster.scene = 1;
			break;
		}
	}
	
	public static void riddleAsk(int riddle) {
		int answerFlipper = DungeonMaster.rollDice(2);

		System.out.println(riddleList[riddle]);
		System.out.println("What is your answer?");
		if (answerFlipper==1) {
			System.out.printf("(1) %s%n", answerList[riddle]);
			System.out.printf("(2) %s%n", fakeAnswerList[riddle]);
			int input = DungeonMaster.readInt("-->", 2);
			// Check is correct answer was picked
			if (input==1) {
				riddlesGuessed++;
				System.out.println("The witch gasps and frowns.");
			}else {
				System.out.println("The witch claps and laughs 'Nice try!'");
			}
		}else {
			System.out.printf("(2) %s%n", fakeAnswerList[riddle]);
			System.out.printf("(1) %s%n", answerList[riddle]);
			int input = DungeonMaster.readInt("-->", 2);
			// Check is correct answer was picked
			if (input==2) {
				riddlesGuessed++;
				System.out.println("The witch nods and smiles.");
			}else {
				System.out.println("Incorrect!");
			}
		}
		
	}

}
