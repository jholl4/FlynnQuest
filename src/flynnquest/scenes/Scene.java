package flynnquest.scenes;

import flynnquest.characters.monsters.Monster;

public abstract class Scene {
	
	private String name; // name of scene
	private String description; // description of scene, usually about a paragraph
	private Monster monster; // monster object
	private int gold; // amount of gold that may be used as a reward
	private int userChoices; // TODO maybe use an array of ints to allow user input here
	private int userInput;
	
	// Constructors
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
		this.userChoices = userChoices;
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

	/**
	 * @return the userChoices
	 */
	public int getUserChoices() {
		return userChoices;
	}

	/**
	 * @param userChoices the userChoices to set
	 */
	public void setUserChoices(int userChoices) {
		this.userChoices = userChoices;
	}
	
	/**
	 * @return the userInput
	 */
	public int getUserInput() {
		return userInput;
	}

	/**
	 * @param userInput the userInput to set
	 */
	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}
	


//	public abstract void run();
//	public abstract int pickNextScene(int userInput);
//	public abstract void resolve();
	
	
	

}
