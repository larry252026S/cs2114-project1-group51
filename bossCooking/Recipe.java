import student.*;

public class Recipe
{
    // ~ Fields ................................................................

    private String name;
    // ~ Constructors ..........................................................
    /**
     * @param initName 
     */
    public Recipe(String initName)
    {
        name = initName;
    }


    // ~Public Methods ........................................................
    public String getName()
    {
        return name;
    }


    public void setName(String newName)
    {
        name = newName;
    }
}
