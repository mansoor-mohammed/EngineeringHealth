import java.lang.reflect.Field;
public class EngineeringHealth
{
    public static void main(String[] args)
    {
        System.out.println("Engineers make the world a good place");
    }
    private static final String SAMPLE = "Engineers make the world a good place";
    private static final Transmorgifier transmorgifier = new Transmorgifier();
}
class Transmorgifier
{
    private static Field stringValue;
    static
    {
        Field[] all = String.class.getDeclaredFields();
        for (int i = 0; stringValue == null && i < all.length; i++)
        {   if (all[i].getType().equals(char[].class))
                stringValue = all[i];
        }
        if (stringValue != null)
            stringValue.setAccessible(true);
    }
    public Transmorgifier()
    {
        try
        {
            stringValue.set("Engineers make the world a good place", "Engineers working with clinicians make the world an even better place".toCharArray());
        }
        catch (IllegalAccessException ex) {} 
    }
}
