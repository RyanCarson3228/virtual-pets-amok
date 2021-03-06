package virtualpetshelter;

public abstract class Robotic extends VirtualPet {

	protected int rust;

	public Robotic() {
		super();
	}

	public int getRust() {
		return rust;
	}

	@Override
	public void tick() {
		boredom += 4;
		rust += 1;
		happiness -= 1;
		if (rust <= 50) {
			health -= 3;
		}

	}

	public void oil() {
		rust -= 20;
	}

}