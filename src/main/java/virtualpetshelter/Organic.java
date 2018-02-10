package virtualpetshelter;

public abstract class Organic extends Pet {

	protected int hunger;
	protected int thirst;
	protected int waste;
	public Organic() {
		super();
	}

	public int getThirst() {
		return thirst;
	}

	public int getHunger() {
		return hunger;
	}

	public void tick() {
		thirst += 5;
		hunger += 3;
		boredom += 4; 
		if(waste == 50) {
			soil();
		}
	}

	public void drink() {
		thirst -= 10;
		happiness += 5;
		waste += 3;
	}

	public void feed() {
		hunger -= 6;
		happiness += 3;
		thirst += 4;
		waste+=5;
	}

	public int getWaste() {
		return waste;
	}

	public void soil() {
		waste = 0;
		hunger += 5;
		thirst += 3;
		happiness += 2;
	
	}

}