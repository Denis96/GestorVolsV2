/*
 * Una classe Aplicacio per interactuar amb l'usuari, que contengui les companyies 
 * i cridar a la resta de classes i mètodes mitjançant uns menús.
 */
package principal;

import components.Avio;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.TripulantCabina;
import java.text.ParseException;
import java.util.Scanner;

public class Aplicacio {

    private final static Scanner DADES = new Scanner(System.in);
    private static Companyia[] companyies = new Companyia[5];
    private static int posicioCompanyies = 0; //La propera posició buida del vector companyies
    private static Companyia companyiaActual = null; //Companyia seleccionada

    public static void main(String[] args) throws ParseException {
        menuPrincipal();
    }

    private static void menuPrincipal() throws ParseException {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de companyies");
            System.out.println("\n2. Gestió d'avions");
            System.out.println("\n3. Gestió de rutes nacionals");
            System.out.println("\n4. Gestió de rutes internacionals");
            System.out.println("\n5. Gestió de rutes intercontinentals");
            System.out.println("\n6. Gestió de rutes transoceàniques");
            System.out.println("\n7. Gestió de tripulants de cabina");
            System.out.println("\n8. Gestió de tripulants de cabina de passatgers");
            System.out.println("\n9. Gestió de vols");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuCompanyes();
                    break;
                case 2:
                    if (companyiaActual != null) {
                        menuComponents(1); // menu -> Avions
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 3:
                    if (companyiaActual != null) {
                        menuComponents(2); // menu -> RutesNacionals
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 4:
                    if (companyiaActual != null) {
                        menuComponents(3); // menu -> RutesInternacionals
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 5:
                    if (companyiaActual != null) {
                        menuComponents(4); // menu -> RutesIntercontinentals
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 6:
                    if (companyiaActual != null) {
                        menuComponents(5); // menu -> RutesTransoceaniques
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 7:
                    if (companyiaActual != null) {
                        menuComponents(6); // menu -> TripulantsCabina
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 8:
                    if (companyiaActual != null) {
                        menuComponents(7); // menu -> TCPs
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 9:
                    if (companyiaActual != null) {
                        menuComponents(8); // menu -> Vols
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuCompanyes() {
        int opcio = 0;

        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar companyes");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyies[posicioCompanyies] = Companyia.novaCompanyia();
                    posicioCompanyies++;
                    break;
                case 2:
                    pos = selectCompanyia();
                    if (pos >= 0) {
                        companyiaActual = companyies[pos];
                    } else {
                        System.out.println("\nNo existeix aquesta companyia");
                    }
                    break;
                case 3:
                    pos = selectCompanyia();
                    if (pos >= 0) {
                        companyies[pos].modificarComponent();
                    } else {
                        System.out.println("\nNo existeix aquesta companyia");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCompanyies; i++) {
                        companyies[i].mostrarComponent();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }
	
    public static void menuComponents(int tipus) throws ParseException {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
			if (tipus == 8) {
				System.out.println("\n4. Afegir avió");
				System.out.println("\n5. Afegir ruta");
				System.out.println("\n6. Afegir tripulant de cabina");
				System.out.println("\n7. Afegir tripulant de cabina de passatgers");
			}

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
					switch (tipus) {
						case 1:
							companyiaActual.afegirAvio();
							break;
						case 2:
							companyiaActual.afegirRutaNacional();
							break;
						case 3:
							companyiaActual.afegirRutaInternacional();
							break;
						case 4:
							companyiaActual.afegirRutaIntercontinental();
							break;
						case 5:
							companyiaActual.afegirRutaTransoceanica();
							break;
						case 6:
							companyiaActual.afegirTripulantCabina();
							break;
						case 7:
							companyiaActual.afegirTCP();
							break;
						case 8:
							companyiaActual.afegirVol();
							break;
					}
                    break;
                case 2:
					int pos;
					switch (tipus) {
						case 1:
							pos = companyiaActual.seleccionarComponent(1, null);
							if (pos >= 0) {
								companyiaActual.getComponents()[pos].modificarComponent();
							} else {
								System.out.println("\nNo existeix aquest avió.");
							}
							break;
						case 2:
						case 3:
						case 4:
						case 5:
							pos = companyiaActual.seleccionarComponent(2, null);
							if (pos >= 0) {
								companyiaActual.getComponents()[pos].modificarComponent();
							} else {
								System.out.println("\nNo existeix aquesta ruta.");
							}
							break;
						case 6:
						case 7:
							pos = companyiaActual.seleccionarComponent(3, null);
							if (pos >= 0) {
								companyiaActual.getComponents()[pos].modificarComponent();
							} else {
								System.out.println("\nNo existeix aquest tripulant.");
							}
							break;
						case 8:
							pos = companyiaActual.seleccionarComponent(8, null);
							if (pos >= 0) {
								companyiaActual.getComponents()[pos].modificarComponent();
							} else {
								System.out.println("\nNo existeix aquest vol.");
							}
							break;
					}
                    break;
                case 3:
					switch (tipus) {
						case 1:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof Avio) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 2:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof RutaNacional) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 3:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof RutaInternacional) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 4:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof RutaIntercontinental) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 5:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof RutaTransoceanica) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 6:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof TripulantCabina) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 7:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof TCP) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
						case 8:
							for (int i = 0; i < companyiaActual.getPosicioComponents() ; i++) {
								if (companyiaActual.getComponents()[i] instanceof Vol) {
									companyiaActual.getComponents()[i].mostrarComponent();
								}
							}
							break;
					}
                    break;
                case 4:
					if (tipus == 8) {
						companyiaActual.afegirAvioVol();
					} else {
						System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					}
                    break;
                case 5:
					if (tipus == 8) {
						int tipusRuta;
						System.out.println("\nQuin tipus de ruta vols afegir? (1:nacional, 2:internacional, 3:intercontinental, 4:transoceànica");
						tipusRuta = DADES.nextInt();
						if (tipusRuta >= 1 && tipusRuta >= 4) {
							companyiaActual.afegirRutaVol(tipusRuta);
						} else {
							System.out.println("\nEl tipus de ruta no és correcte");
						}
                    break;
					} else {
						System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					}
                case 6:
					if (tipus == 8) {
						companyiaActual.afegirTripulantVol(6);
					} else {
						System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					}
                    break;
                case 7:
					if (tipus == 8) {
						companyiaActual.afegirTripulantVol(7);
					} else {
						System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					}
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer selectCompanyia() {

        System.out.println("\nCodi de la companyia?:");
        int codi = DADES.nextInt();

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioCompanyies && !trobat; i++) {
            if (companyies[i].getCodi() == codi) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

}
