import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipeIngredientTest {
	
	private static RecipeIngredient ri = new RecipeIngredient();
	@Before
	public void setUp() throws Exception {
		ri.setIngredientName("test");
		ri.setAmount(5);
		ri.setUnit("ml");
	}

	@Test
	public void testUpdateAmount() {
		ri.updateAmount(2);
		assertEquals(2, ri.getAmount());
	}

	@Test
	public void testGetIngredientName() {
		assertEquals("test", ri.getIngredientName());
	}

	@Test
	public void testSetIngredientName() {
		ri.setIngredientName("abc");
		assertEquals("abc", ri.getIngredientName());
	}

	@Test
	public void testGetAmount() {
		assertEquals(5, ri.getAmount());
	}

	@Test
	public void testSetAmount() {
		ri.setAmount(4);
		assertEquals(4, ri.getAmount());
	}

	@Test
	public void testGetUnit() {
		assertEquals("ml", ri.getUnit());
		fail("Not yet implemented");
	}

	@Test
	public void testSetUnit() {
		ri.setUnit("l");
		assertEquals("l", ri.getUnit());
		fail("Not yet implemented");
	}

}
