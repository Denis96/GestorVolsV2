package components;

public class RutaInternacional extends Ruta {

	private String paisOri;
	private String paisDes;

	/// CONTRUCTOR ///
	public RutaInternacional(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, double distancia) {
		super(codi, aeroportOri, aeroportDes, distancia);

		this.paisOri = paisOri;
		this.paisDes = paisDes;
	}


	/// GETTERS ///
	public String getPaisOri() {
		return paisOri;
	}

	public String getPaisDes() {
		return paisDes;
	}

	/// SETTERS ///
	public void setPaisOri(String paisOri) {
		this.paisOri = paisOri;
	}

	public void setPaisDes(String paisDes) {
		this.paisDes = paisDes;
	}

	/// METODES ///
	public static RutaInternacional novaRutaInternacional() {

		String codi, aeroportOri, aeroportDes, paisOri, paisDes; //, continentOri, continentDes;
		double distancia;

		System.out.println("\nCodi de la ruta internacional:");
		codi = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nAeroport d'origen de la ruta internacional:");
		aeroportOri = DADES.nextLine();
		System.out.println("\nAeroport de destí de la ruta internacional:");
		aeroportDes = DADES.nextLine();
		System.out.println("\nPaís d'origen de la ruta internacional:");
		paisOri = DADES.nextLine();
		System.out.println("\nPaís de destí de la ruta internacional:");
		paisDes = DADES.nextLine();
		System.out.println("\nDistància de la ruta internacional:");
		distancia = DADES.nextDouble();

		return new RutaInternacional(codi, aeroportOri, aeroportDes, paisOri, paisDes, distancia);
	}

	public void modificarComponent() {
		super.modificarComponent();

		System.out.println("\nEl país d'origen de la ruta internacional és:" + paisOri);
		paisOri = (String) demanarDades("\nQuin és el nou país d'origen de la ruta internacional?", 4);

		System.out.println("\nEl país de destí de la ruta internacional és:" + paisDes);
		paisDes = (String) demanarDades("\nQuin és el nou país de destí de la ruta internacional?", 4);

	}

	public void mostrarComponent() {
		super.mostrarComponent();
		System.out.println("\nPaís d'origen: " + paisOri);
		System.out.println("\nPaís de destí: " + paisDes);
	}
}
