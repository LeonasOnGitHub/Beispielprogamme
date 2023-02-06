package sortiererei;
/**
* ein Vergleicher für zwei Konten
*/
public class KontoVergleicher implements Vergleicher {

	@Override
	public int vergleichen(Object a, Object b) {
		if(a instanceof KontoEinfach && b instanceof KontoEinfach)
			//instanceof sollte nur verwendet werden, wenn es zwingend notwendig ist
			//leider haben wir noch keine Typparameter kennengelernt...
		{
			double standA = ((KontoEinfach) a).getKontostand();
			double standB = ((KontoEinfach) b).getKontostand();
			//Genauso: Auch ein Cast sollte vermieden werden.
			if(standA > standB) 
				return 1;
			else if(standA < standB) 
				return -1;
			else 
				return 0;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

}
