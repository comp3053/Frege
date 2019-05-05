package mainPart;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipeIngredientTest {
	
	private static RecipeIngredient ri = new RecipeIngredient();
	
	@Before
	public void setUp() throws Exception {
		// initialization
		ri.setIngredientName("test");
		ri.setAmount(5);
		ri.setUnit("ml");
	}

	@Test
	public void testGetAmount() {
		// if we get a right amount, means all set functions in our initialization are correct 
		assertEquals(5, ri.getAmount(), 0.001);
		// and also the getAmount function is correct
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
		assertEquals(true, ri.updateAmount(2));	// if input is valid, it will return true
		assertEquals(2, ri.getAmount(),0.001);	// and value will be changed
		
		// invalid test
		
		assertEquals(false, ri.updateAmount(-2));	// if input a negative number, the function will return false
		assertEquals(2, ri.getAmount(),0.001);		// and amount remain unchanged
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
		// valid test
		assertEquals(true, ri.setUnit("l"));	// if input is correct type, it will return true
		assertEquals("l", ri.getUnit());		// and unit will change
		
		// invalid test
		assertEquals(false, ri.setUnit("gg")); // if input a wrong type of unit, it will return false
		assertEquals("l", ri.getUnit());		// and unit remain unchanged
	}
	
}
