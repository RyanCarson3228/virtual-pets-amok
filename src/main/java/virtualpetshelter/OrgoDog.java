package virtualpetshelter;

public class OrgoDog extends Organic implements Walkable {

	private int cageState;

	public OrgoDog(String name, String description) {
		this(name, description, 25, 25, 25, 25, 25, 50, 100);
	}

	public OrgoDog(String name, String description, int thirst, int hunger, int boredom, int waste, int happiness,
			int health, int cageState) {
		this.name = name;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
		this.description = description;
		this.waste = waste;
		this.happiness = happiness;
		this.cageState = cageState;
		this.health = health;
	}

	// start virtual-pet-amok methods

	/*
	 * (non-Javadoc)
	 * 
	 * @see virtualpetshelter.Walkable#walk()
	 */
	@Override
	public void walk() {
		boredom -= 10;
		waste -= 10;
		happiness += 5;
		hunger += 3;
		thirst += 5;
	}

	public int getCageState() {
		return cageState;
	}

	public void cleanCage() {
		cageState = 100;
	}

	@Override
	public void soil() {
		waste = 0;
		hunger += 5;
		thirst += 3;
		happiness += 2;
		cageState -= 30;
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
		if (cageState <= 25) {
			health -= 10;
		} else if (cageState <= 50) {
			health -= 5;
		}
	}
}
