package virtualpetshelter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboDogTest {

	// testing constructors
	@Test
	public void shouldInstantiateRoboDogWithNameAndDescription() {
		VirtualPet underTest = new RoboDog("", "");

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiatePetWithNameDescriptionAndAttibutes() {
		VirtualPet expected = new RoboDog("", "");
		VirtualPet underTest = new RoboDog("", "", 25, 25, 50, 25);

		assertThat(underTest.getBoredom(), is(expected.getBoredom()));
	}

	// this test was to check the superclasses were working
	@Test
	public void shouldReturnNameAsBob() {
		VirtualPet underTest = new RoboDog("Bob", "");
		String check = underTest.getName();

		assertEquals("Bob", check);
	}

	@Test
	public void shouldReturnRustAs25() {
		Robotic underTest = new RoboDog("", "");
		int check = underTest.getRust();

		assertEquals(25, check);
	}

	@Test
	public void assertThatTickIncreasesRust() {
		Robotic underTest = new RoboDog("", "");
		underTest.tick();

		int check = underTest.getRust();
		assertEquals(26, check);
	}

	@Test
	public void assertThatOilReducesRust() {
		Robotic underTest = new RoboDog("", "");
		underTest.oil();

		int check = underTest.getRust();
		assertEquals(5, check);
	}

}
