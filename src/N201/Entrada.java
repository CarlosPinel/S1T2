 package N201;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Crea una classe anomenada "Entrada". Aquesta classe ha de servir per
 * controlar les diferents excepcions que poden aparÃƒÂ¨ixer en Java a
 * lÃ¢â‚¬â„¢hora dÃ¢â‚¬â„¢introduir dades per teclat utilitzant la classe
 * Scanner.
 * 
 * El primer que sÃ¢â‚¬â„¢ha de fer ÃƒÂ©s instanciar un objecte de la classe
 * Scanner i a partir dÃ¢â‚¬â„¢aquÃƒÂ­, crear mÃƒÂ¨todes estÃƒÂ tics per llegir
 * els diferents tipus de dades des del teclat.
 * 
 * Important
 * 
 * Ãƒâ€°s important que si en algun mÃƒÂ¨tode salta una excepciÃƒÂ³, la tractem
 * i tornem a demanar la dada a lÃ¢â‚¬â„¢usuari/ÃƒÂ ria fins que aquesta estigui
 * ben introduÃƒÂ¯da. Per exemple: Si introdueix un float amb un punt en lloc
 * d'amb una coma, ha de mostrar Ã¢â‚¬Å“Error de formatÃ¢â‚¬ï¿½. Fins que
 * lÃ¢â‚¬â„¢usuari/ÃƒÂ ria no introdueix un float ben format ha de seguir
 * demanant la dada.
 * 
 * Tots els mÃƒÂ¨todes reben un String amb el missatge que es vol mostrar a
 * lÃ¢â‚¬â„¢usuari/ÃƒÂ ria, per exemple: Ã¢â‚¬Å“Introdueix la teva edatÃ¢â‚¬ï¿½,
 * i retornen la dada oportuna introduÃƒÂ¯da per lÃ¢â‚¬â„¢usuari/ÃƒÂ ria en cada
 * mÃƒÂ¨tode, per exemple: un byte amb lÃ¢â‚¬â„¢edat de lÃ¢â‚¬â„¢usuari/ÃƒÂ ria.
 * 
 * MÃƒÂ¨todes a implantar capturant lÃ¢â‚¬â„¢excepciÃƒÂ³ de la classe
 * InputMismatchException:
 * 
 * public static byte llegirByte(String missatge);
 * 
 * public static int llegirInt(String missatge);
 * 
 * public static float llegirFloat(String missatge);
 * 
 * public static double llegirDouble(String missatge);
 * 
 * MÃƒÂ¨todes a implantar capturant lÃ¢â‚¬â„¢excepciÃƒÂ³ de la classe Exception:
 * 
 * public static char llegirChar(String missatge);
 * 
 * public static String llegirString(String missatge);
 * 
 * public static boolean llegirSiNo(String missatge), si lâ€™usuari/Ã ria
 * introdueix â€œsâ€�, retorna â€œtrueâ€�, si lâ€™usuari introdueix â€œnâ€�,
 * retorna â€œfalseâ€�.
 *
 */

public class Entrada {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		byte edad = 0;
		String mensaje = "";
		boolean stop = false;
		int year = 0;
		float price = 0f;
		double numeroPreciso = 0d;
		String inicialNombre = "";
		String presentacion = "";
		boolean condicion = false;

		// Leer Byte

		do {
			try {
				mensaje = "Introduzca su edad";
				edad = leerByte(mensaje);
				mensaje = "Su edad es " + edad + " years.";
				stop = true;
			} catch (InputMismatchException e) {
				mensaje = "Error de formato. Introduzca un byte";
				stop = false;
			}
			entrada.nextLine();
			System.out.println(mensaje);
		} while (stop == false);

		// Leer Int

		do {
			try {
				mensaje = "Introduce the year of your birth";
				year = leerInt(mensaje);
				mensaje = "your birthyear is " + year + ".";
				stop = true;
			} catch (InputMismatchException e) {
				mensaje = "Error de formato. Introduzca un numero entero.";
				stop = false;
			}
			entrada.nextLine();
			System.out.println(mensaje);
		} while (stop == false);

		// Leer Float

		do {
			try {
				mensaje = "Introduce the price of the product";
				price = leerFloat(mensaje);
				mensaje = "the price is " + price + " euros.";
				stop = true;
			} catch (InputMismatchException e) {
				mensaje = "Error de formato. Introduzca un numero float (nÃºmero con parte entera y parte decimal) de 7 digitos como mÃ¡ximo.";
				stop = false;
			}
			entrada.nextLine();
			System.out.println(mensaje);
		} while (stop == false);

