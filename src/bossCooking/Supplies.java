package bossCooking;
public class Supplies
{
    /**
     * The Supplies class is responsible for storing an array of all available ingredients and
     * all available appliances which can be accessed by the user.
     */
        /**
         * Ingredients will store all defined ingredients; the array is not changeable, meaning
         * no ingredients can be added or removed.
         */
        private String[] ingredients;

        /**
         * Appliances will store all defined appliances; the array is not changeable, meaning no
         * appliances can be added or removed. The same logic applies as with ingredients.
         */
        private String[] appliances;

        /**
         * Constructs a Supplies object with the predefined arrays of ingredients and appliances
         * that the chef (user) will be able to select from. The chef selects from these arrays,
         * but the arrays themselves are predefined and will not change.
         */
        public Supplies() {
            ingredients = new String[] {
                "Bread", "Jam", "Ham", "Cheese", "Egg", "Butter", "Lettuce", "Tomato"
            };

            appliances = new String[] {
                "Knife", "Fork", "Pan", "Pot", "Toaster"
            };
        }

        /**
         * Returns the ingredients array.
         *
         * @return the String[] array of all available ingredients that the chef may select from
         */
        public String[] getIngredients() {
            return ingredients;
        }

        /**
         * Returns the appliances array.
         *
         * @return the String[] array of all available appliances/tools that the chef may select
         *         from
         */
        public String[] getAppliances() {
            return appliances;
        }
    }