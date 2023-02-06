package getraenkeautomatMitFactoryMethod;

/**
 * Ganz besonders guter Tee
 * @author Doro
 *
 */
public class LuxusTee extends AutomatenGetraenk {

    /**
     * Tee ziehen lassen
     */
    public void aufgiessen()
    {
       System.out.println("Earl-Grey-Tee ziehen lassen");
    }

    /**
     * Zitrone hinzufügen
     */
    public void zutatHinzufuegen()
    {
    	System.out.println("Echte Zitrone dazu");
    }
}
