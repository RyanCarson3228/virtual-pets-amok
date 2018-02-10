package virtualpetshelter;

public class RoboDog extends Pet {

	private int rust;

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

	public int getRust() {
		return rust;
	}
	
	@Override
	public void tick() {
		boredom +=4;
		rust+= 1;
		
	}

	public void oil() {
		rust-=20;
	}

}
