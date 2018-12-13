package components;

public class RutaNacional extends Ruta {

	private String pais;

	/// CONTRUCTOR ///
	public RutaNacional(String codi, String pais, String aeroportOri, String aeroportDes, double distancia) {
		super(codi, aeroportOri, aeroportDes, distancia);
		this.pais = pais;
	}

	/// GETTERS&SETTERS ///
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	/// METODES ///
	public static RutaNacional novaRutaNacional() {
		String codi, aeroportOri, aeroportDes, pais;
		double distancia;

		System.out.println("\nCodi de la ruta nacional:");
		codi = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nAeroport d'origen de la ruta nacional:");
		aeroportOri = DADES.nextLine();
		System.out.println("\nAeroport de destí de la ruta nacional:");
		aeroportDes = DADES.nextLine();
		System.out.println("\nPaís de la ruta nacional:");
		pais = DADES.nextLine();
		System.out.println("\nDistància de la ruta nacional:");
		distancia = DADES.nextDouble();

		return new RutaNacional(codi, aeroportOri, aeroportDes, pais, distancia);

	}

	public void modificarComponent() {
		super.modificarComponent();

		System.out.println("\nEl país de la ruta nacional és:" + pais);
		pais = (String) demanarDades("\nQuin és el nou país de la ruta nacional?", 4);
	}

	public void mostrarComponent() {
		super.mostrarComponent();
		System.out.println("\nPaís: " + pais);
	}
}
