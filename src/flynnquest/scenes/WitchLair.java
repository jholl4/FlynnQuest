package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.characters.monsters.ShieldGuardian;
import flynnquest.dungeonmaster.DungeonMaster;

public class WitchLair extends Scene {

	private static  Monster monster = new ShieldGuardian();
	private static int gold = DungeonMaster.rollDice(75);
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
		//These ints used as indexes to randomize what riddles are pulled from the arrays
		int riddle1 = DungeonMaster.rollDice(riddleList.length)-1;
		int riddle2 = DungeonMaster.rollDice(riddleList.length)-1;
		while(riddle2==riddle1) {
			riddle2 = DungeonMaster.rollDice(riddleList.length)-1;
		}
		int riddle3 = DungeonMaster.rollDice(riddleList.length-1);
		while (riddle3 == riddle1 || riddle3 == riddle2) {
			riddle3 = DungeonMaster.rollDice(riddleList.length-1);
		}
		
		System.out.printf(
				"You finally reach the bottom of the ladder and enter%n"
				+ "a medium-sized, square room. In the middle of the room, a huge%n"
				+ "cauldron is bubbling and boiling with a strange liquid.%n"
				+ "A sulfurous smell fills the air. A witch is standing next to%n"
				+ "the cauldron, stirring it with a long wooden spoon. She has a%n"
				+ "pointy hat, a crooked nose, and a wicked grin. She looks at you and cackles.%n");
		DungeonMaster.pressAnyKey();
		DungeonMaster.clearConsole();
		
		System.out.printf("'Welcome, welcome, my dear guest!', she says.%n"
				+ "'I've been expecting you. I have prepared a little game for%n"
				+ "your entertainment! I will ask you three riddles, and you%n"
				+ "must answer them correctly. If you do, you will be rewarded.%n"
				+ "If you don't you will be punished. Do you accept the challenge?'%n");
		
		System.out.println("You look around the room and see no other way out. You have no choice but to agree.");
		DungeonMaster.pressAnyKey();
		DungeonMaster.clearConsole();
		
		System.out.println("'Very well then. Let us begin! Here is the first riddle:");
		
		riddleAsk(riddle1);
		riddleAsk(riddle2);
		riddleAsk(riddle3);
			
		switch (riddlesGuessed) {
		case 0:
			System.out.printf(
					"The witch cackles, 'It seems that games of the mind are not your thing!%n"
					+ "Perhaps you would rather play with my friend, the shield guardian!'%n");
			DungeonMaster.combat(DungeonMaster.player, monster);
			if (DungeonMaster.player.isAlive()) {
				System.out.printf(
						"As the shield guardian clatters to the floor, the witch says 'Very well!%n"
						+ "You have earned another chance to live. But your journey is not over!'%n"
						+ "The witch tosses you a healing potion and starts waving her arms wildly and%n"
						+ "chanting, and your vision flashes all colors of the spectrum as you are whisked%n"
						+ "away to another part of the dungeon.%n");
				DungeonMaster.player.lootHpPot();
				DungeonMaster.pressAnyKey();
				DungeonMaster.scene = 1;
			}else {
				DungeonMaster.scene = 7;
			}
			break;
		case 1:
			System.out.printf(
					"The witch laughs, 'Well, at least you tried!' She waves a%n"
					+ "hand and you suddenly find yourself standing on the side%b"
					+ "of a mountain overlooking your home town. You weren't%n"
					+ "able to loot much, but at least you made it out of the dungeon!%n");
			DungeonMaster.pressAnyKey();
			DungeonMaster.player.setHasEscaped(true);
			DungeonMaster.scene = 7;
			break;
		case 2:
			System.out.printf(
					"The witch hums, 'So close, but not quite close enough! You%n"
					+ "will live, but your journey is not quite complete!' She%n"
					+ "waves her hand and the rooms disappears before you. All%n"
					+ "goes black before suddenly you are somewhere else.%n");
			DungeonMaster.pressAnyKey();
			DungeonMaster.clearConsole();
			DungeonMaster.scene = 6;
			break;
		case 3:
			System.out.printf(
					"'You are brilliant, indeed. You have answered all of my%n"
					+ "riddles correctly. Your reward is well-earned. Here,%n"
					+ "take this pouch of gold.%n");
			DungeonMaster.player.lootGold(gold);
			System.out.printf("'And here is the other part of your reward!' She%n"
					+ "waves a hand and a portal opens up on the wall. You see%n"
					+ "your home town on the other side. You grab the gold,%n"
					+ "thank the witch for her kindness, and step through the portal.%n");
			DungeonMaster.pressAnyKey();
			DungeonMaster.clearConsole();
			DungeonMaster.scene = 7;
			break;
		}
	}
	/**
	 * Logic for asking each riddle question. answerFlipper is used to ensure that the correct
	 * answer will not always be in the same position.
	 * @param riddle
	 */
	public static void riddleAsk(int riddle) {
		int answerFlipper = DungeonMaster.rollDice(2);

		System.out.println(riddleList[riddle]);
		System.out.println("What is your answer?");
		if (answerFlipper==1) {
			System.out.printf("(1) %s%n", answerList[riddle]);
			System.out.printf("(2) %s%n", fakeAnswerList[riddle]);
			int input = DungeonMaster.readInt("-->", 2);
			// Check if correct answer was picked
			if (input==1) {
				riddlesGuessed++;
				DungeonMaster.printHeading("The witch gasps and frowns. 'Well done, traveler.'");
			}else {
				DungeonMaster.printHeading("The witch claps and laughs 'Nice try!'");
			}
		}else {
			System.out.printf("(1) %s%n", fakeAnswerList[riddle]);
			System.out.printf("(2) %s%n", answerList[riddle]);
			int input = DungeonMaster.readInt("-->", 2);
			// Check is correct answer was picked
			if (input==2) {
				riddlesGuessed++;
				DungeonMaster.printHeading("The witch nods and smiles.");
			}else {
				DungeonMaster.printHeading("Incorrect!");
			}
		}
		
	}

}
