package components;

public class TCP extends Tripulant {

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys dataAlta rang.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar l'atribut dataAlta amb l'hora actual del sistema.
     - Inicialitzar l'atribut rang a null, ja que quan es crea un TCP, mai té rang.
     */
    public TCP(String passaport, String nom, int edat, int horesVol) {
        super(passaport,nom,edat,horesVol,null);
    }


    /*
    Mètodes accessors
     */


    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou tripulant de cabina.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom no té per què estar format per una única 
    paraula, per exemple, Pep Gómez.
    - També heu de tenir en compte que les hores de vol són de tipus LocalTime, per
    tant heu de demanar a l'usuari les hores i minuts per crear el LocalTime. En aquest
    cas es considerarà que els segons i nanosegons, sempre són  0.
     */
}
