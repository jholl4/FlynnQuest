package flynnquest.characters;

import flynnquest.dungeonmaster.DungeonMaster;

public class Player extends Character {

	// properties
	private String vocation;
	private boolean hasEscaped; // should start as false
	private int gold;

	// constructors

	public Player() {
		super("Unknown Hero", 100);
	}

	public Player(String name, String vocation) {
		super(name, 100);
		this.vocation = vocation;
		this.hasEscaped = false;
		if (vocation.equalsIgnoreCase("warrior")) {
			setStr(8);
			setDex(5);
			setMag(3);
		}
		if (vocation.equalsIgnoreCase("thief")) {
			setStr(5);
			setDex(8);
			setMag(3);
		}
		if (vocation.equalsIgnoreCase("wizard")) {
			setStr(3);
			setDex(5);
			setMag(8);
		}
	}

	// getters/setters

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public boolean hasEscaped() {
		return hasEscaped;
	}

	public void setHasEscaped(boolean hasEscaped) {
		this.hasEscaped = hasEscaped;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void rewardGold(int rewardAmount) {
		gold = gold + rewardAmount;
	}

	public String toString() {
		DungeonMaster.printHeading("CHARACTER STATUS");
		return String.format(
				"You are the %s, %s. You have %d strength, %d magic, and %d dexterity."
						+ " You have %d Hp remaining and are currently carrying %d gold.%n",
				this.getVocation(), this.getName(), this.getStr(), this.getMag(), this.getDex(), this.getHp(), this.getGold());
	}

	@Override
	/**
	 * Roll a d20 and add stat modifier based on player's vocation
	 */
	public int attack() {
		if(getVocation().equalsIgnoreCase("warrior")) {
			return rollDice() + getStr();
		}else if(getVocation().equalsIgnoreCase("thief")) {
			return rollDice() + getDex();
		}else if(getVocation().equalsIgnoreCase("wizard")) {
			return rollDice() + getMag();
		}
		return rollDice() + getStr();
	}

	@Override
	/**
	 * Currently just implements same logic as attacking...will change later if time allows
	 */
	public int defend() {
		return attack();
	}

//	@Override
//	/**
//	 * Gives a random number based on the number of sides assigned to howManySides...used for attack/defend and skill checks
//	 */
//	public int rollDice() {
//		int howManySides = 20;
//		int result = random.nextInt(howManySides);
//		return result;
//	}

}
