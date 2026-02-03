/**
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * @author Pedro
 *
 */
public class Cafeteria {

	// Constantes para el menú
	private static final String SEPARADOR_PEDIDO = " - ";
	private static final String SEPARADOR_PRODUCTOS = ", ";
	private static final String COMANDO_FIN = "fin";

	private static int CONTADOR_PEDIDOS = 1;

	// Estructuras de datos
	private final Scanner scanner;
	private final ArrayList<String> pedidosHistorial; // ArrayList para historial
	private final LinkedList<String> pedidosCola; // LinkedList como cola FIFO
	private final HashMap<String, Double> menuDesordenado; // HashMap rápido
	private final TreeMap<String, Double> menuOrdenado; // TreeMap alfabético

	// Persistencia
	private final String ARCHIVO_PEDIDOS = "c:/Users/Pedro/Desktop/pedidos.txt";
	private FileWriter fichero = null;

	/**
	 * Constructor que inicializa todas las estructuras de datos
	 */
	public Cafeteria() {
		this.scanner = new Scanner(System.in);
		this.pedidosHistorial = new ArrayList<>();
		this.pedidosCola = new LinkedList<>();
		this.menuDesordenado = new HashMap<>();
		this.menuOrdenado = new TreeMap<>();
		cargaProductosMenu();
	}

	/**
	 * Punto de entrada del programa
	 */
	public static void main(String[] args) {
		new Cafeteria().ejecutar();
	}

	/**
	 * Bucle principal del programa
	 */
	private void ejecutar() {
		int opcion;
		do {
			opcion = mostrarMenuPrincipal();
			procesarOpcion(opcion);
		} while (opcion != 0);

		cerrarRecursos();
	}

	/**
	 * Muestra el menú principal y retorna la opción seleccionada
	 */
	private int mostrarMenuPrincipal() {
		System.out.println("\n=== CAFETERÍA DIGITAL ===");
		System.out.println("1. Añadir pedido");
		System.out.println("2. Mostrar pedidos");
		System.out.println("3. Mostrar menú");
		System.out.println("4. Atender siguiente pedido");
		System.out.println("5. Mostrar pedidos guardados (Desde archivo)");
		System.out.println("0. Salir");
		System.out.print("Seleccione una opción: ");

		int opcion = leerEntero();
		scanner.nextLine(); // Limpiar buffer
		return opcion;
	}

	/**
	 * Procesa la opción seleccionada del menú
	 */
	private void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			agregarPedido();
			break;
		case 2:
			mostrarPedidos();
			break;
		case 3:
			mostrarMenuProductos();
			break;
		case 4:
			atenderPedido();
			break;
		case 5:
			mostrarPedidosDesdeArchivo();
			break;
		case 0:
			System.out.println("Saliendo del sistema. ¡Hasta pronto!");
			break;
		default:
			System.out.println("Opción no válida, intente de nuevo.");
		}
	}

	/**
	 * Carga los productos iniciales del menú
	 */
	private void cargaProductosMenu() {
		menuDesordenado.put("Cafe", 1.50);
		menuDesordenado.put("Te Verde", 1.20);
		menuDesordenado.put("Capuchino", 2.00);
		menuDesordenado.put("Donut", 1.00);
		menuDesordenado.put("Croissant", 1.30);

		// Sincronizar con TreeMap para mantener orden alfabético
		menuOrdenado.putAll(menuDesordenado);
	}

	
	/**
	 * Lee un entero del scanner con manejo de errores
	 */
	private int leerEntero() {
		while (!scanner.hasNextInt()) {
			System.out.print("Por favor, introduce un número válido: ");
			scanner.next();
		}
		return scanner.nextInt();
	}

	/**
	 * Cierra los recursos utilizados
	 */
	private void cerrarRecursos() {
		scanner.close();
	}
}

