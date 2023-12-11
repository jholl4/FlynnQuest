package flynnquest.characters.monsters;

import flynnquest.dungeonmaster.DungeonMaster;

public class ShieldGuardian extends Monster{

	public ShieldGuardian() {
		super("Shield Guardian", 20, 7, 3, 4, 7, DungeonMaster.rollDice(100)+50);
	}

}
