package automat;

/**
 * Ein Fach, das eine Dose Cola enthält
 * @author Doro
 *
 */
public class MeinFach implements Fach {

	@Override
	public boolean isVoll() {
		return true;
	}

	@Override
	public int getPreis() {
		return 42;
	}

	@Override
	public void auswerfen() {
		System.out.println("total schwierige Steuerung eines realen Faches");

	}

}
