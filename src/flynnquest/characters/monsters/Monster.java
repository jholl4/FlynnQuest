package flynnquest.characters.monsters;

import flynnquest.characters.Character;

public abstract class Monster extends Character{
	
//	private int str;
//	private int dex;
//	private int mag;
	private int armor;
	
	public Monster(String name, int maxHp) {
		super(name, maxHp);
	}
	
	@Override
	public int attack() {
		if(dex > str && dex > mag) {
			return rollDice() + dex;
		}else if(mag > str && mag > dex) {
			return rollDice() + mag;
		}
		return rollDice() + str;
	}

	@Override
	public int defend() {
		return rollDice() + armor;
	}



}
