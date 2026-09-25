package bossCooking;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests the RecipeBank class, verifying that getCookBook() returns the predefined cookBook
 * of recipes and that getRecipeName(int index) returns the correct recipe name for a given
 * index.
 */
public class RecipeBankTest {

    /** The RecipeBank instance under test. */
    private RecipeBank recipeBank;

    /**
     * Creates a new RecipeBank object before each test so that every test runs against a
     * fresh, unmodified instance.
     */
    @Before
    public void setUp() {
        recipeBank = new RecipeBank();
    }

    /**
     * Tests whether getCookBook() correctly returns the cookbook associated with the
     * RecipeBank, comparing each recipe stored in cookBook to the expected predefined
     * recipe.
     */
    @Test
    public void getCookBookTest() {
        String[][] expectedCookBook = {
            {"Bread", "Jam", "Knife"},
            {"Bread", "Ham", "Cheese", "Knife"},
            {"Egg", "Bread", "Butter", "Pan"},
            {"Bread", "Lettuce", "Tomato", "Ham", "Knife"}
        };

        String[][] cookBook = recipeBank.getCookBook();

        assertEquals(expectedCookBook.length, cookBook.length);
        for (int i = 0; i < expectedCookBook.length; i++) {
            assertArrayEquals(expectedCookBook[i], cookBook[i]);
        }
    }

    /**
     * Tests whether getRecipeName() correctly returns the name of the recipe at the
     * specified index in the RecipeBank. Also tests that the method returns the correct
     * recipe name for different valid indexes.
     */
    @Test
    public void getRecipeNameTest() {
        assertEquals("Jam Sandwich", recipeBank.getRecipeName(0));
        assertEquals("Ham and Cheese Sandwich", recipeBank.getRecipeName(1));
        assertEquals("Fried Egg on Toast", recipeBank.getRecipeName(2));
        assertEquals("Club Sandwich", recipeBank.getRecipeName(3));
    }
}
