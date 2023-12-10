package flynnquest.characters.monsters;

import flynnquest.characters.Character;

public abstract class Monster extends Character{
	

	// properties
//	private int dc; // difficulty class (player attacks will check against this)
	public Monster(String name, int maxHp) {
		super(name, maxHp);
	}



}
