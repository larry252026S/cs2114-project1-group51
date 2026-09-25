package bossCooking;
public class Kitchen
{
    /**
     * The Kitchen class will compare the array created by the user to the recipes in the
     * RecipeBank class to determine whether the array created by the user matches a valid
     * recipe and if so, which one. Kitchen does not need any fields because it only compares
     * the recipes (a predefined recipe against chefSupplies).
     */
        /**
         * Accesses the cookBook array stored within the RecipeBank and compares the recipes
         * within it to the chefSupplies array. If chefSupplies contains two or more instances of
         * the same ingredient or appliance, the combination is considered an invalid
         * combination, and no further comparison is made. Otherwise, chefSupplies is compared to
         * each recipe in cookBook without paying attention to order.
         *
         * @param chefSupplies the array of ingredients and/or appliances selected by the chef
         *                     (user)
         * @return the index of the recipe within cookBook that matches chefSupplies, or -1 if no
         *         valid recipe is found (including the case where chefSupplies contains a
         *         duplicate ingredient or appliance)
         */
        public int checkValidRecipe(String[] chefSupplies) {
            // An invalid combination, such as adding two or more of the same ingredient, is
            // caught here, at the final comparison step. Duplicate items make chefSupplies
            // unable to match any recipe, regardless of what the duplicated item is.
            if (hasDuplicates(chefSupplies)) {
                return -1;
            }

            // Calls RecipeBank.getCookBook() to get all predefined recipes.
            RecipeBank recipeBank = new RecipeBank();
            String[][] cookBook = recipeBank.getCookBook();

            // Compares the chefSupplies to each recipe in cookBook (order does not matter) and
            // returns the index of the matching recipe if found.
            for (int i = 0; i < cookBook.length; i++) {
                if (matches(chefSupplies, cookBook[i])) {
                    return i;
                }
            }

            // Returns -1 if no valid recipe is found.
            return -1;
        }

        /**
         * Determines whether chefSupplies contains exactly the same items, in any order, as the
         * given recipe from cookBook.
         *
         * @param chefSupplies the array of ingredients and/or appliances selected by the chef
         *                     (user)
         * @param recipe one recipe (a String[] of ingredients and one appliance) from cookBook
         * @return true if chefSupplies and recipe contain exactly the same items regardless of
         *         order, false otherwise
         */
        private boolean matches(String[] chefSupplies, String[] recipe) {
            if (chefSupplies.length != recipe.length) {
                return false;
            }

            // Tracks which items in recipe have already been matched so that each item in
            // chefSupplies is paired with exactly one item in recipe, without regard to order.
            boolean[] used = new boolean[recipe.length];

            for (int i = 0; i < chefSupplies.length; i++) {
                boolean found = false;
                for (int j = 0; j < recipe.length; j++) {
                    if (!used[j] && chefSupplies[i].equalsIgnoreCase(recipe[j])) {
                        used[j] = true;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }

            return true;
        }

        /**
         * Determines whether chefSupplies contains two or more instances of the same ingredient
         * or appliance.
         *
         * @param chefSupplies the array of ingredients and/or appliances selected by the chef
         *                     (user)
         * @return true if any item appears more than once in chefSupplies, false otherwise
         */
        private boolean hasDuplicates(String[] chefSupplies) {
            for (int i = 0; i < chefSupplies.length; i++) {
                for (int j = i + 1; j < chefSupplies.length; j++) {
                    if (chefSupplies[i].equalsIgnoreCase(chefSupplies[j])) {
                        return true;
                    }
                }
            }
            return false;
        }
}
