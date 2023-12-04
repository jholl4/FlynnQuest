package flynnquest.characters;

public class Warrior extends Player{

	public Warrior(String name) {
		super(name, "Warrior");
		this.setStr(18);
		this.setMag(8);
		this.setDex(10);
		this.setGold(0);
	}

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

}
