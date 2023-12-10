package flynnquest.characters;

import flynnquest.dungeonmaster.DungeonMaster;

public class Player extends Character {

	// properties
	private String vocation;
//	private int str;
//	private int mag;
//	private int dex;
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
			this.str = 8;
			this.mag = 3;
			this.dex = 5;
		}
		if (vocation.equalsIgnoreCase("thief")) {
			this.str = 5;
			this.mag = 3;
			this.dex = 8;
		}
		if (vocation.equalsIgnoreCase("wizard")) {
			this.str = 3;
			this.mag = 8;
			this.dex = 5;
		}
	}

	// getters/setters

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getMag() {
		return mag;
	}

	public void setMag(int mag) {
		this.mag = mag;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
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

	public void damage(int dam) {
		setHp(getHp()-dam);
	}
	
	public void heal(int heal) {
		setHp(getHp()+heal);
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
			return rollDice() + str;
		}else if(getVocation().equalsIgnoreCase("thief")) {
			return rollDice() + dex;
		}else if(getVocation().equalsIgnoreCase("wizard")) {
			return rollDice() + mag;
		}
		return rollDice() + str;
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