		// Leer Double

		do {
			try {
				mensaje = "Introduce el nÃºmero X del resultado de la prueba de laboratorio";
				numeroPreciso = leerDouble(mensaje);
				mensaje = "El nÃºmero X Ã©s " + numeroPreciso + ".";
				stop = true;
			} catch (InputMismatchException e) {
				mensaje = "Error de formato. Introduzca un numero Double (nÃºmero con parte entera y parte decimal) de 15 digitos como mÃ¡ximo.";
				stop = false;
			}
			entrada.nextLine();
			System.out.println(mensaje);
		} while (stop == false);

		// Leer Char

		do {
			try {
				mensaje = "Introduce la inicial de tu nombre";
				inicialNombre = leerChar(mensaje);
				mensaje = "La letra inicial de tu nombre Ã©s " + inicialNombre + ".";
				stop = true;
			} catch (Exception e) {
				// Creacion de excepciones propias
				// mensaje = "Error de formato. Introduzca un sÃ³lo carÃ¡cter."; Creacion de
				mensaje = "Error de tipo Exception";
				stop = false;
			}
			entrada.nextLine();
			System.out.println(mensaje);
		} while (stop == false);

		// Leer String

		do {
			try {
				mensaje = "Introduce una frase de presentacion.";
				presentacion = leerString(mensaje);
				mensaje = "Tu presentaciÃ³n Ã©s: " + presentacion + ".";
				stop = true;
			} catch (Exception e) {
				// Creacion de excepciones propias
				// mensaje = "Error de formato. Introduzca un String (cadena de carÃ¡cteres) no vacía;
				mensaje = "Error de tipo Exception";
				stop = false;
			}
			System.out.println(mensaje);
		} while (stop == false);

		// Leer SiNo

		do {
			try {
				mensaje = "Tienes ganas de estudiar? \nIntroduce [s] para indicar SI, y [n] para indicar NO.";
				condicion = leerSiNo(mensaje);
				mensaje = "Es " + condicion + " que quieras estudiar";
				stop = true;
			} catch (Exception e) {
				// Creacion de excepciones propias
				// mensaje = "Debe introducir [s] para indicar SI, y [n] para indicar NO";
				mensaje = "Error de tipo Exception";
				stop = false;
			}
			entrada.nextLine();
			System.out.println(mensaje);
		} while (stop == false);

	}

	// Assistant methods.

	public static byte leerByte(String mensaje) throws InputMismatchException {
		byte edad = 0;
		System.out.println(mensaje);
		edad = entrada.nextByte();
		return edad;
	}

	public static int leerInt(String mensaje) throws InputMismatchException {
		int birthyear = 0;
		System.out.println(mensaje);
		birthyear = entrada.nextInt();
		return birthyear;
	}

	public static float leerFloat(String mensaje) throws InputMismatchException {
		float price = 0;
		System.out.println(mensaje);
		price = entrada.nextFloat();
		return price;
	}

	public static double leerDouble(String mensaje) throws InputMismatchException {
		double numeroPreciso = 0;
		System.out.println(mensaje);
		numeroPreciso = entrada.nextDouble();
		return numeroPreciso;
	}

	public static String leerChar(String mensaje) throws Exception {

		String inicialNombre = "";
		System.out.println(mensaje);
		inicialNombre = entrada.next();
		// Creacion de excepciones propias
		/*
		 * if (inicialNombre.length() > 1) { Exception e = new Exception(); throw e; }
		 */
		return inicialNombre;
	}

	public static String leerString(String mensaje) throws Exception {
		String presentacion = "";
		System.out.println(mensaje);
		presentacion = entrada.nextLine();
		// Creacion de excepciones propias
		/*
		 * if (presentacion.isBlank()) { Exception e = new Exception(); throw e; }
		 */
		return presentacion;
	}

	public static boolean leerSiNo(String mensaje) throws Exception {
		String siNo = "";
		boolean condicion = false;
		System.out.println(mensaje);
		siNo = entrada.next();
		if (siNo.equalsIgnoreCase("s")) {
			condicion = true;
		} else if (siNo.equalsIgnoreCase("n")) {
			condicion = false;
		}
		// Creacion de excepciones propias
		/*	
		} else {
			Exception e = new Exception();
			throw e;
		}*/

		return condicion;
	}
}
