package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldInstantiatePetWithNameAndDescription() {
		VirtualPet underTest = new VirtualPet("", "");

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiatePetWithNameDescriptionAndAttibutes() {
		VirtualPet underTest = new VirtualPet("", "");
		VirtualPet expected = new VirtualPet("", "", 25, 25, 25);

		assertThat(underTest.getThirst(), is(expected.getThirst()));
	}

	@Test
	public void shouldReturnNameAsHarry() {
		VirtualPet underTest = new VirtualPet("Harry", "");
		String check = underTest.getName();

		assertEquals("Harry", check);
	}

	@Test
	public void shouldReturnThirstAsTwentyFive() {
		VirtualPet underTest = new VirtualPet("", "");
		int check = underTest.getThirst();

		assertEquals(25, check);
	}

	@Test
	public void shouldReturnHungerAsTwentyFive() {
		VirtualPet underTest = new VirtualPet("", "");
		int check = underTest.getHunger();

		assertEquals(25, check);
	}

	@Test
	public void shouldReturnBoredomAsTwentyFive() {
		VirtualPet underTest = new VirtualPet("", "");
		int check = underTest.getBoredom();

		assertEquals(25, check);
	}

	@Test
	public void shouldReturnDescriptionAsDescription() {
		VirtualPet underTest = new VirtualPet("", "Description");
		String check = underTest.getDescription();

		assertEquals("Description", check);

	}

	@Test
	public void tickShouldIncreaseThirst() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.tick();
		int check = underTest.getThirst();

		assertEquals(30, check);
	}

	@Test
	public void tickShouldIncreaseHunger() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.tick();
		int check = underTest.getHunger();

		assertEquals(28, check);
	}

	@Test
	public void tickShouldIncreaseBoredom() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.tick();
		int check = underTest.getBoredom();

		assertEquals(29, check);
	}

	@Test
	public void drinkShouldReduceThirst() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.drink();
		int check = underTest.getThirst();

		assertEquals(15, check);
	}

	@Test
	public void feedShouldReduceHUnger() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.feed();
		int check = underTest.getHunger();

		assertEquals(19, check);
	}

	@Test
	public void playShouldReduceBoredom() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.play();
		int check = underTest.getBoredom();

		assertEquals(17, check);
	}

}
