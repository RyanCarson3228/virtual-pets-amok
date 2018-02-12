package virtualpetshelter;

public class RoboCat extends Robotic{

	public RoboCat(String name, String description) {
		this(name, description, 25, 25, 25);
	}

	public RoboCat(String name, String description, int boredom, int happiness, int rust) {
		this.name = name;
		this.boredom = boredom;
		this.description = description;
		this.happiness = happiness;
		this.rust = rust;
	}
}
