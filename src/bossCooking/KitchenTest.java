package bossCooking;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests the Kitchen class, verifying that checkValidRecipe(String[] chefSupplies) correctly
 * determines whether a given chefSupplies array matches a predefined recipe in cookBook, and
 * that it behaves correctly for the valid and invalid cases described in the specification.
 */
public class KitchenTest {

    /** The Kitchen instance under test. */
    private Kitchen kitchen;

    /** Used to look up recipe names from the index returned by checkValidRecipe(). */
    private RecipeBank recipeBank;

    /**
     * Creates a new Kitchen and RecipeBank before each test so that every test runs against
     * fresh, unmodified instances.
     */
    @Before
    public void setUp() {
        kitchen = new Kitchen();
        recipeBank = new RecipeBank();
    }

    /**
     * Tests that a correctly constructed chefSupplies array, matching a predefined recipe
     * exactly, is recognized as a valid recipe and returns that recipe's cookBook index.
     */
    @Test
    public void checkValidRecipeValidMatchTest() {
        String[] chefSupplies = {"Bread", "Jam", "Knife"};

        assertEquals(0, kitchen.checkValidRecipe(chefSupplies));
    }

    /**
     * Tests that the order of elements in chefSupplies does not affect whether a recipe
     * matches, since Kitchen compares chefSupplies to cookBook without paying attention to
     * order.
     */
    @Test
    public void checkValidRecipeOrderIndependentTest() {
        // Same items as the Jam Sandwich recipe, entered in a different order.
        String[] chefSupplies = {"Knife", "Jam", "Bread"};

        assertEquals(0, kitchen.checkValidRecipe(chefSupplies));
    }

    /**
     * Tests that a combination of ingredients/appliances that does not correspond to any
     * predefined recipe in cookBook is considered invalid and returns -1.
     */
    @Test
    public void checkValidRecipeNoMatchTest() {
        String[] chefSupplies = {"Egg", "Cheese", "Fork"};

        assertEquals(-1, kitchen.checkValidRecipe(chefSupplies));
    }

    /**
     * Tests that chefSupplies is considered an invalid recipe when it is missing a required
     * ingredient or appliance from an otherwise matching recipe.
     */
    @Test
    public void checkValidRecipeMissingItemTest() {
        // Missing the Knife that the Jam Sandwich recipe requires.
        String[] chefSupplies = {"Bread", "Jam"};

        assertEquals(-1, kitchen.checkValidRecipe(chefSupplies));
    }

    /**
     * Tests that chefSupplies is considered an invalid recipe when it contains an extra
     * ingredient or appliance beyond what an otherwise matching recipe requires.
     */
    @Test
    public void checkValidRecipeExtraItemTest() {
        // Contains every item the Jam Sandwich recipe requires, plus an extra Egg.
        String[] chefSupplies = {"Bread", "Jam", "Knife", "Egg"};

        assertEquals(-1, kitchen.checkValidRecipe(chefSupplies));
    }

    /**
     * Tests that if chefSupplies contains a duplicate ingredient or appliance, the recipe is
     * considered invalid and checkValidRecipe() returns -1, even when chefSupplies is the
     * same length as a predefined recipe.
     */
    @Test
    public void checkValidRecipeDuplicateItemTest() {
        // Same length as the Ham and Cheese Sandwich recipe, but Bread is duplicated in
        // place of Ham, which should be caught as an invalid combination.
        String[] chefSupplies = {"Bread", "Bread", "Cheese", "Knife"};

        assertEquals(-1, kitchen.checkValidRecipe(chefSupplies));
    }

    /**
     * Tests that multiple different valid chefSupplies combinations each return the correct
     * cookBook index for their matching recipe.
     */
    @Test
    public void checkValidRecipeCorrectIndexTest() {
        String[] jamSandwich = {"Bread", "Jam", "Knife"};
        String[] hamAndCheeseSandwich = {"Bread", "Ham", "Cheese", "Knife"};
        String[] friedEggOnToast = {"Egg", "Bread", "Butter", "Pan"};
        String[] clubSandwich = {"Bread", "Lettuce", "Tomato", "Ham", "Knife"};

        assertEquals(0, kitchen.checkValidRecipe(jamSandwich));
        assertEquals(1, kitchen.checkValidRecipe(hamAndCheeseSandwich));
        assertEquals(2, kitchen.checkValidRecipe(friedEggOnToast));
        assertEquals(3, kitchen.checkValidRecipe(clubSandwich));
    }

    /**
     * Tests that the recipe index returned by checkValidRecipe() corresponds to the correct
     * recipe name when passed into RecipeBank.getRecipeName(int index).
     */
    @Test
    public void checkValidRecipeIndexMatchesRecipeNameTest() {
        String[] chefSupplies = {"Egg", "Bread", "Butter", "Pan"};

        int recipeIndex = kitchen.checkValidRecipe(chefSupplies);

        assertEquals("Fried Egg on Toast", recipeBank.getRecipeName(recipeIndex));
    }
}