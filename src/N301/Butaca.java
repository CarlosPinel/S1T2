package N301;

/*Classe Butaca
* 
* TindrÃ  les dades dâ€™una butaca:
* 
* Atributs:
* 
* Nombre de fila.
* 
* Nombre de seient.
* 
* Persona que reserva la butaca.
* 
* MÃ¨todes:
* 
* Constructor amb tots els parÃ metres.
* 
* Getters per tots els atributs.
* 
* Equals: retornarÃ  que dues butaques sÃ³n iguales si la fila i el seient sÃ³n
* iguals.
* 
* toString: retornarÃ  un String amb el segÃ¼ent format: â€œFila: 5, Seient: 20,
* Persona: Maria Febrerâ€�
* */

public class Butaca {

	//Attributes
	private int numeroFila;
	private int numeroBut;
	private String nombreReserva;
	
	//Constructor
	public Butaca() {}
	
	public Butaca(int numeroFila, int numeroBut) {
		this.numeroFila = numeroFila;
		this.numeroBut = numeroBut;
	}
	public Butaca(int numeroFila, int numeroBut, String nombreReserva) {
		this.numeroFila = numeroFila;
		this.numeroBut = numeroBut;
		this.nombreReserva = nombreReserva;
	}
	
	//getters/setters
	public int getNumeroFila() {
		return numeroFila;
	}
	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}
	public int getNumeroBut() {
		return numeroBut;
	}
	public void setNumeroBut(int numeroBut) {
		this.numeroBut = numeroBut;
	}
	public String getNombreReserva() {
		return nombreReserva;
	}
	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}
	
	//General methods
	public boolean equals(int numeroFila, int numeroBut) {
		boolean condition = false;
		condition = (this.numeroFila == numeroFila && this.numeroBut == numeroBut);
		return condition;
	}
	
	public String toString() {
		return "Fila: " + this.numeroFila + ", Butaca: " + this.numeroBut + ", Persona: " + this.nombreReserva;
	}
}
