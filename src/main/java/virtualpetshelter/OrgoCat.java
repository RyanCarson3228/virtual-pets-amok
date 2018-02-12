package virtualpetshelter;

public class OrgoCat extends Organic {

	private int contribution;

	public OrgoCat(String name, String description) {
		this(name, description, 25, 25, 25, 25, 25, 50, 0);
	}

	public OrgoCat(String name, String description, int thirst, int hunger, int boredom, int waste, int happiness,
			int health, int contribution) {
		this.name = name;
		this.thirst = thirst;
		this.hunger = hunger;
		this.boredom = boredom;
		this.description = description;
		this.waste = waste;
		this.health = health;
		this.happiness = happiness;
		this.contribution = contribution;
	}

	@Override
	public void soil() {
		waste = 0;
		hunger += 5;
		thirst += 3;
		happiness += 2;
		contribution += 5;
	}

	public int getContribution() {
		return contribution;
	}

	public void sift() {
		contribution = 0;
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

	}

}
