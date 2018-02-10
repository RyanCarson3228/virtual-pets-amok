package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrgoDogTest {

	@Test
	public void shouldInstantiatePetWithNameAndDescription() {
		Pet underTest = new OrgoDog("", "");

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiatePetWithNameDescriptionAndAttibutes() {
		Organic underTest = new OrgoDog("", "");
		Organic expected = new OrgoDog("", "", 25, 25, 25, 25, 25);

		assertThat(underTest.getThirst(), is(expected.getThirst()));
	}

	@Test
	public void shouldReturnNameAsHarry() {
		Pet underTest = new OrgoDog("Harry", "");
		String check = underTest.getName();

		assertEquals("Harry", check);
	}

	@Test
	public void shouldReturnThirstAsTwentyFive() {
		Organic underTest = new OrgoDog("", "");
		int check = underTest.getThirst();

		assertEquals(25, check);
	}

	@Test
	public void shouldReturnHungerAsTwentyFive() {
		Organic underTest = new OrgoDog("", "");
		int check = underTest.getHunger();

		assertEquals(25, check);
	}

	@Test
	public void shouldReturnBoredomAsTwentyFive() {
		Pet underTest = new OrgoDog("", "");
		int check = underTest.getBoredom();

		assertEquals(25, check);
	}

	@Test
	public void shouldReturnDescriptionAsDescription() {
		Pet underTest = new OrgoDog("", "Description");
		String check = underTest.getDescription();

		assertEquals("Description", check);

	}

	@Test
	public void tickShouldIncreaseThirst() {
		Organic underTest = new OrgoDog("", "");
		underTest.tick();
		int check = underTest.getThirst();

		assertEquals(30, check);
	}

	@Test
	public void tickShouldIncreaseHunger() {
		Organic underTest = new OrgoDog("", "");
		underTest.tick();
		int check = underTest.getHunger();

		assertEquals(28, check);
	}

	@Test
	public void tickShouldIncreaseBoredom() {
		Organic underTest = new OrgoDog("", "");
		underTest.tick();
		int check = underTest.getBoredom();

		assertEquals(29, check);
	}

	@Test
	public void drinkShouldReduceThirst() {
		Organic underTest = new OrgoDog("", "");
		underTest.drink();
		int check = underTest.getThirst();

		assertEquals(15, check);
	}

	@Test
	public void feedShouldReduceHUnger() {
		Organic underTest = new OrgoDog("", "");
		underTest.feed();
		int check = underTest.getHunger();

		assertEquals(19, check);
	}

	@Test
	public void playShouldReduceBoredom() {
		Pet underTest = new OrgoDog("", "");
		underTest.play();
		int check = underTest.getBoredom();

		assertEquals(17, check);
	}

	// start virtual-pet-amok testing
	@Test
	public void shouldReturnWasteAsTwentyFive() {
		Organic underTest = new OrgoDog("", "");
		int check = underTest.getWaste();

		assertEquals(25, check);
	}

	@Test
	public void soilShouldReduceWaste() {
		Organic underTest = new OrgoDog("", "");
		underTest.soil();

		int check = underTest.getWaste();
		assertEquals(0, check);
	}

	@Test
	public void walkShouldReduceBoredom() {
		OrgoDog underTest = new OrgoDog("", "");
		underTest.walk();

		int check = underTest.getBoredom();
		assertEquals(15, check);
	}

	@Test
	public void walkShouldReduceWaste() {
		OrgoDog underTest = new OrgoDog("", "");
		underTest.walk();

		int check = underTest.getWaste();
		assertEquals(15, check);
	}

	@Test
	public void shouldReturnHappinessAsTwentyFive() {
		Organic underTest = new OrgoDog("", "");
		int check = underTest.getHappy();

		assertEquals(25, check);
	}

	@Test
	public void walkShouldIncreaseHappiness() {
		OrgoDog underTest = new OrgoDog("", "");
		underTest.walk();

		int check = underTest.getHappy();
		assertEquals(30, check);
	}

	@Test
	public void shouldSoilAtHighWaste() {
		Organic underTest = new OrgoDog("", "", 25, 25, 25, 50, 25);
		underTest.tick();
		int check = underTest.getWaste();

		assertEquals(0, check);
	}
}
