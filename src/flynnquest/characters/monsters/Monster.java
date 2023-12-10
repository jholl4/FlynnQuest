package flynnquest.characters.monsters;

import flynnquest.characters.Character;

public abstract class Monster extends Character{
	
	private int armor;
	private int goldReward;
	
	public Monster(String name, int maxHp) {
		super(name, maxHp);
	}
	
	public Monster(String name, int maxHp, int str, int dex, int mag, int armor) {
		super(name, maxHp, str, dex, mag);
		this.armor = armor;
	}
	
	@Override
	public int attack() {
		if(getDex() > getStr() && getDex() > getMag()) {
			return rollDice() + getDex();
		}else if(getMag() > getStr() && getMag() > getDex()) {
			return rollDice() + getMag();
		}
		return rollDice() + getStr();
	}

	/**
	 * @return the armor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}

	/**
	 * @return the goldReward
	 */
	public int getGoldReward() {
		return goldReward;
	}

	/**
	 * @param goldReward the goldReward to set
	 */
	public void setGoldReward(int goldReward) {
		this.goldReward = goldReward;
	}

	@Override
	public int defend() {
		return rollDice() + armor;
	}
	
	@Override
	public String toString() {
		return String.format("%s with %d Hp remaining.", getName(), getHp());
	}



}
