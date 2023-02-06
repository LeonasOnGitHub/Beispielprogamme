package getraenkeautomatMitFactoryMethod;

/**
 * weißer Kakao mit echter Vollmilch
 * @author Doro
 *
 */
public class WeisserKakao extends AutomatenGetraenk {
	public void aufgiessen()
	{
		System.out.println("Weißes Edel-Schokoladenpulver langsam rein in Vollmilch auflösen");
	}
	
    /**
     * Pistazie hinzufügen
     */
    public void zutatHinzufuegen()
    {
    	System.out.println("gemahlene Pistazien drüberstreuen");
    }
}
