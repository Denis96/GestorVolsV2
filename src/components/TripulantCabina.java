package components;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TripulantCabina extends Tripulant {

	private int barres;

	/*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys dataAlta i barres.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar l'atribut dataAlta amb l'hora actual del sistema.
     - Inicialitzar l'atribut barres mitjançant el mètode pertinent d'aquesta classe.
	 */
	public TripulantCabina(String passaport, String nom, int edat, int horesVol, String rang) {
		super(passaport, nom, edat, horesVol, rang);
		assignarBarres(getRang());
	}


	/*
    Mètodes accessors
	 */
	public int getBarres() {
		return barres;
	}

	public void setBarres(int barres) {
		this.barres = barres;
	}

	public static TripulantCabina nouTripulantCabina() {
		String passaport, nom, rang;
		int edat, hores;

		System.out.println("\nPassaport del tripulant:");
		passaport = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nNom del tripulant:");
		nom = DADES.nextLine();
		System.out.println("\nEdat del tripulant:");
		edat = DADES.nextInt();

		System.out.println("\nHores de vol del tripulant:");
		hores = DADES.nextInt();

		System.out.println("\nQuin rang té el tripulant?: C-Comandant, CP-Copilot, EV-Enginyer de vol");
		rang = DADES.next();

		return new TripulantCabina(passaport, nom, edat, hores, rang);
	}

	public void modificarComponent() {
		super.modificarComponent();
		assignarBarres(getRang());
	}

	public void mostrarComponent() {
		super.mostrarComponent();
		System.out.println("\nBarres: " + barres);
	}

	public void assignarBarres(String pRang) {

		switch (pRang) {
			case "C":
				barres = 4;
				setRang("Comandant");
				break;
			case "CP":
				setRang("Copilot");
				if (getHoresVol() < 1500) {
					barres = 2;
				} else {
					barres = 3;
				}
				break;
			case "EV":
				setRang("Enginyer de vol");
				barres = 1;
				break;
			default:
				System.out.println("\nEl rang no és correcte");
				break;
		}

	}

}
