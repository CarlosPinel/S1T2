package N301;

import java.util.ArrayList;

/**
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
 * afegirButaca: serà l’encarregat d’afegir una butaca al vector de butaques.
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
 **/

public class GestionButacas {

	// Attributes
	ArrayList<Butaca> butacasReservadas;

	// Constructor
	public GestionButacas() {
		this.butacasReservadas = new ArrayList<Butaca>();
	}

	// Setters/getters
	public ArrayList<Butaca> getButacasReservadas() {
		return butacasReservadas;
	}

	// General methods
	public String anadirButaca(Butaca butacaAReservar) throws ButacaOcupadaException {

		String mensaje = "";
		int posArrayListBut = 0;

		posArrayListBut = buscarButBut(butacaAReservar);
		if (posArrayListBut != -1 && posArrayListBut != -2) {
			throw new ButacaOcupadaException("La butaca indicada ya está reservada.");
		} else {
			this.butacasReservadas.add(butacaAReservar);
			mensaje = "Se ha reservado la butaca: \n" + butacaAReservar.toString() + "\n";
		}
		return mensaje;
	}

	public String cancelarButaca(int numFila, int numBut) throws ButacaReservadaException {

		String mensaje = "";
		int posArrayListBut = 0;
		Butaca butacaACancelar = new Butaca(numFila, numBut);
		posArrayListBut = buscarButBut(butacaACancelar);
		if (posArrayListBut == -2) {
			mensaje = "No se puede cancelar. No hay butacas reservadas en el cine. \n";
		} else if (posArrayListBut == -1) {
			throw new ButacaReservadaException("No se puede cancelar. La butaca indicada no está reservada.");
		} else {
			butacaACancelar = this.butacasReservadas.get(posArrayListBut);
			this.butacasReservadas.remove(posArrayListBut);
			mensaje = "Se ha cancelado la butaca: \n" + butacaACancelar.toString() + "\n";
		}
		return mensaje;
	}

	// Assistant methods
	public int buscarButBut(Butaca butaca) {
		int posArrayListBut = 0;
		int i = 0;
		boolean condition1 = false, condition2 = false, encontrado = false;
		if (!this.butacasReservadas.isEmpty()) {
			while (i < this.butacasReservadas.size() && !encontrado) {
				condition1 = (butaca.getNumeroBut() == this.butacasReservadas.get(i).getNumeroBut());
				condition2 = (butaca.getNumeroFila() == this.butacasReservadas.get(i).getNumeroFila());
				encontrado = condition1 && condition2;
				if (encontrado) {
					posArrayListBut = i;
				} else {
					i++;
					posArrayListBut = -1;
				}
			}
		} else {
			posArrayListBut = -2;
		}
		return posArrayListBut;
	}

	public int buscarButNombre(String nombreReserva) {
		int posArrayListBut = 0;
		int i = 0;
		boolean encontrado = false;
		if (this.getButacasReservadas().size() != 0) {
			while (!encontrado) {
				encontrado = (nombreReserva.equalsIgnoreCase(this.getButacasReservadas().get(i).getNombreReserva()));
				i++;
			}
			posArrayListBut = (encontrado ? i : -1);
		} else {
			posArrayListBut = -2;
		}
		return posArrayListBut;
	}
}

