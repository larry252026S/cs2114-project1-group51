package bossCooking;
import java.util.ArrayList;
import java.util.Scanner;

    /**
     * The BossCooking class will be responsible for handling the user's input and will be the
     * main interface of the program containing what will be prompted to the user.
     */
    public class Bosscooking 
{

        /**
         * Stores supplies (ingredients and/or appliances) selected by the chef (user). An array
         * was chosen because the chef's collection of supplies will be passed to Kitchen for
         * comparison against cookBook, which stores all valid recipes.
         */
        private String[] chefSupplies;

        /**
         * Runs the main program. Displays the complete predefined arrays of available
         * ingredients and appliances, then prompts the user for a String which is checked
         * against the ingredients[] and appliances[] arrays in the Supplies class to make sure
         * that the String entered matches one of the ingredients or appliances. If it doesn't
         * match one of the ingredients or appliances, an error message is displayed and the user
         * is re-prompted. If it does match, that String is added to the chefSupplies array. To
         * finish entering data, if the user enters "end" or "stop", the chefSupplies array is
         * compared to the recipes within the RecipeBank to determine if a match is found. If a
         * match is found, the program displays "You have made the [...] recipe!". If not, the
         * program displays "You have not made a valid recipe."
         *
         * @param args command-line arguments (not used)
         */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Supplies supplies = new Supplies();

            // Displays the complete predefined ingredients and appliances arrays so the chef can
            // see all available options before beginning to build chefSupplies.
            System.out.println("Welcome to Boss Cooking!");
            System.out.println();
            System.out.println("Available Ingredients:");
            printArray(supplies.getIngredients());
            System.out.println();
            System.out.println("Available Appliances:");
            printArray(supplies.getAppliances());
            System.out.println();

            System.out.println("Enter ingredients/appliances one at a time.");
            System.out.println("Type \"end\" or \"stop\" when you are done.");

            // chefSupplies is built up one valid item at a time as the user enters input.
            // tempSupplies is used only as a scratch structure, since the number of items the
            // chef will select is not known in advance; it is converted into the chefSupplies
            // String[] once the chef finishes entering data.
            ArrayList<String> tempSupplies = new ArrayList<String>();
            boolean done = false;

            while (!done) {
                System.out.print("> ");
                String input = scanner.nextLine();

                // The third bad input (null/empty input) is caught here in BossCooking, since it
                // is a user error; the user is re-prompted.
                if (input == null || input.trim().isEmpty()) {
                    System.out.println("You did not enter anything. Please enter an ingredient, "
                            + "an appliance, or \"end\"/\"stop\" to finish.");
                    continue;
                }

                String trimmedInput = input.trim();

                if (trimmedInput.equalsIgnoreCase("end") || trimmedInput.equalsIgnoreCase("stop")) {
                    done = true;
                    continue;
                }

                // The first bad input (special characters) is caught here in BossCooking; the
                // user is re-prompted.
                if (!isValidInput(trimmedInput)) {
                    System.out.println("Your entry contains special characters, which are not "
                            + "allowed. Please re-enter a valid ingredient or appliance.");
                    continue;
                }

                // Confirms that the entered String matches one of the ingredients or appliances
                // in the Supplies class before adding it to chefSupplies.
                if (matchesSupply(trimmedInput, supplies.getIngredients())
                        || matchesSupply(trimmedInput, supplies.getAppliances())) {
                    tempSupplies.add(trimmedInput);
                } else {
                    System.out.println("\"" + trimmedInput + "\" is not a recognized ingredient "
                            + "or appliance. Please re-enter a valid ingredient or appliance.");
                }
            }

            Bosscooking bossCooking = new Bosscooking();
            bossCooking.chefSupplies = tempSupplies.toArray(new String[0]);

            // Calls Kitchen to check if the chefSupplies make a valid recipe.
            Kitchen kitchen = new Kitchen();
            int recipeIndex = kitchen.checkValidRecipe(bossCooking.chefSupplies);

            // Displays final results to the user (dish name if valid, or error message if not).
            if (recipeIndex != -1) {
                RecipeBank recipeBank = new RecipeBank();
                String recipeName = recipeBank.getRecipeName(recipeIndex);
                System.out.println("You have made the " + recipeName + " recipe!");
            } else {
                System.out.println("You have not made a valid recipe");
            }

            scanner.close();
        }

        /**
         * Returns chef's array of supplies.
         *
         * @return the String[] array of ingredients and/or appliances selected by the chef (user)
         */
        public String[] getChefSupplies() {
            return chefSupplies;
        }

        /**
         * Determines whether the given input matches one of the items in the given supply array,
         * ignoring case.
         *
         * @param input the String entered by the chef (user)
         * @param supplyArray the array of available ingredients or appliances to check against
         * @return true if input matches one of the items in supplyArray, false otherwise
         */
        private static boolean matchesSupply(String input, String[] supplyArray) {
            for (int i = 0; i < supplyArray.length; i++) {
                if (input.equalsIgnoreCase(supplyArray[i])) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Determines whether the given input contains any special characters (such as
         * ! @ # $ % ^ &amp; * ( ) ), which are treated as the first bad input described in the
         * specification. Letters, digits, and spaces are considered valid.
         *
         * @param input the String entered by the chef (user)
         * @return true if input contains no special characters, false otherwise
         */
        private static boolean isValidInput(String input) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!Character.isLetterOrDigit(c) && c != ' ') {
                    return false;
                }
            }
            return true;
        }

        /**
         * Prints each item in the given array on its own line. Used to display the complete
         * predefined arrays of available ingredients and appliances to the chef (user) before
         * chefSupplies is built.
         *
         * @param array the array of Strings to print
         */
        private static void printArray(String[] array) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("- " + array[i]);
            }
        }
}
