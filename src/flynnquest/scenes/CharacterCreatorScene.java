//package flynnquest.scenes;
//
//import flynnquest.characters.Player;
//import flynnquest.dungeonmaster.DungeonMaster;
//
//public class CharacterCreatorScene extends Scene{
//	
//	public CharacterCreatorScene() {
//		super();
//	}
//	
//	@Override
//	public static void run() {
//		boolean nameSet = false;
//		boolean vocationSet = false;
//		String name;
//		String vocation = null;
//		// print title screen
//		DungeonMaster.clearConsole();
//		DungeonMaster.printSeparator(40);
//		DungeonMaster.printSeparator(30);
//		System.out.println("FLYNN QUEST");
//		System.out.println("BY JOSH AND FLYNN HOLLAND");
//		DungeonMaster.printSeparator(30);
//		DungeonMaster.printSeparator(40);
//		DungeonMaster.pressAnyKey();
//		
//		// get the player's name
//		do {
//			DungeonMaster.clearConsole();
//			DungeonMaster.printHeading("What is your heroe's name?");
//			name = DungeonMaster.scanner.next();
//			// ask if player is sure about the name
//			DungeonMaster.printHeading("Your name is " + name + ". Is that correct?");
//			System.out.println("(1) Yes!");
//			System.out.println("(2) No, I've changed my mind.");
//			int input = DungeonMaster.readInt("-->", 2);
//			if(input == 1)
//				nameSet = true;
//		}while(!nameSet);
//		
//		// get the player's vocation
//		do {
//			DungeonMaster.clearConsole();
//			DungeonMaster.printHeading("What is your heroe's vocation?");
//			System.out.println("(1) Warrior");
//			System.out.println("(2) Thief");
//			System.out.println("(3) Mage");
//			int input = DungeonMaster.readInt("-->", 3);
//			if(input == 1)
//				vocation = "Warrior";
//			if(input == 2)
//				vocation = "Thief";
//			if(input == 3)
//				vocation = "Wizard";
//			// ask if player is sure about their vocation
//			DungeonMaster.printHeading("Your vocation is " + vocation + ". Is that correct?");
//			System.out.println("(1) Yes!");
//			System.out.println("(2) No, I've changed my mind.");
//			input = DungeonMaster.readInt("-->", 2);
//			if(input == 1)
//				vocationSet = true;
//		}while(!nameSet);
//		
//		// create the player object with the name
//		DungeonMaster.player = new Player(name, vocation);
//		System.out.println(DungeonMaster.player);
//	}
//
//	@Override
//	public int pickNextScene(int userInput) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void resolve() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
