package N101;

import java.util.ArrayList;

/**
 * Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra
 * classe anomenada "Venda". Aquesta classe t� com a atributs una col�lecci� de
 * productes i el preu total de la venda. La classe "Venda", t� un m�tode
 * anomenat calcularTotal() que llan�a l�excepci� personalitzada
 * VendaBuidaException i mostra per pantalla �Per fer una venda primer has
 * d�afegir productes� si la col�lecci� de productes est� buida. Si la
 * col�lecci� t� productes, llavors ha de rec�rrer la col�lecci� i guardar la
 * suma de tots els preus dels productes a l�atribut preu total de la venda.
 * 
 * L�excepci� personalitzada VendaBuidaException ha de ser filla de la classe
 * Exception. Al seu constructor li hem de passar el missatge �Per fer una venda
 * primer has d�afegir productes� i quan capturem l�excepci�, l�hem de mostrar
 * per pantalla amb el m�tode getMessage() de l�excepci�. Escriu el codi
 * necessari per a generar i capturar una excepci� de tipus
 * ArrayIndexOutOfBoundsException.
 */

public class Venta {

	// Attributes
	ArrayList<Producto> productos;
	float precioTotal;

	// Constructor
	public Venta() {
		this.productos = new ArrayList<Producto>();
		this.precioTotal = 0;
	}

	// setters/getters
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	// General Methods
	public float precioTotal() {
		float precioTotal = 0f;
		for (int i = 0; i < this.productos.size(); i++) {
			precioTotal += this.productos.get(i).getPrecio();
		}
		return precioTotal;
	}
}
