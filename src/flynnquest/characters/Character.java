package flynnquest.characters;

import java.util.Random;

public abstract class Character {
	
	// properties
		private String name;
		private static int maxHp = 100;
		private int hp;
		private boolean isAlive;
		protected static Random random = new Random();
		private int str;
		private int mag;
		private int dex;
		
	// constructors
		
	public Character() {
		this.name = "Unknown";
		this.hp = maxHp;
		this.isAlive = true;
	}
		
	public Character(String name, int maxHp) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.isAlive = true;
		this.str = 5;
		this.dex = 5;
		this.mag = 5;
	}
	
	public Character(String name, int maxHp, int str, int dex, int mag) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.str = str;
		this.dex = dex;
		this.mag = mag;
	}
	
	// getters/setters
	
	/**
	 * 
	 * @return character's Hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Set character's Hp
	 * @param hp
	 */
	public void setHp(int hp) {
		this.hp = hp;
		if(hp <= 0) {
			isAlive = false;
		}
	}

	/**
	 * 
	 * @return character's living status
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Changes character's living status
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return maxHp
	 */
	public int getMaxHp() {
		return maxHp;
	}
	
	/**
	 * @return the str
	 */
	public int getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(int str) {
		this.str = str;
	}

	/**
	 * @return the mag
	 */
	public int getMag() {
		return mag;
	}

	/**
	 * @param mag the mag to set
	 */
	public void setMag(int mag) {
		this.mag = mag;
	}

	/**
	 * @return the dex
	 */
	public int getDex() {
		return dex;
	}

	/**
	 * @param dex the dex to set
	 */
	public void setDex(int dex) {
		this.dex = dex;
	}
	
	public void damage(int dam) {
		setHp(getHp()-dam);
	}
	
	public void heal(int heal) {
		setHp(getHp()+heal);
	}

	protected int rollDice() {
		int howManySides = 20;
		int result = random.nextInt(howManySides);
		return result;
	}

	// abstract methods for every character
	public abstract int attack();
	public abstract int defend();
	

}
