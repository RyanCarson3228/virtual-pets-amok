package virtualpetshelter;

public abstract class Robotic extends Pet{

	protected int rust;

	public Robotic() {
		super();
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