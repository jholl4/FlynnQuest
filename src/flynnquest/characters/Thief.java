package flynnquest.characters;

public class Thief extends Player{

	public Thief(String name) {
		super(name, "Thief");
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
