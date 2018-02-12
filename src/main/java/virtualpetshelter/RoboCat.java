package virtualpetshelter;

public class RoboCat extends Robotic {

	public RoboCat(String name, String description) {
		this(name, description, 25, 25, 50, 25);
	}

	public RoboCat(String name, String description, int boredom, int happiness, int health, int rust) {
		this.name = name;
		this.boredom = boredom;
		this.description = description;
		this.happiness = happiness;
		this.health = health;
		this.rust = rust;
	}
}
