package fecha;

/**
 * Determina si la fecha es válida y si es año bisiesto o no
 * @author roman.saborido
 */
public class Fecha {
	private int d; //d�a
	private int m; //mes
	private int a; //a�o

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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Comprueba si la fehca es correcta
	 * @return True si la fecha es válida, false si no lo es
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Determina si el año de la fecha introducida es bisiesto o no
	 * @return True si el año es bisiesto, false si no lo es
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Incrementa la fecha al día siguiente
	 */
	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Devuelve una cadena representando la fecha
	 * @return String que representa la fecha
	 */
	// M�todo toString
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
