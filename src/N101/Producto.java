package N101;

/**
 * Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra
 * classe anomenada "Venda". 
 * Aquesta classe t� com a atributs una col�lecci� de productes i el preu total de la venda. 
 * La classe "Venda", t� un m�tode anomenat calcularTotal() que llan�a l�excepci� personalitzada VendaBuidaException 
 * i mostra per pantalla �Per fer una venda primer has d�afegir productes� si la col�lecci� de productes est� buida. 
 * Si la col�lecci� t� productes, llavors ha de rec�rrer la col�lecci� i guardar la
 * suma de tots els preus dels productes a l�atribut preu total de la venda.
 * 
 * L�excepci� personalitzada VendaBuidaException ha de ser filla de la classe Exception. 
 * Al seu constructor li hem de passar el missatge �Per fer una venda primer has d�afegir productes� i quan capturem l�excepci�, l�hem de mostrar
 * per pantalla amb el m�tode getMessage() de l�excepci�. 
 * Escriu el codi necessari per a generar i capturar una excepci� de tipus
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
