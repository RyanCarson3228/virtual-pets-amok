package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private int sumContributions = 0;

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	// return a Collection of all of the pets in the shelter
	public Collection<VirtualPet> allPets() {
		return pets.values();
	}

	// return a specific VirtualPet given its name
	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	// allow intake of a homeless pet
	public void addPet(VirtualPet virtualPet) {
		pets.put(virtualPet.name, virtualPet);
	}

	public int size() {
		return pets.size();
	}

	// allow adoption of a homeless pet
	public void removePet(String adopted) {
		pets.remove(adopted);

	}

	// Extract attributes from VirtualPet
	public int getPetThirst(String name) {

		return ((Organic) pets.get(name)).getThirst();
	}

	public int getPetHunger(String name) {
		return ((Organic) pets.get(name)).getHunger();
	}

	public int getPetBoredom(String name) {
		return pets.get(name).getBoredom();
	}

	// water all pets in the shelter

	public void drinkAll() {

		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof Organic) {
				((Organic) virtualPet).drink();
			}
		}
	}

	// feed all pets in the shelter

	public void feedAll() {
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof Organic) {
				((Organic) virtualPet).feed();
			}
		}
	}

	// plays with an individual pet in the shelter
	public void petPlay(String name) {
		VirtualPet virtualPet = pets.get(name);
		virtualPet.play();
	}

	// method to oil all robotic pets
	public void oilRobots() {
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof Robotic) {
				((Robotic) virtualPet).oil();
			}
		}
	}

	public void cleanAllCages() {
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof OrgoDog) {
				((OrgoDog) virtualPet).cleanCage();
			}
		}
	}

	// include a tick method that calls the tick method for each of the pets in the
	// shelter, updating their needs
	public void tickPet(String name) {
		VirtualPet virtualPet = pets.get(name);
		virtualPet.tick();
	}

	public void allTick() {
		for (VirtualPet virtualPet : allPets()) {
			// tickPet(virtualPet.getName());
			if (virtualPet instanceof OrgoDog) {
				((OrgoDog) virtualPet).tick();
			} else if (virtualPet instanceof OrgoCat) {
				((OrgoCat) virtualPet).tick();
			} else if (virtualPet instanceof RoboDog) {
				((RoboDog) virtualPet).tick();
			} else if (virtualPet instanceof RoboCat) {
				((RoboCat) virtualPet).tick();
			}
			if (virtualPet.getHealth() <= 0) {
				removePet(virtualPet.name);
				System.out.println("Oh no! One of your pets got to sick and PETA took them away.");
			}

		}
	}

	public int boxStatus() {
		int sumContributions = 0;
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof OrgoCat) {
				sumContributions += ((OrgoCat) virtualPet).getContribution();
			}
		}
		return sumContributions;
	}

	public void cleanBox() {
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof OrgoCat) {
				((OrgoCat) virtualPet).sift();
			}
		}
	}

	public void walkAll() {
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof Walkable) {
				((Walkable) virtualPet).walk();
			}
		}
	}

	// console methods
	public void printShelterStatus() {
		System.out.println("\nThis is the Status of the the pets at the Shelter:");
		System.out.println("Name\t|Thirst\t|Hunger\t|Boredom|Waste\t|Happy  |Health |Grime  |Rust");
		System.out.println("--------|-------|-------|-------|-------|-------|-------|-------|----");
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet instanceof OrgoDog) {
				System.out.print(virtualPet.getName() + "\t|" + ((OrgoDog) virtualPet).getThirst() + "\t|");
				System.out.println(((OrgoDog) virtualPet).getHunger() + "\t|" + virtualPet.getBoredom()
						+ "\t|" + ((OrgoDog) virtualPet).getWaste() + "\t|" + virtualPet.getHappy() + "\t|" + virtualPet.getHealth() + "\t|"
						+ ((OrgoDog) virtualPet).getCageState() + "\t|" + "n/a\t\n");
			}

			if (virtualPet instanceof OrgoCat) {
				System.out.print(virtualPet.getName() + "\t|" + ((OrgoCat) virtualPet).getThirst() + "\t|");
				System.out.println(((OrgoCat) virtualPet).getHunger() + "\t|" + virtualPet.getBoredom()
						+ "\t|" + ((OrgoCat) virtualPet).getWaste() + "\t|" + virtualPet.getHappy() + "\t|" + virtualPet.getHealth() + "\t|"
						+ "n/a\t|"+ "n/a\t\n");
				sumContributions += ((OrgoCat) virtualPet).getContribution();

			}
			if (virtualPet instanceof RoboDog) {
				System.out.print(
						virtualPet.getName() + "|n/a" + "\t|" + "n/a\t|" + "n/a\t|" + virtualPet.getHappy() + "\t|");
				System.out.println(
						virtualPet.getHealth() + "\t|" + ((RoboDog) virtualPet).getHealth() + "\t" +"|n/a\t|" + ((RoboDog) virtualPet).getRust() + "\t\n" + "");
			}
			if (virtualPet instanceof RoboCat) {
				System.out.print(
						virtualPet.getName() + "\t|" + "n/a\t|" + "n/a\t|" + "n/a\t|" + virtualPet.getHappy() + "\t|");
				System.out.println(
						virtualPet.getHealth() + "\t|" + ((RoboCat) virtualPet).getHealth() +"\t" + "|n/a\t|" + ((RoboCat) virtualPet).getRust() + "\t\n" + "");
			}
		}

		System.out.println("The cats have made " + sumContributions + " contributions to the litterbox.");
	}

	public void nameAndDescription() {
		for (VirtualPet virtualPet : allPets()) {
			System.out.println("[" + virtualPet.getName() + "] " + virtualPet.getDescription() + ".");
		}
	}

	public boolean keyCheck(String name) {
		for (VirtualPet virtualPet : allPets()) {
			if (virtualPet.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

}
