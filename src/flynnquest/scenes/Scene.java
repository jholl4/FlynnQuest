package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;

public abstract class Scene {
	
	private String name; // name of scene
	private String description; // description of scene, usually about a paragraph
	private Monster monster; // monster object
	private int gold; // amount of gold that may be used as a reward
	
	public Scene() {
		this.name = "";
		this.description = "";
		this.monster = null;
		this.gold = 0;
	}
	
	public Scene(int sceneId, String name, String description, Monster monster, int gold, String menu, int userChoices) {
		this.name = name;
		this.description = description;
		this.monster = monster;
		this.gold = gold;
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the monster
	 */
	public Monster getMonster() {
		return monster;
	}

	/**
	 * @param monster the monster to set
	 */
	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

}
