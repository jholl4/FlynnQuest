package flynnquest.characters;

import flynnquest.dungeonmaster.DungeonMaster;

public abstract class Player extends Character {
	
	// properties
	private String vocation;
	private int str;
	private int mag;
	private int dex;
	private boolean hasEscaped; // should start as false
	private int gold;
	
	// constructors
	public Player(String name, String vocation) {
		super(name, 100);
		this.vocation = vocation;
		this.hasEscaped = false;
		this.str = 0;
		this.mag = 0;
		this.dex = 0;
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

	public boolean isHasEscaped() {
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
	
	// abstract methods

	public abstract int attack();

	public abstract int defend();
	
	public String toString() {
		DungeonMaster.printHeading("CHARACTER STATUS");
		return String.format("You are the %s, %s. You have %d strength, %d magic, and %d dexterity. You are currently carrying %d gold.%n", this.getVocation(), this.getName(), this.getStr(), this.getMag(), this.getDex(), this.getGold() );
	}
	

}
