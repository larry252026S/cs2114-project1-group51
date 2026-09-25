package bossCooking;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Tests the Supplies class, verifying that getIngredients() and getAppliances() return the
 * predefined arrays of available ingredients and appliances described in the specification.
 */
public class SuppliesTest {

    /** The Supplies instance under test. */
    private Supplies supplies;

    /**
     * Creates a new Supplies object before each test so that every test runs against a
     * fresh, unmodified instance.
     */
    @Before
    public void setUp() {
        supplies = new Supplies();
    }

    /**
     * Tests whether getIngredients() returns the String[] stored; that the returned array
     * matches the expected ingredients.
     */
    @Test
    public void getIngredientsTest() {
        String[] expectedIngredients = {
            "Bread", "Jam", "Ham", "Cheese", "Egg", "Butter", "Lettuce", "Tomato"
        };

        assertArrayEquals(expectedIngredients, supplies.getIngredients());
    }

    /**
     * Tests whether getAppliances() returns the String[] stored; that the returned array
     * matches the expected appliances.
     */
    @Test
    public void getAppliancesTest() {
        String[] expectedAppliances = {
            "Knife", "Fork", "Pan", "Pot", "Toaster"
        };

        assertArrayEquals(expectedAppliances, supplies.getAppliances());
    }
}
