package sortiererei;
/**
 * Interface für den Vergleich zweier Objekte
 * @author Doro 
 *
 */
public interface Vergleicher {
	/**
	 * vergleicht a und b
	 * @param a zu vergleichendes Objekt
	 * @param b zu vergleichendes Objekt
	 * @return positiver Wert, wenn a größer als b, 
	 *         negativer Wert, wenn a kleiner als b
	 *         und 0, wenn a == b 
	 * @throws IllegalArgumentException , wenn a und b nicht verglichen werden können
	 */
	public int vergleichen(Object a, Object b);
	
	/**
	 * prüft, ob a > b
	 * @param a
	 * @param b
	 * @return a > b
	 * @throws IllegalArgumentException, wenn a und b nicht verglichen werden können
	 */
	public default boolean isGroesser(Object a, Object b) {
		return this.vergleichen(a, b) > 0;
	}
	
	/**
	 * prüft, ob a < b
	 * @param a
	 * @param b
	 * @return a < b
	 * @throws IllegalArgumentException, wenn a und b nicht verglichen werden können
	 */
	default public boolean isKleiner(Object a, Object b)
	{
		return this.vergleichen(a,  b) < 0;
	}
	
	/**
	 * prüft, ob a == b
	 * @param a
	 * @param b
	 * @return a == b
	 * @throws IllegalArgumentException, wenn a und b nicht verglichen werden können
	 */
	default public boolean isGleich(Object a, Object b)
	{
		return this.vergleichen(a,  b) == 0;
	}
}
