package components;

public class RutaTransoceanica extends RutaIntercontinental {

	private String ocea;

	/// CONTRUCTOR ///
	public RutaTransoceanica(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, String continentOri, String continentDes, String ocea, double distancia) {
		super(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, distancia);
		this.ocea = ocea;
	}

	/// GETTERS&SETTERS ///
	public String getOcea() {
		return ocea;
	}
	public void setOcea(String ocea) {
		this.ocea = ocea;
	}

	/// METODES ///
	public static RutaTransoceanica novaRutaTransoceanica() {

		String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, ocea;
		double distancia;

		System.out.println("\nCodi de la ruta transoceànica:");
		codi = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nAeroport d'origen de la ruta transoceànica:");
		aeroportOri = DADES.nextLine();
		System.out.println("\nAeroport de destí de la ruta transoceànica:");
		aeroportDes = DADES.nextLine();
		System.out.println("\nPaís d'origen de la ruta transoceànica:");
		paisOri = DADES.nextLine();
		System.out.println("\nPaís de destí de la ruta transoceànica:");
		paisDes = DADES.nextLine();
		System.out.println("\nContinent d'origen de la ruta transoceànica:");
		continentOri = DADES.nextLine();
		System.out.println("\nContinent de destí de la ruta transoceànica:");
		continentDes = DADES.nextLine();
		System.out.println("\nOceà que sobrevola la ruta transoceànica:");
		ocea = DADES.nextLine();
		System.out.println("\nDistància de la ruta transoceànica:");
		distancia = DADES.nextDouble();

		return new RutaTransoceanica(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, ocea, distancia);
	}

	public void modificarComponent() {
		super.modificarComponent();

		System.out.println("\nL'oceà que sobrevola la ruta transoceànica és:" + ocea);
		ocea = (String) demanarDades("\nQuin és el nou oceà que sobrevola la ruta transoceànica?", 4);

	}

	public void mostrarComponent() {
		super.mostrarComponent();
		System.out.println("\nOceà que sobrevola: " + ocea);
	}
}
