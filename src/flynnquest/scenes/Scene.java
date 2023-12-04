package flynnquest.scenes;

import java.util.Scanner;

import flynnquest.characters.Monster;

public abstract class Scene {
	
	private String description;
	private Monster monster;
	private int scenePointer;
	private int treasure;
	private String menu;
	private int userChoices;
	
	// Constructors
	public Scene() {
		this.description = "";
		this.menu = "";
//		this.monster = monster;
//		this.scenePointer = scenePointer;
//		this.treasure = treasure;
	}
	
	
	// getters/setters
	public Monster getMonster() {
		return monster;
	}


	public int getScenePointer() {
		return scenePointer;
	}


	public String getDescription() {
		return description;
	}


	public int getTreasure() {
		return treasure;
	}


	public String getMenu() {
		return menu;
	}


	public int getUserChoices() {
		return userChoices;
	}
	

	

}
