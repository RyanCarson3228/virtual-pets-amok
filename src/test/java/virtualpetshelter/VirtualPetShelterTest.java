package virtualpetshelter;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	private static final String TEST_PET_TWO_DESCRIPTION = "Description ";
	private static final String TEST_PET_TWO_NAME = "Joe";
	private static final String TEST_PET_ONE_DESCRIPTION = "Description";
	private static final String TEST_PET_ONE_NAME = "Harry";
	private VirtualPetShelter underTest;

	@Before
	public void setup() {
		underTest = new VirtualPetShelter();
	}

	@Test
	public void nameShouldGetPet() {
		OrgoDog expected = new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION);
		underTest.addPet(expected);
		VirtualPet check = underTest.getPet(TEST_PET_ONE_NAME);
		assertEquals(expected, check);
	}

	@Test
	public void shouldAddAPet() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		int check = underTest.size();

		assertEquals(1, check);
	}

	@Test
	public void shouldAddTwoPets() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		int check = underTest.size();

		assertEquals(2, check);
	}

	@Test
	public void shouldRemovePet() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.removePet(TEST_PET_ONE_NAME);
		int check = underTest.size();
		assertEquals(1, check);
	}

	@Test
	public void shouldPullThirstFromRightAnimal() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 25, 0, 0, 10, 25, 50, 100));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 20, 0, 0, 10, 25, 50, 100));
		int check = underTest.getPetThirst(TEST_PET_ONE_NAME);
		assertEquals(25, check);
	}

	@Test
	public void shouldPullHungerFromRightAnimal() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 0, 25, 0, 10, 25, 50, 100));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 0, 20, 0, 10, 25, 50, 100));
		int check = underTest.getPetHunger(TEST_PET_TWO_NAME);
		assertEquals(20, check);
	}

	@Test
	public void shouldPullBoredomFromRightAnimal() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 0, 0, 25, 10, 25, 50, 100));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 0, 0, 20, 10, 25, 50, 100));
		int check = underTest.getPetBoredom(TEST_PET_TWO_NAME);
		assertEquals(20, check);
	}

	// Update Test to be only to Organic Pets
	@Test
	public void shouldHaveAllOrganicPetsDrink() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.drinkAll();

		for (VirtualPet virtualPet : underTest.allPets()) {
			if (virtualPet instanceof Organic) {
				int check = ((Organic) virtualPet).getThirst();
				assertEquals(15, check);
			}
		}
	}

	// Update Test to only apply to Organic Pets
	@Test
	public void shouldFeedAllOrganicPets() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.feedAll();
		for (VirtualPet virtualPet : underTest.allPets()) {
			if (virtualPet instanceof Organic) {
				int check = ((Organic) virtualPet).getHunger();
				assertEquals(19, check);
			}
		}
	}

	@Test
	public void shouldPlayWithOnePet() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.petPlay(TEST_PET_ONE_NAME);
		int check = underTest.getPetBoredom(TEST_PET_ONE_NAME);
		assertEquals(17, check);
	}

	@Test
	public void shouldTickOnOnePetCheckThirst() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.tickPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetThirst(TEST_PET_ONE_NAME);
		assertEquals(30, check);
	}

	@Test
	public void shouldTickOnOnePetCheckHunger() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.tickPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetHunger(TEST_PET_ONE_NAME);
		assertEquals(28, check);
	}

	@Test
	public void shouldTickOnOnePetCheckBoredom() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.tickPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetBoredom(TEST_PET_ONE_NAME);
		assertEquals(29, check);
	}

	@Test
	public void shouldTickOnAllPetsCheckHunger() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.allTick();
		for (VirtualPet virtualPet : underTest.allPets()) {
			int check = underTest.getPetHunger(virtualPet.getName());
			assertEquals(28, check);
		}
	}

	@Test
	public void shouldTickOnAllPetsCheckThirst() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.allTick();
		for (VirtualPet virtualPet : underTest.allPets()) {
			int check = underTest.getPetThirst(virtualPet.getName());
			assertEquals(30, check);
		}
	}

	@Test
	public void shouldTickOnAllPetsCheckBoredom() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.allTick();
		for (VirtualPet virtualPet : underTest.allPets()) {
			int check = underTest.getPetBoredom(virtualPet.getName());
			assertEquals(29, check);
		}
	}

	@Test
	public void shouldOilAllRoboticPetsCheckRobots() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.addPet(new RoboDog("Sam", "Description"));
		underTest.oilRobots();
		for (VirtualPet virtualPet : underTest.allPets()) {
			if (virtualPet instanceof Robotic) {
				int check = ((Robotic) virtualPet).getRust();
				assertEquals(5, check);
			}
		}
	}

	@Test
	public void shouldCleanAllDogCages() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.addPet(new RoboDog("Sam", "Description"));
		underTest.cleanAllCages();
		for (VirtualPet virtualPet : underTest.allPets()) {
			if (virtualPet instanceof OrgoDog) {
				int check = ((OrgoDog) virtualPet).getCageState();
				assertEquals(100, check);
			}
		}
	}

	@Test
	public void shouldReturnSumContribtionsToLitterboxAsThirty() {
		underTest.addPet(new OrgoCat(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 0, 0, 0, 0, 0, 50, 10));
		underTest.addPet(new OrgoCat(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 0, 0, 0, 0, 0, 50, 20));
		int check = underTest.boxStatus();

		assertEquals(30, check);
	}

	@Test
	public void shouldChangeAllContributionsToZero() {
		underTest.addPet(new OrgoCat(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 0, 0, 0, 0, 0, 50, 10));
		underTest.addPet(new OrgoCat(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 0, 0, 0, 0, 0, 50, 20));
		underTest.cleanBox();
		for (VirtualPet virtualPet : underTest.allPets()) {
			if (virtualPet instanceof OrgoCat) {
				int check = ((OrgoCat) virtualPet).getContribution();
				assertEquals(0, check);
			}
		}
	}

	@Test
	public void shouldWalkAllDogs() {
		underTest.addPet(new OrgoDog(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new OrgoDog(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.addPet(new RoboDog("Sam", "Description"));
		underTest.walkAll();
		for (VirtualPet virtualPet : underTest.allPets()) {
			if (virtualPet instanceof Walkable) {
				int check = ((VirtualPet) virtualPet).getBoredom();
				assertEquals(15, check);
			}
		}

	}

	@Test
	public void testPrintShelterStatus() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
