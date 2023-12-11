package flynnquest.scenes;

import flynnquest.dungeonmaster.DungeonMaster;

public class GameOver extends Scene{
	
	public static void run() {
		
		if(!DungeonMaster.player.isAlive()) {
			System.out.println("                                                                                                                                    \r\n"
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
			DungeonMaster.isRunning = false;
			return;
		}
		System.out.printf("You did it! You were able to escape from the dungeon! And you were able to amass a fortune of %d gold along the way!%n", DungeonMaster.player.getGold());
		DungeonMaster.isRunning = false;
	}

}
