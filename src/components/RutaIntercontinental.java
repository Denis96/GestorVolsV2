package components;

public class RutaIntercontinental extends RutaInternacional {

	private String continentOri;
	private String continentDes;

	/// CONTRUCTOR ///
	public RutaIntercontinental(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, String continentOri, String continentDes, double distancia) {
		super(codi, aeroportOri, aeroportDes, paisOri, paisDes, distancia);

		this.continentOri = continentOri;
		this.continentDes = continentDes;
	}

	/// GETTERS ///
	public String getContinentOri() {
		return continentOri;
	}

	public String getContinentDes() {
		return continentDes;
	}

	/// SETTERS ///
	public void setContinentDes(String continentDes) {
		this.continentDes = continentDes;
	}

	public void setContinentOri(String continentOri) {
		this.continentOri = continentOri;
	}

	/// METODES ///
	public static RutaIntercontinental novaRutaIntercontinental() {

		String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes;
		double distancia;

		System.out.println("\nCodi de la ruta intercontinental:");
		codi = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nAeroport d'origen de la ruta intercontinental:");
		aeroportOri = DADES.nextLine();
		System.out.println("\nAeroport de destí de la ruta intercontinental:");
		aeroportDes = DADES.nextLine();
		System.out.println("\nPaís d'origen de la ruta intercontinental:");
		paisOri = DADES.nextLine();
		System.out.println("\nPaís de destí de la ruta intercontinental:");
		paisDes = DADES.nextLine();
		System.out.println("\nContinent d'origen de la ruta intercontinental:");
		continentOri = DADES.nextLine();
		System.out.println("\nContinent de destí de la ruta intercontinental:");
		continentDes = DADES.nextLine();
		System.out.println("\nDistància de la ruta intercontinental:");
		distancia = DADES.nextDouble();

		return new RutaIntercontinental(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, distancia);
	}

	public void modificarComponent() {
		super.modificarComponent();

		System.out.println("\nEl continent d'origen de la ruta intercontinental és:" + continentOri);
		continentOri = (String) demanarDades("\nQuin és el nou continent d'origen de la ruta intercontinental?", 4);

		System.out.println("\nEl continent de destí de la ruta intercontinental és:" + continentDes);
		continentDes = (String) demanarDades("\nQuin és el nou continent de destí de la ruta intercontinental?", 4);

	}

	public void mostrarComponent() {
		super.mostrarComponent();
		System.out.println("\nContinent d'origen: " + continentOri);
		System.out.println("\nContinent de destí: " + continentDes);
	}
}
