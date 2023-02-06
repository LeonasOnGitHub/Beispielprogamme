package getraenkeautomat;

/**
 * Kaffee, ein mögliches Getränk aus einem Getränkeautomaten
 */
public class Kaffee extends AutomatenGetraenk
{
    /**
     * Kaffe durch den Filter laufen lassen
     */
	protected void aufgiessen()
    {
        System.out.println("Wasser durch Kaffeefilter laufen lassen");
    }

    /**
     * es werden Milch und Zucker zum Kaffee hinzugefügt
     */
    protected void zutatHinzufuegen()
    {
        System.out.println("Milch und Zucker dazu");
    }
}
