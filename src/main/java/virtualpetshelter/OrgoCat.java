package virtualpetshelter;

public class OrgoCat extends Organic{

	public OrgoCat(String name, String description) {
		this(name, description, 25, 25, 25, 25, 25);
	}

	public OrgoCat(String name, String description, int thirst, int hunger, int boredom, int waste, int happiness) {
		this.name = name;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
		this.description = description;
		this.waste = waste;
		this.happiness = happiness;
	}
}
