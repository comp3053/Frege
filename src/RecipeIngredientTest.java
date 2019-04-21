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
	public void testGetAmount() {
		assertEquals(5, ri.getAmount(),0.001);
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
	public void testUpdateAmount() {
		// valid test
		ri.updateAmount(2);
		assertEquals(2, ri.getAmount(),0.001);
		
		// invalid test
		ri.updateAmount(-2);
		// if this correct, means the amount unchanged
		assertEquals(2, ri.getAmount(),0.001);
	}

	@Test
	public void testSetAmount() {
		ri.setAmount(4);
		assertEquals(4, ri.getAmount(),0.001);
	}

	@Test
	public void testGetUnit() {
		assertEquals("ml", ri.getUnit());
	}

	@Test
	public void testSetUnit() {
		ri.setUnit("l");
		assertEquals("l", ri.getUnit());
	}
	
}
