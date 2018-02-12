package virtualpetshelter;

public class RoboDog extends Robotic implements Walkable{

	public RoboDog(String name, String description) {
		this(name, description, 25, 25, 25);
	}

	public RoboDog(String name, String description, int boredom, int happiness, int rust) {
		this.name = name;
		this.description = description;
		this.boredom = boredom;
		this.happiness = happiness;
		this.rust = rust;
	}
	
	@Override
	public void walk() {
		boredom-=10;
		happiness+=5;
		rust+=15; 
	}

}
