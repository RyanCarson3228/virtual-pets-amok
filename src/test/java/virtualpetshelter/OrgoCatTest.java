package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrgoCatTest {

	@Test
	public void shouldInstanitatePetWithNameAndDescription() {
		Pet underTest = new OrgoCat("","");
		
		assertNotNull(underTest);
	}
	@Test
	public void shouldInstantiatePetWithNameDescriptionAndAttibutes() {
		Organic underTest = new OrgoCat("", "");
		Organic expected = new OrgoCat("", "", 25, 25, 25, 25, 25);

		assertThat(underTest.getThirst(), is(expected.getThirst()));
	}
}
