package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;
import flynnquest.main.Main;

public class GameEnd extends Scene{
	
	private static int playerScore;
	
	public static void run() {
		playerScore = DungeonMaster.player.getGold() + DungeonMaster.player.getHp() + (DungeonMaster.player.getHpPotCount() * 10);
		
		if(!DungeonMaster.player.isAlive()) {
			DungeonMaster.printHeading("                                                                                                                                    \r\n"
					+ "      _____          _____        ______  _______        ______                 _____     ____      ____      ______        _____   \r\n"
					+ "  ___|\\    \\     ___|\\    \\      |      \\/       \\   ___|\\     \\           ____|\\    \\   |    |    |    | ___|\\     \\   ___|\\    \\  \r\n"
					+ " /    /\\    \\   /    /\\    \\    /          /\\     \\ |     \\     \\         /     /\\    \\  |    |    |    ||     \\     \\ |    |\\    \\ \r\n"
					+ "|    |  |____| |    |  |    |  /     /\\   / /\\     ||     ,_____/|       /     /  \\    \\ |    |    |    ||     ,_____/||    | |    |\r\n"
					+ "|    |    ____ |    |__|    | /     /\\ \\_/ / /    /||     \\--'\\_|/      |     |    |    ||    |    |    ||     \\--'\\_|/|    |/____/ \r\n"
					+ "|    |   |    ||    .--.    ||     |  \\|_|/ /    / ||     /___/|        |     |    |    ||    |    |    ||     /___/|  |    |\\    \\ \r\n"
					+ "|    |   |_,  ||    |  |    ||     |       |    |  ||     \\____|\\       |\\     \\  /    /||\\    \\  /    /||     \\____|\\ |    | |    |\r\n"
					+ "|\\ ___\\___/  /||____|  |____||\\____\\       |____|  /|____ '     /|      | \\_____\\/____/ || \\ ___\\/___ / ||____ '     /||____| |____|\r\n"
					+ "| |   /____ / ||    |  |    || |    |      |    | / |    /_____/ |       \\ |    ||    | / \\ |   ||   | / |    /_____/ ||    | |    |\r\n"
					+ " \\|___|    | / |____|  |____| \\|____|      |____|/  |____|     | /        \\|____||____|/   \\|___||___|/  |____|     | /|____| |____|\r\n"
					+ "   \\( |____|/    \\(      )/      \\(          )/       \\( |_____|/            \\(    )/        \\(    )/      \\( |_____|/   \\(     )/  \r\n"
					+ "    '   )/        '      '        '          '         '    )/                '    '          '    '        '    )/       '     '   \r\n"
					+ "        '                                                   '                                                    '                  ");
			System.out.println("Alas, you were not able to make it out of the dungeon...");
			System.out.printf("Before you were obliterated by the dungeon, you were able to score %d gold.%n", DungeonMaster.player.getGold());
		}else {
			DungeonMaster.printHeading(":'######:::'#######::'##::: ##::'######:::'########:::::'###::::'########:'##::::'##:'##::::::::::'###::::'########:'####::'#######::'##::: ##::'######::'####:\r\n"
					+ "'##... ##:'##.... ##: ###:: ##:'##... ##:: ##.... ##:::'## ##:::... ##..:: ##:::: ##: ##:::::::::'## ##:::... ##..::. ##::'##.... ##: ###:: ##:'##... ##: ####:\r\n"
					+ " ##:::..:: ##:::: ##: ####: ##: ##:::..::: ##:::: ##::'##:. ##::::: ##:::: ##:::: ##: ##::::::::'##:. ##::::: ##::::: ##:: ##:::: ##: ####: ##: ##:::..:: ####:\r\n"
					+ " ##::::::: ##:::: ##: ## ## ##: ##::'####: ########::'##:::. ##:::: ##:::: ##:::: ##: ##:::::::'##:::. ##:::: ##::::: ##:: ##:::: ##: ## ## ##:. ######::: ##::\r\n"
					+ " ##::::::: ##:::: ##: ##. ####: ##::: ##:: ##.. ##::: #########:::: ##:::: ##:::: ##: ##::::::: #########:::: ##::::: ##:: ##:::: ##: ##. ####::..... ##::..:::\r\n"
					+ " ##::: ##: ##:::: ##: ##:. ###: ##::: ##:: ##::. ##:: ##.... ##:::: ##:::: ##:::: ##: ##::::::: ##.... ##:::: ##::::: ##:: ##:::: ##: ##:. ###:'##::: ##:'####:\r\n"
					+ ". ######::. #######:: ##::. ##:. ######::: ##:::. ##: ##:::: ##:::: ##::::. #######:: ########: ##:::: ##:::: ##::::'####:. #######:: ##::. ##:. ######:: ####:\r\n"
					+ ":......::::.......:::..::::..:::......::::..:::::..::..:::::..:::::..::::::.......:::........::..:::::..:::::..:::::....:::.......:::..::::..:::......:::....::");
			System.out.printf("You did it! You were able to escape from the dungeon! You have %d Hp left, and you were able to amass a fortune of %d gold along the way!%n", DungeonMaster.player.getHp(), DungeonMaster.player.getGold());
			}
		System.out.println();
		System.out.printf("Your total score based on your health and everything you earned is %d%n", playerScore);
		System.out.println();
		System.out.println("Thank you very much for playing!");
		System.out.println("Special thanks to my awesome son Flynn for his major contributions to the dungeon layout and story!");
		DungeonMaster.printHeading("Do you wish to play again?");
		System.out.println("(1) Yes");
		System.out.println("(2) No");
		int input = DungeonMaster.readInt("-->", 2);
		
		switch(input) {
		case 1:
			DungeonMaster.isRunning = false;
			break;
		case 2:
			DungeonMaster.isRunning = false;
			Main.isRunning = false;
			System.out.println("Enjoy the real world!");
			}
		
	}

}
