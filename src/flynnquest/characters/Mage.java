package flynnquest.characters;

public class Mage extends Player{

	public Mage(String name) {
			super(name, "Mage");
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
