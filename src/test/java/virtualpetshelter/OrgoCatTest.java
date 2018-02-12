package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrgoCatTest {

	@Test
	public void shouldInstanitatePetWithNameAndDescription() {
		VirtualPet underTest = new OrgoCat("", "");

		assertNotNull(underTest);
	}

	@Test
	public void shouldInstantiatePetWithNameDescriptionAndAttibutes() {
		Organic underTest = new OrgoCat("", "");
		Organic expected = new OrgoCat("", "", 25, 25, 25, 25, 25, 50, 0);

		assertThat(underTest.getThirst(), is(expected.getThirst()));
	}

	@Test
	public void shouldReturnContributionsAsFive() {
		OrgoCat underTest = new OrgoCat("", "");
		underTest.soil();

		int check = underTest.getContribution();
		assertEquals(5, check);
	}

	@Test
	public void shouldReturnContributionToZero() {
		OrgoCat underTest = new OrgoCat("", "");
		underTest.sift();

		int check = underTest.getContribution();
		assertEquals(0, check);
	}
}
