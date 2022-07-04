package N101;

/**
 * Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra
 * classe anomenada "Venda". 
 * Aquesta classe té com a atributs una col·lecció de productes i el preu total de la venda. 
 * La classe "Venda", té un mètode anomenat calcularTotal() que llança l’excepció personalitzada VendaBuidaException 
 * i mostra per pantalla “Per fer una venda primer has d’afegir productes” si la col·lecció de productes està buida. 
 * Si la col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la
 * suma de tots els preus dels productes a l’atribut preu total de la venda.
 * 
 * L’excepció personalitzada VendaBuidaException ha de ser filla de la classe Exception. 
 * Al seu constructor li hem de passar el missatge “Per fer una venda primer has d’afegir productes” i quan capturem l’excepció, l’hem de mostrar
 * per pantalla amb el mètode getMessage() de l’excepció. 
 * Escriu el codi necessari per a generar i capturar una excepció de tipus
 * ArrayIndexOutOfBoundsException.
 */

public class Producto {

	//Attributes
	String nombre;
	float precio;
	
	//Constructor
	public Producto() {};
	public Producto(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	//getters/setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	//Metodos generales
	public String toString() {
		String mensaje = "";
		mensaje = "Nombre: " + this.nombre + ". Precio : " + this.precio + " euros.";
		return mensaje;
	}
	
	
	
}
