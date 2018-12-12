/*
 * Classe que defineix una companyia. Una companyia es defineix per un codi i un 
 * nom. A més, contindrà vectors amb avions, rutes nacionals, rutes internacionals,
 * rutes intercontinentals, rutes transocèaniques, tripulants de cabina, TCPs i vols.
 */
package principal;

import components.Avio;
import components.Component;
import components.Ruta;
import components.RutaNacional;
import components.RutaInternacional;
import components.RutaIntercontinental;
import components.RutaTransoceanica;
import components.Tripulant;
import components.TCP;
import components.TripulantCabina;
import java.text.ParseException;

public class Companyia implements Component {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private Component[] components;
    private int posicioComponents; //Possició actual buida del vector

    ///// CONSTRUCTOR /////
    public Companyia(String nom) {
        codi = properCodi;
        properCodi++;
        this.nom = nom;
        components = new Component[2945];
        posicioComponents = 0;
    }

	///// GETTERS /////
	public int getCodi() {
		return codi;
	}
	public static int getProperCodi() {
		return properCodi;
	}
	public String getNom() {
		return nom;
	}
	public Component[] getComponents() {
		return components;
	}
	public int getPosicioComponents() {
		return posicioComponents;
	}
	///// SETTERS /////
	public void setCodi(int codi) {
		this.codi = codi;
	}
	public static void setProperCodi(int aProperCodi) {
		properCodi = aProperCodi;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setComponents(Component[] components) {
		this.components = components;
	}
	public void setPosicioComponents(int posicioComponents) {
		this.posicioComponents = posicioComponents;
	}
	
	///// METODES /////
    public static Companyia novaCompanyia() {

        System.out.println("\nNom de la companyia:");
        return new Companyia(DADES.nextLine());

    }
	
    public void modificarComponent() {

        System.out.println("\nNom de la companyia: " + getNom());
        setNom((String) demanarDades("\nQuin és el nou nom de la companyia?", 4));

    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la companyia amb codi " + getCodi() + " són:");
        System.out.println("\nNom:" + getNom());
    }
	
    public int seleccionarComponent(int tipus, String id) {
		boolean trobat = false;
		int pos = -1;
		
		switch (tipus) {
			case 1:  // 1=Avio
				for (int i = 0; i < posicioComponents && !trobat; i++) {
					if (components[i] instanceof Avio) {
						
						id = (id==null) ? (String) demanarDades("\nQuin és el codi del avió?", 2) : id;
						
						if ( ((Avio) components[i]).getCodi().equals(id)) {
							pos = i;
							trobat = true;
						}
					}
				}
				break;
			case 2:  // 2=Ruta
				for (int i = 0; i < posicioComponents && !trobat; i++) {
					if (components[i] instanceof Ruta) {
						
						id = (id==null) ? (String) demanarDades("\nQuin és el codi de la ruta?", 2) : id;
						
						if ( ((Ruta) components[i]).getCodi().equals(id)) {
							pos = i;
							trobat = true;
						}
					}
				}
				break;
			case 3:  // 3=Tripulant
				for (int i = 0; i < posicioComponents && !trobat; i++) {
					if (components[i] instanceof Tripulant) {
						
						id = (id==null) ? (String) demanarDades("\nQuin és el passaport del tripulant?", 2) : id;
						
						if ( ((Tripulant) components[i]).getPassaport().equals(id)) {
							pos = i;
							trobat = true;
						}
					}
				}
				break;
			case 4:  // 4=Vol
				for (int i = 0; i < posicioComponents && !trobat; i++) {
					if (components[i] instanceof Vol) {
						
						id = (id==null) ? (String) demanarDades("\nQuin és el codi del vol?", 2) : id;
						
						if ( ((Vol) components[i]).getCodi().equals(id)) {
							pos = i;
							trobat = true;
						}
					}
				}
				break;
		}
        return pos;
    }
	
	public void afegirAvio() {
		Avio temp = Avio.nouAvio();
		if (-1 == seleccionarComponent(1, temp.getCodi())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquest avió ja existeix.");
		}
	}
	
	public void afegirRutaNacional() {
		RutaNacional temp = RutaNacional.novaRutaNacional();
		if (-1 == seleccionarComponent(2, temp.getCodi())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquesta ruta nacional ja existeix.");
		}
	}
	public void afegirRutaInternacional() {
		RutaInternacional temp = RutaInternacional.novaRutaInternacional();
		if (-1 == seleccionarComponent(2, temp.getCodi())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquesta ruta internacional ja existeix.");
		}
	}
	public void afegirRutaIntercontinental() {
		RutaIntercontinental temp = RutaIntercontinental.novaRutaIntercontinental();
		if (-1 == seleccionarComponent(2, temp.getCodi())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquesta ruta intercontinental ja existeix.");
		}
	}
	public void afegirRutaTransoceanica() {
		RutaTransoceanica temp = RutaTransoceanica.novaRutaTransoceanica();
		if (-1 == seleccionarComponent(2, temp.getCodi())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquesta ruta transoceanica ja existeix.");
		}
	}
	
	public void afegirTCP() {
		TCP temp = TCP.nouTCP();
		if (-1 == seleccionarComponent(3, temp.getPassaport())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquest TCP ja existeix.");
		}
	}
	public void afegirTripulantCabina() {
		TripulantCabina temp = TripulantCabina.nouTripulantCabina();
		if (-1 == seleccionarComponent(3, temp.getPassaport())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquest tripulant de cabina ja existeix.");
		}
	}
	
	public void afegirVol() throws ParseException {
		Vol temp = Vol.nouVol();
		if (-1 == seleccionarComponent(4, temp.getCodi())) {
			components[posicioComponents] = temp;
			posicioComponents++;
		} else {
			System.out.print("\nAquest vol ja existeix.");
		}
	}

    public void afegirTripulantVol(int tipus) {
        Vol volSel;
        int pos = seleccionarComponent(4, null); // vol
		switch (tipus) {
			case 6: // 6=TripulantCabina
				if (pos >= 0) {
					volSel = (Vol) getComponents()[pos];

					pos = seleccionarComponent(3, null); // tripulant

					if (pos >= 0) {
						volSel.afegirTripulant( (Tripulant) getComponents()[pos]);
					} else {
						System.out.println("\nNo existeix aquest tripulant de cabina.");
					}
				} else {
					System.out.println("\nNo existeix aquest vol.");
				}
				break;
			case 7:  // 7=TCP
				if (pos >= 0) {
					volSel = (Vol) getComponents()[pos];

					pos = seleccionarComponent(3, null); // tripulant

					if (pos >= 0) {
						volSel.afegirTripulant( (TCP) getComponents()[pos]);
					} else {
						System.out.println("\nNo existeix aquest TCP.");
					}
				} else {
					System.out.println("\nNo existeix aquest vol.");
				}
				break;
		}
    }
	
	
    public void afegirRutaVol(int tipus) {
        Vol volSel;
        int pos = seleccionarComponent(4, null); // vol

        if (pos >= 0) {

            volSel = (Vol) getComponents()[pos];

            switch (tipus) { //////////////////////////////////////////////////////
                case 2: // 2=RutaNaciona
                    pos = seleccionarComponent(2, null); 
                    if (pos >= 0) {
                        volSel.setRuta(getRutesNacionals()[pos]);
                    }
                    break;
                case 3: // 3=RutaInternacional
                    pos = seleccionarRutaInternacional();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesInternacionals()[pos]);
                    }
                    break;
                case 4: // 4=RutaIntercontinenta
                    pos = seleccionarRutaIntercontinental();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesIntercontinentals()[pos]);
                    }
                    break;
                case 5: // 5=RutaTransoceanica
                    pos = seleccionarRutaTransoceanica();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesTransoceaniques()[pos]);
                    }
                    break;
            }

            if (pos < 0) {
                System.out.println("\nNo existeix aquesta ruta");
            } else{                
                volSel.setTipusRuta(tipus);
            }
            
        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    public void afegirAvioVol() {
        Vol volSel;
        int pos = seleccionarVol();

        if (pos >= 0) {

            volSel = getVols()[pos];

            pos = seleccionarAvio();

            if (pos >= 0) {
                volSel.setAvio(getAvions()[pos]);
            } else {
                System.out.println("\nNo existeix aquest avió");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }
}
