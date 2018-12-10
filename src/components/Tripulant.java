package components;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Tripulant implements Component{

    private String passaport;
    private String nom;
    private int edat;
    private Date dataAlta;
    private int horesVol;
    private String rang;

    ///// CONSTRUCTOR /////
	public Tripulant(String passaport, String nom, int edat, int horesVol, String rang) {
		this.passaport = passaport;
		this.nom = nom;
		this.edat = edat;
        dataAlta = new Date();
		this.horesVol = horesVol;
		this.rang = null;
	}

	///// GETTERS /////
	public String getPassaport() {
		return passaport;
	}
	public String getNom() {
		return nom;
	}
	public int getEdat() {
		return edat;
	}
	public Date getDataAlta() {
		return dataAlta;
	}
	public int getHoresVol() {
		return horesVol;
	}
	public String getRang() {
		return rang;
	}
	
	///// SETTERS /////
	public void setPassaport(String passaport) {
		this.passaport = passaport;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}
	public void setHoresVol(int horesVol) {
		this.horesVol = horesVol;
	}
	public void setRang(String rang) {
		this.rang = rang;
	}
	
    ///// METHODS /////
    public void modificarComponent() {

        System.out.println("\nEl passaport actual del tripulant és:" + passaport);
        passaport = (String) demanarDades("\nQuin és el nou codi de la ruta?", 2);
        DADES.nextLine(); //Neteja de buffer
		
        System.out.println("\nEl nom actual del tripulant és:" + nom);
        nom = (String) demanarDades("\nQuin és el nou nom del tripulant?", 4);
		
        System.out.println("\nL'edat actual del tripulant és:" + edat);
        edat = (int) demanarDades("\nQuina és la nova edat del tripulant?", 1);
		
        System.out.println("Les hores de vol actuals del tripulant són:" + horesVol);
        horesVol = (int) demanarDades("\nQuines són les hores de vol actuals del tripulant?", 1); 
    }

    public void mostrarComponent() { ////////////////////////////////////// comprobar esto
        System.out.println("\nLes dades del tripulant amb passaport " + passaport + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nEdat: " + edat);
        System.out.println("\nData d'alta: " + new SimpleDateFormat("dd-MM-yyyy").format(dataAlta));
        System.out.println("\nHores de vol: " + horesVol);
        System.out.println("\nRang: " + rang);
    }
	
	
}
