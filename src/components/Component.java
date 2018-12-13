package components;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Ismael
 */
public interface Component {

	Scanner DADES = new Scanner(System.in);

	public void mostrarComponent();

	public void modificarComponent() throws ParseException;

	public default Object demanarDades(String peticio, int tipus) {
		Object dada = null;
		System.out.println(peticio);
		switch (tipus) {
			case 1:
				dada = DADES.nextInt();
				break;
			case 2:
				dada = DADES.next();
				break;
			case 3:
				dada = DADES.nextDouble();
				break;
			case 4:
				dada = DADES.nextLine();
				break;
			default:
				dada = null;
		}
		return dada;
	}
;

}
