package verschiedenes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bankprojekt.verarbeitung.Girokonto;
import bankprojekt.verarbeitung.Konto;
import bankprojekt.verarbeitung.Kunde;

/**
 * probiert Lambda-Ausdrücke und Streams aus
 * @author Doro
 *
 */
public class LambdaUndStreams { 
	
	/**
	 * gibt die übergebene Liste l auf der Konsole aus
	 * @param liste
	 */
	public static void listeAusgeben(List<Kunde> liste)
	{
		Stream<Kunde> s1 = liste.stream();
		Stream<String> s2 = s1.map(kunde -> kunde.toString());
		s2.forEach(text -> System.out.println(text));
		
/*		for(Kunde k: l)
		{
			System.out.println(k.toString());
		}
*/
	}

	/**
	 * gibt die übergebene Liste l auf der Konsole aus
	 * @param l
	 * @param formatierung Umwandlungsfunktion von Kunde in einen String
	 */
	public static void listeAusgeben(List<Kunde> l, Umwandlung formatierung)
	{
		for(Kunde k: l)
		{
			System.out.println(formatierung.umwandeln(k));
		}
	}


	/**
	 * spielt mit Lambda-Ausdrücken und Streams herum
	 * @param args wird nicht benutzt
	 */
	public static void main(String[] args) {

		
		
		Kunde hans = new Kunde("Hans", "Meier", "Unterm Regenbogen 19",LocalDate.of(1992, 1, 5));
		Kunde otto = new Kunde("Otto", "Kar", "Hoch über den Wolken 7",LocalDate.of(1990, 2, 25));
		Kunde sabrina = new Kunde("Sabrina", "August", "Im Wald 15",LocalDate.of(1988, 3, 21));
		
		TreeSet<Kunde> kundenliste = new TreeSet<Kunde>();
		kundenliste.add(hans);
		kundenliste.add(otto);
		kundenliste.add(sabrina);
		
		System.out.println("automatisch sortiert: ");
		LinkedList<Kunde> liste1 = new LinkedList<Kunde>(kundenliste);
		Umwandlung u = kunde -> kunde.getName();
		listeAusgeben(liste1, u);
		System.out.println("-------");
		
		System.out.println("Nach Adresse sortiert: ");
		LinkedList<Kunde> liste2 = new LinkedList<Kunde>(kundenliste);
		Comparator<Kunde> vergleicher2 = 
			(Kunde a, Kunde b) -> 
			{
				return a.getAdresse().compareTo(b.getAdresse());
			};
		Collections.sort(liste2, vergleicher2);
		listeAusgeben(liste2);
		System.out.println("-------");
		
		System.out.println("Nach Geburtstag sortiert: ");
		LinkedList<Kunde> liste3 = new LinkedList<Kunde>(kundenliste);
		Comparator<Kunde> vergleicher3 = 
				(a, b) -> a.getGeburtstag().compareTo(b.getGeburtstag());
		Collections.sort(liste3, vergleicher3);
		listeAusgeben(liste3);
		System.out.println("-------");
		
		Konto eins = new Girokonto(hans, 1, 0);
		eins.einzahlen(100);
		Konto zwei = new Girokonto(otto, 2, 0);
		zwei.einzahlen(200);
		Konto drei = new Girokonto(sabrina, 3, 0);
		drei.einzahlen(100);
		
		Map<Long, Konto> kontenliste = new HashMap<Long, Konto>();
		kontenliste.put(1L, eins);
		kontenliste.put(2L, zwei);
		kontenliste.put(3L, drei);
		
		// Gesamtbetrag berechnen:
		double gesamt = 0.0;
		for(Konto k: kontenliste.values())
			gesamt = gesamt + k.getKontostand();
		System.out.println("Gesamtbetrag auf allen Konten: " + gesamt);
		
		gesamt = kontenliste.values().stream()
		.map(konto -> konto.getKontostand())
		.reduce(0.0, (zahl1, zahl2) -> zahl1 + zahl2);
		System.out.println("Gesamtbetrag auf allen Konten mit Streams: " + gesamt);


		gesamt = kontenliste.values().stream()
				.mapToDouble(Konto::getKontostand)
				.sum();
		
		gesamt = kontenliste.values().parallelStream()
				.reduce(0.0, (ges, konto) -> ges + konto.getKontostand(),
							(a, b) -> a + b);

		List<Konto> sortiert; // = new ArrayList<>();
// Niemals! Der Lambda-Ausdruck ist nicht stateless!
/*		kontenliste.values().stream()
					.sorted((konto1, konto2) -> 
						Double.compare(konto1.getKontostand(), konto2.getKontostand()))
					.forEach(konto -> sortiert.add(konto));
*/
		
		sortiert = kontenliste.values().stream()
		.sorted((konto1, konto2) -> 
			Double.compare(konto1.getKontostand(), konto2.getKontostand()))
		.collect(Collectors.toList());
	}

	/**
	 * gibt die übergebene Liste l auf der Konsole aus
	 * @param l
	 * @param formatierung Umwandlungsfunktion von Kunde in einen String
	 */
	public static void listeAusgeben(List<Kunde> l, 
			Function<Kunde, String> formatierung)
	{
		l.stream()
		.map(formatierung)
		.forEach(text -> System.out.println(text));
	}

}


