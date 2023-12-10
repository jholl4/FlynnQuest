package flynnquest.characters;

public abstract class Character {
	
	// properties
		private String name;
		private static int maxHp = 100;
		private int hp;
		private boolean isAlive;		
		
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
	}
	
	// getters/setters
	

	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	// abstract methods for every character
	public abstract int attack();
	public abstract int defend();
	

}
