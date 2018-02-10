package virtualpetshelter;

public abstract class Pet {

	protected String name;
	protected String description;
	protected int boredom;
	protected int happiness;

	public Pet() {
		super();
	}

	public String getName() {
		return name;
	}

	public int getBoredom() {
		return boredom;
	}

	public String getDescription() {
		return description;
	}

	public void play() {
		boredom -= 8;
		happiness += 10;
	}

	public int getHappy() {
		return happiness;
	}

	public void tick() {
		boredom += 4;
	}

}