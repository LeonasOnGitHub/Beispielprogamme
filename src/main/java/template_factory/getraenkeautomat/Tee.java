package getraenkeautomat;

/**
 * Tee, ein mögliches Automatengetränk
 */
public class Tee extends AutomatenGetraenk{

    /**
     * Tee ziehen lassen
     */
    protected void aufgiessen()
    {
        System.out.println("Tee ziehen lassen" );
    }

    /**
     * Zitrone hinzufügen
     */
    protected void zutatHinzufuegen()
    {
        System.out.println("Zitrone dazu" );
    }
}
