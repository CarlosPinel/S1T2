package N301;

/**
 * Una famosa empresa de cinemes ens ha demanat que desenvolupem una aplicació
 * per a la reserva de seients en els seus cinemes. L’aplicació serà utilitzada
 * pels venedors/es a l’hora de vendre les entrades.
 * 
 * Funcionament L’aplicació un cop s’hagi iniciat, preguntarà a l’usuari/ària
 * quantes files i quants seients per fila té la sala de cinema. Un cop
 * introduïdes aquestes dades, es mostrarà el següent menú:
 * 
 * 1.- Mostrar totes les butaques reservades.
 * 
 * 2.- Mostrar les butaques reservades per una persona.
 * 
 * 3.- Reservar una butaca.
 * 
 * 4.- Anul·lar la reserva d’una butaca.
 * 
 * 5.- Anul·lar totes les reserves d’una persona.
 * 
 * 0.- Sortir.
 * 
 * 
 * L’aplicació tindrà les següents classes:
 * 
 * Classe Principal
 * 
 * Tindrà el main de l’aplicació on s’instanciarà un objecte de la classe Cine i
 * cridarà al seu mètode iniciar.
 * 
 * 
 * Classe Butaca
 * 
 * Tindrà les dades d’una butaca:
 * 
 * Atributs:
 * 
 * Nombre de fila.
 * 
 * Nombre de seient.
 * 
 * Persona que reserva la butaca.
 * 
 * Mètodes:
 * 
 * Constructor amb tots els paràmetres.
 * 
 * Getters per tots els atributs.
 * 
 * Equals: retornarà que dues butaques són iguales si la fila i el seient són
 * iguals.
 * 
 * toString: retornarà un String amb el següent format: “Fila: 5, Seient: 20,
 * Persona: Maria Febrer”
 * 
 * 
 * Classe Cine
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
 * 
 * 
 * Classe GestioButaques
 * 
 * Contindrà un ArrayList de butaques i els mètodes necessaris per afegir,
 * eliminar i cercar les butaques a l’ArrayList.
 * 
 * Atributs:
 * 
 * butaques: ArrayList de butaques.
 * 
 * Mètodes:
 * 
 * Constructor: No rebrà paràmetres i inicialitzarà l’ArrayList de butaques.
 * 
 * getButaques: Retornarà l’atribut butaques.
 * 
 * afegirButaca: serà l’encarregat d’afegirs una butaca al vector de butaques.
 * Rebrà com a paràmetre un objecte de la classe Butaca i l’afegirà a
 * l’ArrayList. Si la fila i el seient de la butaca rebuda com a paràmetre
 * coincideixen amb el d’una butaca que ja es trobi a l’ArrayList (s’utilitzarà
 * el mètode cercarButaca), es llençarà l’excepció personalitzada
 * ExcepcioButacaOcupada.
 * 
 * eliminarButaca: serà l’encarregat d’eliminar una butaca de l’ArrayList de
 * butaques. Rebrà com a paràmetres el número de fila i el seient i l’eliminarà
 * de l’ArrayList. Si la fila i el seient no coincideixen amb el d’una butaca
 * reservada (s’utilitzarà el mètode cercarButaca), llençarà una excepció
 * personalitzada ExcepcioButacaLliure.
 * 
 * cercarButaca: Cerca a l’ArrayList de butaques, la butaca que coincideixi amb
 * les dades rebudes com a paràmetre (fila i seient). Si la troba retornarà la
 * posició de la butaca a l’ArrayList i si no la troba retornarà -1.
 *
 *//*
	*/
public class Main {

	public static void main(String[] args) {
		
		Cine cine1 = new Cine();
		cine1.iniciar();
	}
}
