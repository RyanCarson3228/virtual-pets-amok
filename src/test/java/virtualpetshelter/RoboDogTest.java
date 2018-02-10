package virtualpetshelter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboDogTest {

	@Test
	public void shouldInstantiateRoboDogWithNameAndDescription() {
		Pet underTest = new RoboDog("", "");

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiatePetWithNameDescriptionAndAttibutes() {
		Pet expected = new RoboDog("", "");
		Pet underTest = new RoboDog("", "", 25, 25, 25);

		assertThat(underTest.getBoredom(), is(expected.getBoredom()));
	}

	@Test
	public void shouldReturnNameAsBob() {
		Pet underTest = new RoboDog("Bob", "");
		String check = underTest.getName();

		assertEquals("Bob", check);
	}
	
	@Test
	public void shouldReturnRustAs25() {
		RoboDog underTest = new RoboDog("","");
		int check = underTest.getRust();
		
		assertEquals(25, check);
	}

	@Test
	public void assertThatTickIncreasesRust() {
		RoboDog underTest = new RoboDog("","");
		underTest.tick();
		
		int check = underTest.getRust();
		assertEquals(26, check);
	}
	
	@Test
	public void assertThatOilReducesRust() {
		RoboDog underTest = new RoboDog("","");
		underTest.oil();
		
		int check = underTest.getRust();
		assertEquals(5, check);
	}
	

}
