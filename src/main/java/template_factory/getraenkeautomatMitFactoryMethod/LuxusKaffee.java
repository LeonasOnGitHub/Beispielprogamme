package getraenkeautomatMitFactoryMethod;

/**
 * Kaffee, ein mögliches Getränk aus einem Getränkeautomaten
 */
public class LuxusKaffee extends AutomatenGetraenk
{
    public void aufgiessen()
    {
        System.out.println("kalkfreies Wasser durch Kaffeefilter laufen lassen");
    }

    public void zutatHinzufuegen()
    {
        System.out.println("Echte Kuh-Milch und Rohrzucker dazu");
    }
}
