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
		VirtualPet expected = new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION);
		underTest.addPet(expected);
		VirtualPet check = underTest.getPet(TEST_PET_ONE_NAME);
		assertEquals(expected, check);
	}

	@Test
	public void shouldAddAPet() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		int check = underTest.size();

		assertEquals(1, check);
	}

	@Test
	public void shouldAddTwoPets() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		int check = underTest.size();

		assertEquals(2, check);
	}

	@Test
	public void shouldRemovePet() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.removePet(TEST_PET_ONE_NAME);
		int check = underTest.size();
		assertEquals(1, check);
	}

	@Test
	public void shouldPullThirstFromRightAnimal() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 25, 0, 0));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 20, 0, 0));
		int check = underTest.getPetThirst(TEST_PET_ONE_NAME);
		assertEquals(25, check);
	}

	@Test
	public void shouldPullHungerFromRightAnimal() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 0, 25, 0));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 0, 20, 0));
		int check = underTest.getPetHunger(TEST_PET_TWO_NAME);
		assertEquals(20, check);
	}

	@Test
	public void shouldPullBoredomFromRightAnimal() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION, 0, 0, 25));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION, 0, 0, 20));
		int check = underTest.getPetBoredom(TEST_PET_TWO_NAME);
		assertEquals(20, check);
	}

	@Test
	public void shouldHaveOnePetDrink() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.petDrink(TEST_PET_ONE_NAME);
		int check = underTest.getPetThirst(TEST_PET_ONE_NAME);
		assertEquals(15, check);
	}

	@Test
	public void shouldHaveAllPetsDrink() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.drinkAll();

		for (VirtualPet virtualPet : underTest.pets()) {
			int check = underTest.getPetThirst(virtualPet.getName());
			assertEquals(15, check);
		}
	}

	@Test
	public void shouldFeedOnePet() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.feedPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetHunger(TEST_PET_ONE_NAME);
		assertEquals(19, check);
	}

	@Test
	public void shouldFeedAllPets() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.feedAll();
		for (VirtualPet virtualPet : underTest.pets()) {
			int check = underTest.getPetHunger(virtualPet.getName());
			assertEquals(19, check);
		}
	}

	@Test
	public void shouldPlayWithOnePet() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.petPlay(TEST_PET_ONE_NAME);
		int check = underTest.getPetBoredom(TEST_PET_ONE_NAME);
		assertEquals(17, check);
	}

	@Test
	public void shouldTickOnOnePetCheckThirst() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.tickPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetThirst(TEST_PET_ONE_NAME);
		assertEquals(30, check);
	}

	@Test
	public void shouldTickOnOnePetCheckHunger() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.tickPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetHunger(TEST_PET_ONE_NAME);
		assertEquals(28, check);
	}

	@Test
	public void shouldTickOnOnePetCheckBoredom() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.tickPet(TEST_PET_ONE_NAME);
		int check = underTest.getPetBoredom(TEST_PET_ONE_NAME);
		assertEquals(29, check);
	}

	@Test
	public void shouldTickOnAllPetsCheckHunger() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.allTick();
		for (VirtualPet virtualPet : underTest.pets()) {
			int check = underTest.getPetHunger(virtualPet.getName());
			assertEquals(28, check);
		}
	}

	@Test
	public void shouldTickOnAllPetsCheckThirst() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.allTick();
		for (VirtualPet virtualPet : underTest.pets()) {
			int check = underTest.getPetThirst(virtualPet.getName());
			assertEquals(30, check);
		}
	}

	@Test
	public void shouldTickOnAllPetsCheckBoredom() {
		underTest.addPet(new VirtualPet(TEST_PET_ONE_NAME, TEST_PET_ONE_DESCRIPTION));
		underTest.addPet(new VirtualPet(TEST_PET_TWO_NAME, TEST_PET_TWO_DESCRIPTION));
		underTest.allTick();
		for (VirtualPet virtualPet : underTest.pets()) {
			int check = underTest.getPetBoredom(virtualPet.getName());
			assertEquals(29, check);
		}
	}
}
