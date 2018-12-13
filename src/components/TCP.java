package components;

public class TCP extends Tripulant {

	/// CONTRUCTOR ///
	public TCP(String passaport, String nom, int edat, int horesVol) {
		super(passaport, nom, edat, horesVol, null);
	}

	public static TCP nouTCP() {
		String passaport, nom;
		int edat, hores, minuts;

		System.out.println("\nPassaport del tripulant:");
		passaport = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nNom del tripulant:");
		nom = DADES.nextLine();
		System.out.println("\nEdat del tripulant:");
		edat = DADES.nextInt();

		System.out.println("\nHores de vol del tripulant:");
		hores = DADES.nextInt();

		return new TCP(passaport, nom, edat, hores);
	}
}
