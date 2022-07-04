package N101;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra
 * classe anomenada "Venda". Aquesta classe té com a atributs una col·lecció de
 * productes i el preu total de la venda. La classe "Venda", té un mètode
 * anomenat calcularTotal() que llança l’excepció personalitzada
 * VendaBuidaException i mostra per pantalla “Per fer una venda primer has
 * d’afegir productes” si la col·lecció de productes està buida. Si la
 * col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la
 * suma de tots els preus dels productes a l’atribut preu total de la venda.
 * 
 * L’excepció personalitzada VendaBuidaException ha de ser filla de la classe
 * Exception. Al seu constructor li hem de passar el missatge “Per fer una venda
 * primer has d’afegir productes” i quan capturem l’excepció, l’hem de mostrar
 * per pantalla amb el mètode getMessage() de l’excepció. Escriu el codi
 * necessari per a generar i capturar una excepció de tipus
 * ArrayIndexOutOfBoundsException.
 */

public class Main {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	static ArrayList<Venta> ventas = new ArrayList<Venta>();

	public static void main(String[] args) {

		// Data
		String mensaje = "";
		int opcion = 0;

		// Dialogo
		do {
			System.out.println("Indique que desa hacer. \n" + "0. Salir del programa. \n" + "1. Crear un producto. \n"
					+ "2. Eliminar un producto. \n" + "3. Crear una venta. \n" + "4. Caluclar precio de venta. \n");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch (opcion) {
			case 0:
				mensaje = "Adios";
				break;
			case 1:
				mensaje = crearProducto();
				break;
			case 2:
				mensaje = eliminarProducto();
				break;
			case 3:
				mensaje = crearVenta();
				break;
			case 4:
				mensaje = calcularPrecio();
				break;
			default:
				mensaje = "ERROR. Esta opcion no está disponible";
				break;
			}
			System.out.println(mensaje);
		} while (opcion != 0);
	}

	// Metodos
	public static String crearProducto() {
		String mensaje = "";
		String nombre = "";
		float precio = 0f;
		System.out.println("Introduzca el nombre del producto que quiere crear.");
		nombre = entrada.nextLine();
		System.out.println("Introduzca el precio del producto que quiere crear.");
		precio = entrada.nextFloat();
		Producto productoX = new Producto(nombre, precio);
		productos.add(productoX);
		mensaje = "Se ha creado el producto " + nombre + " con precio " + precio + " euros.";
		return mensaje;
	}

	public static String eliminarProducto() {
		String mensaje = "", nombreBusc = "", nombreEnc = "";
		System.out.println("Introduzca el nombre del producto que quiere eliminar");
		nombreBusc = entrada.nextLine();
		int posArr = buscarProducto(nombreBusc);
		if (posArr == -1) {
			mensaje = "No se ha encontrado ningún producto con ese nombre en el sistema.";
		} else if (posArr == -2) {
			mensaje = "El sistema está vacío. No tiene ningún producto añadido.";
		} else {
			nombreEnc = productos.get(posArr).getNombre();
			productos.remove(posArr);
			mensaje = "Se ha eliminado el producto " + nombreEnc;
		}
		return mensaje;
	}

	public static String crearVenta() {
		String mensaje = "";
		String nombreBusc = "";
		Producto productoEnc = null;
		int opcion = 0;
		if (productos.size() != 0) {
			System.out.println("Para crear una venta, debe escoger los productos que quiere vender. \n"
					+ "A continuación podrá ver el listado de productos actual: \n");
			for (int i = 0; i < productos.size(); i++) {
				System.out.println(productos.get(i).toString());
			}
			Venta venta = new Venta();
			ventas.add(venta);
			do {
				System.out.println("Indique que desa hacer. \n" + "0. Salir." + "1. Añadir producto.");
				opcion = entrada.nextInt();
				entrada.nextLine();
				if (opcion != 0) {
					System.out.println("Indique el producto que quiere añadir a la venta.");
					nombreBusc = entrada.nextLine();
					int posArr = buscarProducto(nombreBusc);
					if (posArr == -1) {
						mensaje = "No se ha encontrado ningún producto con ese nombre en el sistema.";
					} else {
						productoEnc = productos.get(posArr);
						venta.getProductos().add(productoEnc);
						mensaje = "Se ha añadido el producto " + productoEnc.getNombre() + " a la venta.";
					}
				}
				System.out.println(mensaje);
			} while (opcion != 0);
			mensaje = "Finalizado el proceso de crear la venta.";
		} else {
			mensaje = "No hay productos añadidos al sistema. Necesita crear productos antes de crear una venta.";
		}
		return mensaje;
	}

	public static String calcularPrecio() {
		String mensaje = "";
		int ventaNum = 0;
		float venta = 0f;
		System.out.println("Indique la venta de la que quiere calcular el precio. \n"
				+ "A continuación podrá ver las ventas con los productos asociados");
		if (ventas.size() != 0) {
			for (int i = 0; i < ventas.size(); i++) {
				System.out.println("venta 1: " + ventas.get(i).getProductos());
			}
			System.out.println("Indique el número de la venta de la que quiere calcular el precio.");
			ventaNum = entrada.nextInt();
			venta = ventas.get(ventaNum - 1).precioTotal();
			mensaje = "El precio total de la venta es de " + venta + " euros.";
		} else {
			System.out.println("no hay ventas creadas en el sistema");
		}
		return mensaje;
	}

	// Metodos auxiliares
	public static int buscarProducto(String nombre) {
		int posArr = 0;
		boolean stop = false;
		if (productos.size() != 0) {
			for (int i = 0; i < productos.size() && stop == false; i++) {
				if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
					posArr = i;
					stop = true;
				} else {
					posArr = -1;
				}
			}
		} else {
			posArr = -2;
		}
		return posArr;
	}
}
