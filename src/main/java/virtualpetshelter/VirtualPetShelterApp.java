package virtualpetshelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String userInput = "";

		VirtualPetShelter shelter = new VirtualPetShelter();
		
		shelter.addPet(new OrgoDog("Bob", "Really likes pie."));
		shelter.addPet(new OrgoCat("Sherry", "Doesn't care for strange smells."));
		shelter.addPet(new RoboDog("Megatron", "Wants to conquer the world."));
		shelter.addPet(new RoboCat("Gary", "All the pride of a cat with none of the waste."));

		System.out.println("Welcome to your Pet Shelter!");
		System.out.println("It's our job to take care of stray pets until we can find them new homes!");
		System.out.println("This Shelter takes care of both Organic and Robotic Pets!");
		System.out.println("We already have some pets in the Shelter.");
//		System.out.println("Since it's a stray, we'll have to give it a new name:");
//		String name = input.nextLine();
//		System.out.println("And let's give it a brief description for potential adopters:");
//		String description = input.nextLine();
//		System.out.println("Input the number of the type of pet you are adding:");
//		System.out.println("1.Organic Dog");
//		System.out.println("2.Organic Cat");
//		System.out.println("3.Robotic Dog");
//		System.out.println("4.Robotic Cat");
//		if (userInput == "1") {
//			shelter.addPet(new OrgoDog(name, description));
//			System.out.println("Great! The first pet you added was a regular dog!");
//		} else if (userInput == "2") {
//			shelter.addPet(new OrgoCat(name, description));
//			System.out.println("Great! The first pet you added was a regular cat!");
//		} else if (userInput == "3") {
//			shelter.addPet(new RoboDog(name, description));
//			System.out.println("Great! The first pet you added was a high tech robotic dog!");
//		} else if (userInput == "4") {
//			shelter.addPet(new RoboCat(name, description));
//			System.out.println("Great! The first pet you added was a high tech robotic cat!");
//		}

//		userInput = input.nextLine();
		System.out.println("If at any time you would like to quit, just type \"quit.\"");

		while (shelter.size() >= 0) {
			if (userInput.equalsIgnoreCase("quit")) {
				System.out.println("Thank you for your help! Have a nice day!");
				System.exit(0);
			}

			shelter.printShelterStatus();
			System.out.println("Please enter the number of the task you would like to do:\n");
			System.out.println("1. Give the pets something to drink.");
			System.out.println("2. Feed all the pets some yummy food!");
			System.out.println("3. Oil all the robots to keep them healthy.");
			System.out.println("4. Clean all the dog cages.");
			System.out.println("5. Empty the cats' litterbox.");
			System.out.println("6. Walk the dogs.");
			System.out.println("7. Play with one of the pets.");
			System.out.println("8. Bring a new pet into the shelter.");
			System.out.println("9. Find a new home for a pet.");
			userInput = input.nextLine();
			shelter.allTick();

			if (userInput.equals("1")) {
				shelter.feedAll();
				System.out.println("Great Job! The pets are all a litle bit less hungry!");
			}
			if (userInput.equals("2")) {
				shelter.drinkAll();
				System.out.println("You gave all the pets some water, it looks like they were thirsty!");
			}
			if (userInput.equals("3")) {
				shelter.oilRobots();
				System.out.println("You oiled up all the robots. They're a little less rusty!");
			}
			if (userInput.equals("4")) {
				shelter.cleanAllCages();
				System.out.println("You cleaned all the dogs' cages! They're all much cleaner now.");
			}
			if (userInput.equals("5")) {
				shelter.cleanBox();
				System.out.println("You cleaned out that nasty litterbox. The cats' room smells a little better.");
			}
			if (userInput.equals("6")) {
				shelter.walkAll();
				System.out.println(
						"You took all the dogs for a walk. The real ones did some business and the robots accumulated some rust.");
			}
			if (userInput.equals("7")) {
				System.out.println("Which pet needs some extra playtime?");
				shelter.nameAndDescription();
				String choice = input.nextLine();
				String name = null;
				if (shelter.keyCheck(name)) {
					shelter.petPlay(choice);
					System.out.println("That was fun! Play with " + choice + " again some time!");
				} else {
					System.out.println("There isn't a pet by that name in the shelter.");
				}
			}
			if (userInput.equals("8")) {
				System.out.println("Yay a new friend! What's its name?");
				String name = input.nextLine();
				System.out.println("And let's give it a brief description for potential adopters:");
				String description = input.nextLine();
				System.out.println("Enter the number of the type of pet it is:");
				if (userInput == "1") {
					shelter.addPet(new OrgoDog(name, description));
				} else if (userInput == "2") {
					shelter.addPet(new OrgoCat(name, description));
				} else if (userInput == "3") {
					shelter.addPet(new RoboDog(name, description));
				} else if (userInput == "4") {
					shelter.addPet(new RoboCat(name, description));
				}
				if (userInput.equals("9")) {
					System.out.println("It looks like the new parents just walked in the door!");
					System.out.println("Who are they taking again?");
					String adopted = input.nextLine();
					if (shelter.keyCheck(name)) {
						shelter.removePet(adopted);
					} else {
						System.out.println("How disappointing, the animal you were looking for isn't here.");
					}
				}

				

			}

		}
		input.close();
	}
}
