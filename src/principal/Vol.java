package principal;

import components.Avio;
import components.Component;
import components.Ruta;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.Tripulant;
import components.TCP;
import components.TripulantCabina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Vol implements Component{

    private String codi;
    private Ruta ruta;
    private Avio avio;
	private TCP cap; //new
    private Tripulant[] tripulacio;
    private int posicioTripulacio;
    private Date dataSortida;
    private Date dataArribada;
    private LocalTime horaSortida;
    private LocalTime horaArribada;
    private String durada;

	/// CONTRUCTOR ///
    public Vol(String codi, Date dataSortida, Date dataArribada, LocalTime horaSortida, LocalTime horaArribada) {
        this.codi = codi;
        ruta = null;
        avio = null;
		cap = null; // new
        tripulacio = new Tripulant[32];
        posicioTripulacio = 0;
        this.dataSortida = dataSortida;
        this.dataArribada = dataArribada;
        this.horaSortida = horaSortida;
        this.horaArribada = horaArribada;
        calcularDurada();
    }

	/// GETTERS ///
	public String getCodi() {
		return codi;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public Avio getAvio() {
		return avio;
	}
	public TCP getCap() {
		return cap;
	}
	public Tripulant[] getTripulacio() {
		return tripulacio;
	}
	public int getPosicioTripulacio() {
		return posicioTripulacio;
	}
	public Date getDataSortida() {
		return dataSortida;
	}
	public Date getDataArribada() {
		return dataArribada;
	}
	public LocalTime getHoraSortida() {
		return horaSortida;
	}
	public LocalTime getHoraArribada() {
		return horaArribada;
	}
	public String getDurada() {
		return durada;
	}
	/// SETTERS ///
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public void setAvio(Avio avio) {
		this.avio = avio;
	}
	public void setCap(TCP cap) {
		this.cap = cap;
	}
	public void setTripulacio(Tripulant[] tripulacio) {
		this.tripulacio = tripulacio;
	}
	public void setPosicioTripulacio(int posicioTripulacio) {
		this.posicioTripulacio = posicioTripulacio;
	}
	public void setDataSortida(Date dataSortida) {
		this.dataSortida = dataSortida;
	}
	public void setDataArribada(Date dataArribada) {
		this.dataArribada = dataArribada;
	}
	public void setHoraSortida(LocalTime horaSortida) {
		this.horaSortida = horaSortida;
	}
	public void setHoraArribada(LocalTime horaArribada) {
		this.horaArribada = horaArribada;
	}
	public void setDurada(String durada) {
		this.durada = durada;
	}

	/// METODES ///
    public static Vol nouVol() throws ParseException {
        String codi;
        Date dataSortida, dataArribada;
        LocalTime horaSortida, horaArribada;
        int hora, minuts;

        System.out.println("\nCodi del vol?");
        codi = DADES.next();

        System.out.println("\nData de sortida del vol?: (dd-mm-yyyy)");
        dataSortida = new SimpleDateFormat("dd-MM-yyyy").parse(DADES.next());
        System.out.println("\nData d'arribada del vol?: (dd-mm-yyyy)");
        dataArribada = new SimpleDateFormat("dd-MM-yyyy").parse(DADES.next());

        System.out.println("\nA quina hora surt el vol?");
        hora = DADES.nextInt();
        System.out.println("\nA quins minuts de la hora surt el vol?");
        minuts = DADES.nextInt();
        horaSortida = LocalTime.of(hora, minuts, 0, 0);

        System.out.println("\nA quina hora arriba el vol?");
        hora = DADES.nextInt();
        System.out.println("\nA quins minuts de la hora arriba el vol?");
        minuts = DADES.nextInt();
        horaArribada = LocalTime.of(hora, minuts, 0, 0);

        return new Vol(codi, dataSortida, dataArribada, horaSortida, horaArribada);
    }

    public void modificarComponent() throws ParseException {
        int hora, minuts;

        System.out.println("\nEl codi del vol és: " + getCodi());
        setCodi((String) demanarDades("\nQuin és el nou codi del vol?", 2));

        System.out.println("\nLa data de sortida del vol és: " + new SimpleDateFormat("dd-MM-yyyy").format(getDataSortida()));
        setDataSortida(new SimpleDateFormat("dd-MM-yyyy").parse((String) demanarDades("\nQuina és la nova data de sortida del vol?: (dd-mm-yyyy)", 2)));
        System.out.println("\nLa data d'arribada del vol és: " + new SimpleDateFormat("dd-MM-yyyy").format(getDataArribada()));
        setDataArribada(new SimpleDateFormat("dd-MM-yyyy").parse((String) demanarDades("\nQuina és la nova data d'arribada del vol?: (dd-mm-yyyy)", 2)));

        System.out.println("\nL'hora de sortida del vol és: " + getHoraSortida().getHour() + ":" + getHoraSortida().getMinute());
        hora = (int) demanarDades("\nQuina és la nova hora de sortida del vol? (0-23h)", 1);
        minuts = (int) demanarDades("\nQuins són els nous minuts de la hora de sortida del vol? (0-59m)", 1);
        setHoraSortida(LocalTime.of(hora, minuts));

        System.out.println("\nL'hora d'arribada del vol és: " + getHoraArribada().getHour() + ":" + getHoraArribada().getMinute());
        hora = (int) demanarDades("\nQuina és la nova hora d'arribada del vol? (0-23h)", 1);
        minuts = (int) demanarDades("\nQuins són els nous minuts de l'hora d'arribada del vol? (0-59m)", 1);
        setHoraArribada(LocalTime.of(hora, minuts));
		
		//calcularDurada(); //new preguntar
    }

    private void calcularDurada() {
        long segonsDurada = (getDataArribada().getTime() + (getHoraArribada().getHour() * 3600 + getHoraArribada().getMinute() * 60)) - (getDataSortida().getTime() + (getHoraSortida().getHour() * 3600 + getHoraSortida().getMinute() * 60));

        setDurada((segonsDurada / 3600000) + " h - " + ((segonsDurada - (3600 * (segonsDurada / 3600))) / 60) + " m");
    }
	
    public void afegirTripulant(Tripulant tripulant) {
		tripulacio[posicioTripulacio] = tripulant;
		posicioTripulacio++;
		if (tripulant instanceof TCP) {
			if ("Si".equals( (String) demanarDades("\nVols que el tripulant TCP sigui el cap de cabina de passatgers?: (\"Si\" o \"No\")", 2) ) ) {
				cap = (TCP) tripulant;
				cap.setRang("Cap");
			}
		}
    }

    public void mostrarComponent() {
        System.out.println("\nLes dades del vol amb codi " + getCodi() + " són:");

        System.out.println("\nRuta: ");
        if (getRuta() != null) {
            getRuta().mostrarComponent();
        }

        System.out.println("\nAvio: ");
        if (getAvio() != null) {
            getAvio().mostrarComponent();
        }

        System.out.println("\nCap de la cabina de passatgers: ");
        if (getCap() != null) {
            getCap().mostrarComponent();
        }

        System.out.println("\nLa tripulació de cabina és:");
        for (int i = 0; i < posicioTripulacio; i++) {
            if (tripulacio[i] != null) {
                tripulacio[i].mostrarComponent();
			}
        }

        System.out.println("\nData de sortida: " + new SimpleDateFormat("dd-MM-yyyy").format(getDataSortida()));
        System.out.println("\nData d'arribada: " + new SimpleDateFormat("dd-MM-yyyy").format(getDataArribada()));
        System.out.println("\nHores de sortida: " + getHoraSortida().getHour() + ":" + getHoraSortida().getMinute());
        System.out.println("\nHores d'arribada: " + getHoraArribada().getHour() + ":" + getHoraArribada().getMinute());

        System.out.println("\nDurada: " + getDurada());
    }
}
