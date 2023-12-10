package flynnquest.characters;

public class Monster extends Character{
	
	public Monster(String name, int maxHp) {
		super(name, maxHp);
		// TODO Auto-generated constructor stub
	}

	// properties
	private int dc; // difficulty class (player attacks will check against this)

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// constructors
	
	// getters/setters
	
	// helper methods

}
