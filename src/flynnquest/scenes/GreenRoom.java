package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;
import flynnquest.dungeonmaster.DungeonMaster;

public class GreenRoom extends Scene {
	
	private static String name = "Green Room";
	private static int sceneId = 5;
	private static  Monster monster = null;
	private static int gold = DungeonMaster.rollDice(50);
	private static String description = String.format(
			"The shambling mound looks weak and withered, as if it has not had%n"
			+ "sustenance for a long time. You notice a small pool of water in%n"
			+ "the corner of the room, but the creature is unable to reach it.%n"
			+ "You wonder why it is trapped here, and who it crossed to earn%n"
			+ "this punishment.%n");
	private static boolean isRoomResolved = false;

	public static void run() {
		System.out.printf("You enter a dark and damp room, illuminated by only a%n"
				+ "few flickering torches and the door slams shut behind you with%n"
				+ "a loud *thud*. The air is heavy with the smell of rot and decay.%n"
				+ "You see a huge mass of vegetation in the center of the room,%n"
				+ "twitching and making a low groaning noise. It is a shambling mound,%n"
				+ "a living mass of vines, leaves, and fungi. You have heard stories of%n"
				+ "these creatures, and how they can engulf and suffocate their prey with%n"
				+ "their tendrils. The creature has been securely chained to the ground.%n");
		DungeonMaster.pressAnyKey();
		DungeonMaster.clearConsole();
		
		do {
			System.out.println(description);
			System.out.println("You seem to have a choice. Do you help the shambling mound, or put it out of its misery?");
			System.out.println("(1) Give the shambling mound some water");
			System.out.println("(2) Kill the dreadful creature");
			int input = DungeonMaster.readInt("-->", 2);
			if (input == 1) {
				System.out.printf("You feel a pang of pity for the shambling mound, and decide to%n"
						+ "water it. You take a bucket that was hanging from the wall,%n"
						+ "fill it with water from the pool, and pour it over the creature.%n"
						+ "The shambling mound shudders and moans, as if in gratitude.%n"
						+ "You see its color and vitality return, as it becomes more green%n"
						+ "and lush.%n");
				System.out.printf(
						"The shambling mound reaches a vine, inserts it into the opening that you%n"
						+ "assume must be its own mouth, pulls out a bag of gold and drops it at%n"
						+ "your feet. It seems to be rewarding you for your kindness.%n");
				DungeonMaster.player.lootGold(gold);
				DungeonMaster.pressAnyKey();
				System.out.printf(
						"You smile and thank the creature. Suddenly, you hear a%n"
						+ "rumbling sound, and the ground begins to shake. You%n"
						+ "look around and see vines sprouting from the floor and%n"
						+ "walls, forming a network of ropes and ladders. The%n"
						+ "shambling mound gestures with a tendril, indicating%n"
						+ "that you should climb. You realize that it is showing%n"
						+ "you a way out of the dungeon. You grab a torch and climb%n"
						+ "the vines, finding your way out of the dungeon and to freedom!%n");
				DungeonMaster.pressAnyKey();
				isRoomResolved = true;
				DungeonMaster.player.setHasEscaped(true);
				break;
			}
			
			if (input == 2) {
				System.out.printf(
						"You feel a surge of anger and hatred for the shambling%n"
						+ "mound, and decide to kill it. You charge the creature%n"
						+ "to attack, but suddenly it springs to life and entwines%n"
						+ "its vines around your body! Apparently the stories you had%n"
						+ "heard never mentioned the creature's ability to feign death!%n"
						+ "Try as you might, you are unable to wriggle free of the mound's%n"
						+ "grip, and the creature slowly starts to force your body into its gaping maw.%n"
						+ "This will not be a quick death...%n");
				DungeonMaster.pressAnyKey();
				DungeonMaster.player.setAlive(false);
				isRoomResolved = true;
				break;
			}
			
		}while(!isRoomResolved);
		
		DungeonMaster.scene = 7;
	}

}
