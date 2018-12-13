package components;

public class Avio implements Component {

	private String codi;
	private String fabricant;
	private String model;
	private int capacitat;
	private Classe[] classes;
	private int posicioClasses; //Atribut que controla la primera posició vuida del vector

	/// CONTRUCTOR ///
	public Avio(String codi, String fabricant, String model, int capacitat) {
		this.codi = codi;
		this.fabricant = fabricant;
		this.model = model;
		this.capacitat = capacitat;
		classes = new Classe[4];
		posicioClasses = 0;
	}

	/// GETTERS&SETTERS ///
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public String getFabricant() {
		return fabricant;
	}

	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacitat() {
		return capacitat;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	public Classe[] getClasses() {
		return classes;
	}

	public void setClasses(Classe[] classes) {
		this.classes = classes;
	}

	public int getPosicioClasses() {
		return posicioClasses;
	}

	public void setPosicioClasses(int posicioClasses) {
		this.posicioClasses = posicioClasses;
	}

	/// METODES ///
	public static Avio nouAvio() {
		String codi, fabricant, model;
		int capacitat;

		System.out.println("\nCodi de l'avió:");
		codi = DADES.next();
		DADES.nextLine(); //Neteja de buffer
		System.out.println("\nFabricant de l'avió:");
		fabricant = DADES.nextLine();
		System.out.println("\nModel de l'avió:");
		model = DADES.nextLine();
		System.out.println("\nCapacitat de l'avió:");
		capacitat = DADES.nextInt();

		return new Avio(codi, fabricant, model, capacitat);
	}

	public void modificarComponent() {

		System.out.println("\nEl codi de l'avió és: " + codi);
		codi = (String) demanarDades("\nQuin és el nou Codi de l'avió?", 2);
		DADES.nextLine(); //Neteja de buffer

		System.out.println("\nEl fabricant de l'avió és: " + fabricant);
		fabricant = (String) demanarDades("\nQuin és el nou fabricant de l'avió?", 4);

		System.out.println("\nEl model de l'avió és: " + model);
		model = (String) demanarDades("\nQuin és el nou model de l'avió?", 4);

		System.out.println("\nLa capacitat de l'avió és: " + capacitat);
		capacitat = (int) demanarDades("\nQuina és la nova capacitat de l'avió?", 1);

	}

	public void mostrarComponent() {
		System.out.println("\nLes dades de l'avió amb codi " + codi + " són:");
		System.out.println("\nFabricant: " + fabricant);
		System.out.println("\nModel: " + model);
		System.out.println("\nCapacitat: " + capacitat);
	}

	public void afegirClasse() {

		int capacitatClasses = 0;

		Classe classe = Classe.novaClasse();

		if (seleccionarClasse(classe.getNom()) == -1) { //La classe no existeix

			for (int i = 0; i < posicioClasses; i++) {
				capacitatClasses += classes[i].getCapacitat();
			}

			if (capacitatClasses + classe.getCapacitat() <= capacitat) {
				classes[posicioClasses] = classe;
			}

			posicioClasses++;

		} else if (seleccionarClasse(classe.getNom()) != -1 || capacitatClasses + classe.getCapacitat() > capacitat) {
			System.out.println("\nLa classe no s'ha pogut afegir");
		}

	}

	public int seleccionarClasse(String nom) {

		boolean trobat = false;
		int pos = -1;

		for (int i = 0; i < posicioClasses && !trobat; i++) {
			if (classes[i].getNom().equals(nom)) {
				pos = i;
				trobat = true;
			}
		}

		return pos;
	}

}
