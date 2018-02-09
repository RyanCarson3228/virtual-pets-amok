package virtualpetshelter;

public class VirtualPet {

	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;

	public VirtualPet(String name, String description) {
		this(name, description, 25, 25, 25);
	}

	public VirtualPet(String name, String description, int thirst, int hunger, int boredom) {
		this.name = name;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
		this.description = description;
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
	}

	public void drink() {
		thirst -= 10;
	}

	public void feed() {
		hunger -= 6;
	}

	public void play() {
		boredom -= 8;
	}
}
