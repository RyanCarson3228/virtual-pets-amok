package virtualpetshelter;

public abstract class Organic extends VirtualPet {

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

	@Override
	public void tick() {
		thirst += 5;
		hunger += 3;
		boredom += 4;
		if (waste == 50) {
			soil();
		}
		if (health <= 25) {
			happiness -= 15;
		} else if (health > 25 && health <= 50) {
			happiness -= 5;
		} else if (health > 50 && health <= 75) {
			happiness += 5;
		} else {
			happiness += 10;
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
		waste += 5;
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