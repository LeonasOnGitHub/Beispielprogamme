package getraenkeautomat;

/**
 * stellt eine Getränk dar, das in einem Getränkeautomaten angeboten werden kann
 */
public abstract class AutomatenGetraenk {
	
	/**
	 * kocht das Getränk
	 */
	public final void kochen()
	{
		System.out.println("Wasser kochen");
	    this.aufgiessen();
	    this.inTasseSchuetten();
	    this.zutatHinzufuegen();
	}
	
	/**
	 * tut ein Topping in/auf das Getränk
	 */
    protected void zutatHinzufuegen()
    {}


    /**
     * aus dem heißen Wasser das getränk machen
     */
	protected abstract void aufgiessen();


	/**
     * der fertige Getränk wird in eine Tasse gegossen
     */
    private void inTasseSchuetten()
    {
        System.out.println("eingiessen");
    }


}
