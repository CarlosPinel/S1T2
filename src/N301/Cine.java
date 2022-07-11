package N301;

import java.util.Scanner;

/*Classe Cine
* 
* Contindrà tots els mètodes que permeten interactuar a l’usuari/ària amb
* l’aplicació.
* 
* Atributs:
* 
* Nombre de files del cinema.
* 
* Nombre de seients per cada fila.
* 
* Un objecte de la classe GestioButaques
* 
* Mètodes:
* 
* Constructor: no rebrà paràmetres. Crearà l’objecte de la classe
* GestióButaques. I cridarà al mètode demanarDadesInicials que inicialitzarà el
* nombre de files i de seients.
* 
* iniciar: començarà l’aplicació. Cridarà al mètode menu i en funció del número
* retornat, cridarà al mètode corresponent.
* 
* menu: mostrarà les opcions del menú principal a l’usuari/ària, li demanarà el
* número de l’opció escollida i el retornarà.
* 
* mostrarButaques: Mostra totes les butaques reservades.
* 
* mostrarButaquesPersona: Demana el nom de la persona que ha fet la reserva i
* mostra totes les butaques reservades per aquesta persona.
* 
* reservarButaca: Demana a l’usuari/ària un número de fila (crida al mètode
* introduirFila), un número de seient (crida al mètode introduirSeient), el nom
* de la persona que fa la reserva (crida al mètode introduirPersona) i reserva
* la butaca.
* 
* anularReserva: Demana a l’usuari/ària un número de fila (crida al mètode
* introduirFila), un número de seient (crida al mètode introduirSeient) i
* elimina la reserva de la butaca.
* 
* anularReservaPersona: Demana a l’usuari/ària el nom de la persona (crida al
* mètode introduirPersona) i elimina les butaques reservades per la persona
* introduïda.
* 
* introduirPersona: demana a l’usuari/ària el nom de la persona i el retorna si
* és correcte. Si conté números, llença una excepció personalitzada
* ExcepcioNomPersonaIncorrecte.
* 
* demanarDadesInicials: Demana a l’usuari/ària el nombre de files i seients i
* els guarda en els atributs corresponents.
* 
* introduirFila: Demana el nombre de fila, si aquest està entre 1 i el nombre
* de files totals, el retorna. Si no, retorna una excepció personalitzada
* ExcepcioFilaIncorrecta.
* 
* introduirSeient: Demana el seient, si el número està entre 1 i el nombre
* total de seients, el retorna. Si no, retorna una excepció del tipus
* ExcepcioSeientIncorrecte.
* */

public class Cine {

	Scanner entrada = new Scanner(System.in);

	// Attributes
	private int numFilas;
	private int numButacas;
	private GestionButacas gestionbut;

	// Constructor
	public Cine() {
		this.gestionbut = new GestionButacas();
		solicitarDatosIniciales();
	}

	// Methods
	public void iniciar() {
		int opcion = 0;
		String mensaje = "", nombre = "";
		int num = 0;

		do {
			opcion = menu();
			switch (opcion) {
			case 0:
				mensaje = "Adios";
				break;
			case 1:
				mensaje = mostrarButacasReservadasCine();
				break;
			case 2:
				System.out.println("Introduzca el nombre de la persona");
				nombre = entrada.nextLine();
				mensaje = mostrarButcasReservadasPersona(nombre);
				break;
			case 3:
				mensaje = reservarButaca();
				break;
			case 4:
				mensaje = cancelarButaca();
				break;
			case 5:
				try {
				mensaje = introducirPersona();
				} catch (Exception e) {
					System.out.println("El nombre de la persona no debe contener numeros.");
				}
				break;
			case 6:
				try {
				num = solicitarNumeroFila();
				mensaje = "El numero de fila es " + num;
				} catch (Exception e) {
					System.out.println("Error. La fila indicada no existe en este cine.");
				}
				break;
			case 7:
				try {
				num = solicitarNumeroButaca();
				mensaje = "El numero de butaca es " + num;
				} catch(Exception e) {
					System.out.println("Error. La butaca indicada no existe en este cine.");
				}
				break;
			default:
				mensaje = "Opcion no disponible";
				break;
			}
			System.out.println(mensaje);
		} while (opcion != 0);
	}

	public int menu() {
		int opcion = 0;

		System.out.println("Escoja la opcion deseada: \n" + "0. Salir del menu. \n"
				+ "1. Mostrar butacas reservadas. \n" + "2. Mostrar butacas reservadas de una persona. \n"
				+ "3. Reservar butacas. \n" + "4. Anular butaca. \n" + "5. Introducir persona. \n"
				+ "6. Solicitar numero de fila. \n" + "7. Solicitar numero de butaca. \n");
		opcion = entrada.nextInt();
		entrada.nextLine();
		return opcion;
	}

	public String mostrarButacasReservadasCine() {
		String resultado = "", texto1 = "", texto2 = "";
		int i = 0;
		if (this.gestionbut.getButacasReservadas().size() != 0) {
			while (i < this.gestionbut.getButacasReservadas().size()) {
				texto1 = "Las butacas reservadas son: \n";
				texto2 += this.gestionbut.getButacasReservadas().get(i).toString() + "\n";
				resultado = texto1 + texto2;
				i++;
			}
		} else {
			resultado = "No hay ninguna butaca reservada. \n";
		}
		return resultado;
	}

