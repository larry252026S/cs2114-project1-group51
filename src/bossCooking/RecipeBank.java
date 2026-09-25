package bossCooking;
    /**
     * The RecipeBank class will store a 2D array of all possible recipes and their respective
     * ingredients and an array of the names of those recipes.
     */
    public class RecipeBank 
{

        /**
         * CookBook is a 2D array because it stores multiple recipes, where each inner String[]
         * represents a recipe (ingredients plus one appliance). CookBook is predefined and will
         * not change.
         */
        private String[][] cookBook;

        /**
         * RecipeNames stores the name of the recipes. Since cookBook is a predefined 2D array,
         * we know the indices will not change. Thus, we are able to use the same recipe index
         * in cookBook to correspond to recipeNames and obtain the recipe name (which is a
         * String).
         */
        private String[] recipeNames;

        /**
         * Constructs a RecipeBank with the predefined cookBook of recipes and the corresponding
         * recipeNames. Both arrays are predefined and will not change, and the index of a recipe
         * in cookBook always corresponds to the same index in recipeNames.
         */
        public RecipeBank() {
            cookBook = new String[][] {
                {"Bread", "Jam", "Knife"},
                {"Bread", "Ham", "Cheese", "Knife"},
                {"Egg", "Bread", "Butter", "Pan"},
                {"Bread", "Lettuce", "Tomato", "Ham", "Knife"}
            };

            recipeNames = new String[] {
                "Jam Sandwich",
                "Ham and Cheese Sandwich",
                "Fried Egg on Toast",
                "Club Sandwich"
            };
        }

        /**
         * Returns the cookBook array which has all the recipes available.
         *
         * @return the String[][] array in which each inner array represents a recipe (a set of
         *         ingredients and one appliance)
         */
        public String[][] getCookBook() {
            return cookBook;
        }

        /**
         * Returns the name of the recipe from the recipeNames array which corresponds to the
         * index entered in the parameter.
         *
         * @param index the index of the recipe within cookBook (and correspondingly within
         *              recipeNames)
         * @return the name of the recipe located at the given index
         */
        public String getRecipeName(int index) {
            return recipeNames[index];
        }
}
