package fecha;

/**
 * Determina si la fecha es válida y si es año bisiesto o no
 * @author roman.saborido
 */
public class Fecha {

	public static final int DIEZ = 10;
	private int dia; //d�a
	private int mes; //mes
	private int año; //a�o


	/**
	 * Método que no hace nada
	 */
	public Fecha() {

	}

	/**
	 * Constructor objeto Fecha de la clase Fecha
	 * @param dia Número entero que representa el día
	 * @param mes Número entero que representa el mes
	 * @param anio Número entero que representa el año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.año = anio;
	}

	
	/**
	 * Comprueba si la fehca es correcta
	 * @return True si la fecha es válida, false si no lo es
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = año > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Determina si el año de la fecha introducida es bisiesto o no
	 * @return True si el año es bisiesto, false si no lo es
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
	}


	/**
	 * Incrementa la fecha al día siguiente
	 */
	// M�todo diaSiguiente
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				año++;
			}
		}
	}


	/**
	 * Devuelve una cadena representando la fecha
	 * @return String que representa la fecha
	 */

	// M�todo toString
	public String toString() {
		
		String fecha;
		
		if (dia < DIEZ && mes < DIEZ) {
			fecha = "0" + dia + "-0" + mes + "-" + año;
		} else if (dia < DIEZ && mes >= DIEZ) {
			fecha = "0" + dia + "-" + mes + "-" + año;
		} else if (dia >= DIEZ && mes < DIEZ) {
			fecha = dia + "-0" + mes + "-" + año;
		} else {
			fecha = dia + "-" + mes + "-" + año;
		}
		
		return fecha;
	}

}
