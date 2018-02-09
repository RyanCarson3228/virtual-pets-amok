package virtualpetshelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();

		System.out.println("Welcome to your Pet Shelter!");
		System.out.println("It's our job to take care of stray pets until we can find them new homes!");
		System.out.println("Lets start by adding our first pet.");
		System.out.println("Since it's a stray, we'll have to give it a new name:");
		String name = input.nextLine();
		System.out.println("And let's give it a brief description for potential adopters:");
		String description = input.nextLine();
		shelter.addPet(new VirtualPet(name, description));

		System.out.println("If at any time you would like to quit, just type \"quit.\"");
		String userInput = "";

		while (shelter.size() >= 0) {
			if (userInput.equalsIgnoreCase("quit")) {
				System.out.println("Thank you for your help! Have a nice day!");
				System.exit(0);
			}

			shelter.printShelterStatus();
			System.out.println("Please enter the number of the task you would like to do:\n");
			System.out.println("1. Give the pets something to drink.");
			System.out.println("2. Feed all the pets some yummy food!");
			System.out.println("3. Play with one of the pets.");
			System.out.println("4. Bring a new pet into the shelter.");
			System.out.println("5. Find a new home for a pet.");
			userInput = input.nextLine();

			if (userInput.equals("1")) {
				shelter.feedAll();
				System.out.println("Great Job! The pets are all a litle bit less hungry!");
			}
			if (userInput.equals("2")) {
				shelter.drinkAll();
				System.out.println("You gave all the pets some water, it looks like they were thirsty!");
			}
			if (userInput.equals("3")) {
				System.out.println("Which pet needs some extra playtime?");
				shelter.nameAndDescription();
				String choice = input.nextLine();
				if (shelter.keyCheck(name)) {
					shelter.petPlay(choice);
					System.out.println("That was fun! Play with " + choice + " again some time!");
				} else {
					System.out.println("There isn't a pet by that name in the shelter.");
				}
			}
			if (userInput.equals("4")) {
				System.out.println("Yay a new friend! What's its name?");
				name = input.nextLine();
				System.out.println("And let's give it a brief description for potential adopters:");
				description = input.nextLine();
				shelter.addPet(new VirtualPet(name, description));
			}
			if (userInput.equals("5")) {
				System.out.println("It looks like the new parents just walked in the door!");
				System.out.println("Who are they taking again?");
				String adopted = input.nextLine();
				if (shelter.keyCheck(name)) {
					shelter.removePet(adopted);
				} else {
					System.out.println("How disappointing, the animal you were looking for isn't here.");
				}
			}

			shelter.allTick();

		}

		input.close();

	}

}
