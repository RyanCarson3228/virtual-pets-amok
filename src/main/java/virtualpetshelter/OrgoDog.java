package virtualpetshelter;

public class OrgoDog extends Organic {

	public OrgoDog(String name, String description) {
		this(name, description, 25, 25, 25, 25, 25);
	}

	public OrgoDog(String name, String description, int thirst, int hunger, int boredom, int waste, int happiness) {
		this.name = name;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
		this.description = description;
		this.waste = waste;
		this.happiness = happiness;
	}

	// start virtual-pet-amok methods

	public void walk() {
		boredom -= 10;
		waste -= 10;
		happiness += 5;
		hunger += 3;
		thirst += 5;
	}
}