	public String mostrarButcasReservadasPersona(String nombreReserva) {
		String resultado = "", resultado1 = "", resultado2 = "";
		int i = 0;
		boolean encontrados = false;
		if (!this.gestionbut.getButacasReservadas().isEmpty()) {
			while(i < this.gestionbut.getButacasReservadas().size()) {
				if (nombreReserva.equalsIgnoreCase(this.gestionbut.getButacasReservadas().get(i).getNombreReserva())) {
					encontrados = true;
					resultado1 += this.gestionbut.getButacasReservadas().get(i).toString() + "\n";
				} else {
					resultado2 = "No hay butacas reservadas a nombre de " + nombreReserva + "\n";
				}
			i++;
			}
			resultado = (encontrados) ? resultado1 : resultado2;
		} else {
			resultado = "No hay ninguna butaca reservada en el cine. \n";
		}
		
		return resultado;
	}

	public String reservarButaca() {
		String resultado = "";
		int numFila = 0, numButaca = 0;
		String nombreReserva = "";
		Butaca ButacaAReservar = new Butaca();
		
		System.out.println("Inicio de proceso de reserva: \nIntroduzca el numero de fila");
		numFila = entrada.nextInt();
		System.out.println("Introduzca el numero de butaca");
		numButaca = entrada.nextInt();
		entrada.nextLine();
		if (butacaExist(numFila, numButaca)) {
			ButacaAReservar.setNumeroFila(numFila);
			ButacaAReservar.setNumeroBut(numButaca);
			System.out.println("Introduzca el nombre de la persona que hace la reserva");
			nombreReserva = entrada.nextLine();
			ButacaAReservar.setNombreReserva(nombreReserva);
			try {
			resultado = this.gestionbut.anadirButaca(ButacaAReservar);
			} catch (Exception e) {
				System.out.println("La butaca indicada ya está reservada.");
			}
		} else {
			resultado = "No existe la butaca indicada en este cine. \n";
		}
		return resultado;
	}

	public String cancelarButaca() {
		String resultado = "";
		int numFila = 0, numButaca = 0;
		Butaca ButacaACancelar = new Butaca();

		System.out.println("Inicio de proceso de cancelacion: \nIntroduzca el numero de fila");
		numFila = entrada.nextInt();
		System.out.println("Introduzca el numero de butaca");
		numButaca = entrada.nextInt();
		if (butacaExist(numFila, numButaca)) {
			ButacaACancelar.setNumeroFila(numFila);	
			ButacaACancelar.setNumeroBut(numButaca);
			try {
			resultado = this.gestionbut.cancelarButaca(numFila, numButaca);
			} catch (Exception e) {
				System.out.println("No se puede cancelar. La butaca indicada no está reservada.");
			}
		} else {
			resultado = "No existe la butaca indicada en este cine. \n";
		}
		return resultado;
	}

	public String introducirPersona() throws ExcepcionNombrePersonaIncorrecto {
		String resultado = "";
		String nombrePersona = "";

		System.out.println("Introduce el nombre de la persona");
		nombrePersona = entrada.nextLine();
		if (nombrePersona.matches(".*[0-9].*")) {
			throw new ExcepcionNombrePersonaIncorrecto("El nombre de la persona no debe contener numeros.");
		} else {
			resultado = "Su nombre es " + nombrePersona + "\n";
		}
		return resultado;
	}

	public void solicitarDatosIniciales() {
		System.out.println("Introduzca el numero de filas");
		this.numFilas = entrada.nextInt();
		System.out.println("Introduzca el numero de butacas");
		this.numButacas = entrada.nextInt();
	}

	public int solicitarNumeroFila() throws ExcepcionFilaIncorrecta {
		int resultado = 0;
		int numFila = 0;

		System.out.println("Introduce el numero de fila");
		numFila = entrada.nextInt();
		if (numFila >= 1 && numFila <= this.numFilas) {
			resultado = numFila;
		} else {
			throw new ExcepcionFilaIncorrecta("Error. La fila indicada no existe en este cine.");
		}
		return resultado;
	}

	public int solicitarNumeroButaca() throws ExcepcionButacaIncorrecta {
		int resultado = 0;
		int numButaca = 0;

		System.out.println("Introduce el numero de butaca");
		numButaca = entrada.nextInt();
		if (numButaca >= 1 && numButaca <= this.numButacas) {
			resultado = numButaca;
		} else {
			throw new ExcepcionButacaIncorrecta("Error. La butaca indicada no existe en este cine.");
		}
		return resultado;
	}

	// Assistant methods
	public boolean butacaExist(int numFila, int numButaca) {
		boolean condition1 = (numFila >=1 && numFila <= this.numFilas);
		boolean condition2 = (numFila >= 1 && numButaca <= this.numButacas);
		boolean condition = (condition1 && condition2);
		return condition;
	}
}

@SuppressWarnings("serial")
class ExcepcionNombrePersonaIncorrecto extends Exception {

	public ExcepcionNombrePersonaIncorrecto(String mensError) {
		super(mensError);
	}
}

@SuppressWarnings("serial")
class ExcepcionFilaIncorrecta extends Exception {

	public ExcepcionFilaIncorrecta(String mensError) {
		super(mensError);
	}
}

@SuppressWarnings("serial")
class ExcepcionButacaIncorrecta extends Exception{

	public ExcepcionButacaIncorrecta(String mensError) {
		super(mensError);
	}
}





