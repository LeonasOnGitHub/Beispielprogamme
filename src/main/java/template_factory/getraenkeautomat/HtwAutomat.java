package getraenkeautomat;

/**
 * stellt einen einfachen Getränkeautomaten dar
 */
public class HtwAutomat extends Automat{
	
	public AutomatenGetraenk erzeugen(int auswahl)
	{
		AutomatenGetraenk g = null;
		switch (auswahl)
		{
		case 1:
				g = new Kaffee();				
			    break;
		case 2:
				g = new Tee();
			    break;
		case 3: g = new Kakao();
			    break;
		default: System.out.println("Dann eben nix zu trinken...");
		}
		return g;
	}

	@Override
	public String textErzeugen() {
		return "1: Kaffee, 2: Tee, 3: Kakao";
	}

}
