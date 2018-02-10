package virtualpetshelter;

public class Organic {

	protected String name;
	protected String description;
	protected int hunger;
	protected int thirst;
	protected int boredom;
	protected int waste;
	protected int happiness;

	public Organic() {
		super();
	}

	public int getThirst() {
		return thirst;
	}

	public String getName() {
		return name;
	}

	public int getHunger() {
		return hunger;
	}

	public int getBoredom() {
		return boredom;
	}

	public String getDescription() {
		return description;
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

	public void play() {
		boredom -= 8;
		happiness += 10;
		hunger += 4;
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

	public int getHappy() {
		return happiness;
	}

}