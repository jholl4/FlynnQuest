package flynnquest.scenes;

import java.util.Scanner;

import flynnquest.characters.Monster;

public class Scene {
	
	private String description;
	private Monster monster;
	private int scenePointer;
	private int treasure;
	private Scanner scan;
	
	// Constructors
	public Scene() {
		this.description = "";
//		this.monster = monster;
		this.scenePointer = scenePointer;
		this.treasure = treasure;
		this.scan = scan;
	}
	
	
	// getters/setters
	public Monster getMonster() {
		return monster;
	}


	public void setMonster(Monster monster) {
		this.monster = monster;
	}


	public int getScenePointer() {
		return scenePointer;
	}


	public void setScenePointer(int scenePointer) {
		this.scenePointer = scenePointer;
	}


	public String getDescription() {
		return description;
	}


	public int getTreasure() {
		return treasure;
	}


	public Scanner getScan() {
		return scan;
	}
	
	// helper methods
	private void run() {
		
	}

	

}
