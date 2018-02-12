package virtualpetshelter;

public class RoboDog extends Robotic implements Walkable {

	public RoboDog(String name, String description) {
		this(name, description, 25, 25, 50, 25);
	}

	public RoboDog(String name, String description, int boredom, int happiness, int health, int rust) {
		this.name = name;
		this.description = description;
		this.boredom = boredom;
		this.happiness = happiness;
		this.health = health;
		this.rust = rust;
	}

	@Override
	public void walk() {
		boredom -= 10;
		happiness += 5;
		rust += 15;
	}

}
