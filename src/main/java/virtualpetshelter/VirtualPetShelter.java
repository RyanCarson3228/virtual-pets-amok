package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	// return a Collection of all of the pets in the shelter
	public Collection<VirtualPet> pets() {
		return pets.values();
	}

	// return a specific VirtualPet given its name
	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	// allow intake of a homeless pet
	public void addPet(VirtualPet virtualPet) {
		pets.put(virtualPet.getName(), virtualPet);
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
		return pets.get(name).getThirst();
	}

	public int getPetHunger(String name) {
		return pets.get(name).getHunger();
	}

	public int getPetBoredom(String name) {
		return pets.get(name).getBoredom();
	}

	// water all pets in the shelter
	public void petDrink(String name) {
		VirtualPet virtualPet = pets.get(name);
		virtualPet.drink();
	}

	public void drinkAll() {
		for (VirtualPet virtualPet : pets()) {
			petDrink(virtualPet.getName());
		}
	}

	// feed all pets in the shelter
	public void feedPet(String name) {
		VirtualPet virtualPet = pets.get(name);
		virtualPet.feed();
	}

	public void feedAll() {
		for (VirtualPet virtualPet : pets()) {
			feedPet(virtualPet.getName());
		}
	}

	// plays with an individual pet in the shelter
	public void petPlay(String name) {
		VirtualPet virtualPet = pets.get(name);
		virtualPet.play();
	}

	// include a tick method that calls the tick method for each of the pets in the
	// shelter, updating their needs
	public void tickPet(String name) {
		VirtualPet virtualPet = pets.get(name);
		virtualPet.tick();
	}

	public void allTick() {
		for (VirtualPet virtualPet : pets()) {
			tickPet(virtualPet.getName());
		}
	}

	// console methods
	public void printShelterStatus() {
		System.out.println("\nThis is the Status of the the pets at the Shelter:");
		System.out.println("Name\t|Thirst\t|Hunger\t|Boredom");
		System.out.println("--------|-------|-------|-------");
		for (VirtualPet virtualPet : pets()) {
			System.out.print(virtualPet.getName() + "\t|" + virtualPet.getThirst() + "\t|");
			System.out.println(virtualPet.getHunger() + "\t|" + virtualPet.getBoredom() + "\n");
		}

	}

	public void nameAndDescription() {
		for (VirtualPet virtualPet : pets()) {
			System.out.println("[" + virtualPet.getName() + "] " + virtualPet.getDescription() + ".");
		}
	}

	public boolean keyCheck(String name) {
		for (VirtualPet virtualPet : pets()) {
			if (virtualPet.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}
