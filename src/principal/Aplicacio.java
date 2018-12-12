/*
 * Una classe Aplicacio per interactuar amb l'usuari, que contengui les companyies 
 * i cridar a la resta de classes i mètodes mitjançant uns menús.
 */
package principal;

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
                        menuAvions();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 3:
                    if (companyiaActual != null) {
                        menuRutesNacionals();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 4:
                    if (companyiaActual != null) {
                        menuRutesInternacionals();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 5:
                    if (companyiaActual != null) {
                        menuRutesIntercontinentals();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 6:
                    if (companyiaActual != null) {
                        menuRutesTransoceaniques();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 7:
                    if (companyiaActual != null) {
                        menuTripulantsCabina();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 8:
                    if (companyiaActual != null) {
                        menuTcps();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 9:
                    if (companyiaActual != null) {
                        menuVols();
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
                        companyies[pos].modificarCompanyia();
                    } else {
                        System.out.println("\nNo existeix aquesta companyia");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCompanyies; i++) {
                        companyies[i].mostrarCompanyia();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú avions amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un avió en la companyia actual. Penseu que Companyia sap crear avions.
     Opció 2. Modificar -->      Permet modificar un avio que ha d'existir en la companyia actual
     (per comprovar l'existència de l'avió, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar avions-->Imprimeix les dades dels avions de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuAvions() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar avions");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirAvio();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarAvio();
                    if (pos >= 0) {
                        companyiaActual.getAvions()[pos].modificarAvio();
                    } else {
                        System.out.println("\nNo existeix aquest avió");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioAvions(); i++) {
                        companyiaActual.getAvions()[i].mostrarAvio();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú de rutes nacionals amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una ruta nacional en la companyia actual. Penseu que Companyia sap crear rutes nacionals.
     Opció 2. Modificar -->      Permet modificar una ruta nacional que ha d'existir en la companyia actual
     (per comprovar l'existència de la ruta nacional, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar rutes nacionals-->Imprimeix les dades de les rutes nacionals de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuRutesNacionals() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar rutes nacionals");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirRutaNacional();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarRutaNacional();
                    if (pos >= 0) {
                        companyiaActual.getRutesNacionals()[pos].modificarRutaNacional();
                    } else {
                        System.out.println("\nNo existeix aquesta ruta nacional");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioRutesNacionals(); i++) {
                        companyiaActual.getRutesNacionals()[i].mostrarRutaNacional();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú de rutes internacionals amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una ruta internacional en la companyia actual. Penseu que Companyia sap crear rutes internacionals.
     Opció 2. Modificar -->      Permet modificar una ruta internacional que ha d'existir en la companyia actual
     (per comprovar l'existència de la ruta internacional, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar rutes internacionals-->Imprimeix les dades de les rutes internacionals de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuRutesInternacionals() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar rutes internacionals");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirRutaInternacional();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarRutaInternacional();
                    if (pos >= 0) {
                        companyiaActual.getRutesInternacionals()[pos].modificarRutaInternacional();
                    } else {
                        System.out.println("\nNo existeix aquesta ruta internacional");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioRutesInternacionals(); i++) {
                        companyiaActual.getRutesInternacionals()[i].mostrarRutaInternacional();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú de rutes intercontinentals amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una ruta intercontinental en la companyia actual. Penseu que Companyia sap crear rutes intercontinentals.
     Opció 2. Modificar -->      Permet modificar una ruta intercontinental que ha d'existir en la companyia actual
     (per comprovar l'existència de la ruta intercontinental, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar rutes intercontinentals-->Imprimeix les dades de les rutes intercontinentals de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuRutesIntercontinentals() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar rutes intercontinentals");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirRutaIntercontinental();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarRutaIntercontinental();
                    if (pos >= 0) {
                        companyiaActual.getRutesIntercontinentals()[pos].modificarRutaIntercontinental();
                    } else {
                        System.out.println("\nNo existeix aquesta ruta intercontinental");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioRutesIntercontinentals(); i++) {
                        companyiaActual.getRutesIntercontinentals()[i].mostrarRutaIntercontinental();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú de rutes transoceàniques amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una ruta transoceànica en la companyia actual. Penseu que Companyia sap crear rutes transoceàniques.
     Opció 2. Modificar -->      Permet modificar una ruta transoceànica que ha d'existir en la companyia actual
     (per comprovar l'existència de la ruta transoceànica, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar rutes transoceàniques-->Imprimeix les dades de les rutes transoceàniques de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuRutesTransoceaniques() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar rutes transoceàniques");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirRutaTransoceanica();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarRutaTransoceanica();
                    if (pos >= 0) {
                        companyiaActual.getRutesTransoceaniques()[pos].modificarRutaTransoceanica();
                    } else {
                        System.out.println("\nNo existeix aquesta ruta transoceàniques");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioRutesTransoceaniques(); i++) {
                        companyiaActual.getRutesTransoceaniques()[i].mostrarRutaTransoceanica();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú de tripulants de cabina amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un tripulant de cabina en la companyia actual. Penseu que Companyia sap crear tripulants de cabina.
     Opció 2. Modificar -->      Permet modificar un tripulant de cabina que ha d'existir en la companyia actual
     (per comprovar l'existència del tripulant de cabina, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar tripulants de cabina-->Imprimeix les dades dels tripulants de cabina de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuTripulantsCabina() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar tripulants de cabina");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirTripulantCabina();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarTripulantCabina();
                    if (pos >= 0) {
                        companyiaActual.getTripulantsCabina()[pos].modificarTripulantCabina();
                    } else {
                        System.out.println("\nNo existeix aquest tripulant de cabina");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioTripulantsCabina(); i++) {
                        companyiaActual.getTripulantsCabina()[i].mostrarTripulantCabina();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú de TCPs amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut companyiaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un TCP en la companyia actual. Penseu que Companyia sap crear TCPs.
     Opció 2. Modificar -->      Permet modificar un TCP que ha d'existir en la companyia actual
     (per comprovar l'existència del TCP, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Llistar tripulants de cabina de passatgers-->Imprimeix les dades dels TCPs de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuTcps() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar tripulants de cabina de passatgers");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirTCP();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarTCP();
                    if (pos >= 0) {
                        companyiaActual.getTcps()[pos].modificarTCP();
                    } else {
                        System.out.println("\nNo existeix aquest tripulant de cabina de passatgers");
                    }
                    break;
                case 3:
                    for (int i = 0; i < companyiaActual.getPosicioTcps(); i++) {
                        companyiaActual.getTcps()[i].mostrarTCP();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menú vols amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat destiActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un vol en la companyia actual. Penseu que Companyia sap crear vols.
     Opció 2. Modificar -->      Permet modificar un vol que ha d'existir en la companyia actual
     (per comprovar l'existència del vol, a la classe Companyia tenim un mètode que ens ajuda)
     Opció 3. Afegir avió -->    Afegeix un avió a un vol, però penseu que Companyia sap fer-ho.
     Opció 4. Afegir ruta -->    Afegeix una ruta a un vol, però penseu que Companyia sap fer-ho. Abans
     d'afegir la ruta al vol, li haurem de demanar a l'usuari quin tipus de ruta vol afegir. En aquest
     cas l'usuari ha d'introduir 1 si vol afegir una ruta nacional, un 2 si vol afegir ruta internacional,
     un 3 si vol afegir una ruta intercontinental i un 4 si vol afegir una ruta transocenàica. Si l'opció
     introduida no és correcta, se li mostrarà a l'usuari el missatge "El tipus de ruta no és correcte"
     Opció 5. Afegir tripulan de cabina --> Afegeix un tripulant de cabina a un vol, però penseu que 
     Companyia sap fer-ho.
     Opció 6. Afegir tripulan de cabina de passatgers --> Afegeix un TCP a un vol, però penseu que 
     Companyia sap fer-ho.
     Opció 7. Llistar vols-->Imprimeix les dades dels vols de la companyia actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuVols() throws ParseException {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Afegir avió");
            System.out.println("\n4. Afegir ruta");
            System.out.println("\n5. Afegir tripulant de cabina");
            System.out.println("\n6. Afegir tripulant de cabina de passatgers");
            System.out.println("\n7. Llistar vols");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirVol();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarVol();
                    if (pos >= 0) {
                        companyiaActual.getVols()[pos].modificarVol();
                    } else {
                        System.out.println("\nNo existeix aquest vol");
                    }
                    break;
                case 3:
                    companyiaActual.afegirAvioVol();
                    break;
                case 4:
                    int tipus;
                    System.out.println("\nQuin tipus de ruta vols afegir? (1:nacional, 2:internacional, 3:intercontinental, 4:transoceànica");
                    tipus = DADES.nextInt();
                    if (tipus >= 1 && tipus >= 4) {
                        companyiaActual.afegirRutaVol(tipus);
                    } else {
                        System.out.println("\nEl tipus de ruta no és correcte");
                    }
                    break;
                case 5:
                    companyiaActual.afegirTripulantCabinaVol();
                    break;
                case 6:
                    companyiaActual.afegirTCPVol();
                    break;
                case 7:
                    for (int i = 0; i < companyiaActual.getPosicioVols(); i++) {
                        companyiaActual.getVols()[i].mostrarVol();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio!= 0);
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
