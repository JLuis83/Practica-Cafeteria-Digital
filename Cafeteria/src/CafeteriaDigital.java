import java.util.*;
/*
1 → Añadir pedido   (ArrayList y LinkedList)
2 → Mostrar pedidos (ArrayList y LinkedList)
3 → Mostrar menú (HashMap y TreeMap)
4 → Atender siguiente pedido (elimina el primero de la LinkedList)
*/

public class CafeteriaDigital {

    private String nombreCliente;
    private String seleccionado;





    public static Scanner sc;
    //Menu Desordenado
    public static HashMap<String, Double> productosDesordenados;

    //Menu Ordenado
    public static TreeMap<String, Double> productosOrdenados;

    //Pedidos
    public static ArrayList<String> pedidosRealizados;


    //


    public CafeteriaDigital() {  //los metodos relacionados con el constructor no pueden estar static

        this.sc = new Scanner(System.in);
        this.productosDesordenados = new HashMap<>();
        this.productosOrdenados = new TreeMap<>();
        this.pedidosRealizados = new ArrayList<>();
        cargarProductos();
    }


    public static void main(String[] args) {

        // new CafeteriaDigital().ejecutar();

        CafeteriaDigital cafet = new CafeteriaDigital();
        cafet.ejecutar();
    }

    private void ejecutar() {
        int opcion;
        do {
            opcion = mostrarMenuPrincipal();
            procesarOpcion(opcion);
        } while (opcion != 0);

        cerrarRecurso();
    }


    public int mostrarMenuPrincipal() {

        int opcion;

        System.out.println("Menu Cafeteria");
        System.out.println("1-Mostrar menú");
        System.out.println("2-Añadir Pedido");
        System.out.println("4-Siguiente Pedido");
        System.out.println("0-Salir");
        System.out.println("Elige una opcion");

        opcion = leerEntero();
        sc.nextLine();
        return opcion;

    }

    private void procesarOpcion(int opcion) {

        switch (opcion) {
            case 1 -> {
                menu();
                System.out.println("\nPulsa ENTER para volver al menú principal...");
                sc.nextLine(); // limpiar buffer
            }
            case 2 -> agregarNuevoPedido();
            //case 0 -> System.out.println("Salir");
            //default -> System.out.println("saliendo");
        }

    }

    private void cerrarRecurso() {

        sc.close();
    }

    public void cargarProductos() {


        productosDesordenados.put("Cafe", 1.20);
        productosDesordenados.put("Donuts", 2.0);
        productosDesordenados.put("Té", 1.50);
        productosDesordenados.put("Tostadas", 2.50);
        productosDesordenados.put("Churros", 2.00);
        productosDesordenados.put("Te verde", 1.20);
        productosDesordenados.put("Mermelada", 1.50);
        productosDesordenados.put("Leche", 1.0);
        productosDesordenados.put("Cereales", 1.30);


        productosOrdenados.putAll(productosDesordenados);

    }


    private int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Introduce un número valido");
            sc.next();

        }
        return sc.nextInt();

    }


    private static void menu() {

        System.out.println("Productos Desordenados");
        System.out.println("______________________");

        productosDesordenados.forEach((producto, precio) ->
                System.out.println(producto + " = " + precio + "€"));

        System.out.println("\nProductos Ordenados");
        System.out.println("______________________");

        productosOrdenados.forEach((producto, precio) ->
                System.out.println(producto + " = " + precio + "€"));


    }


    private String pedirNombreCliente() {

        System.out.println("Nombre Cliente");
        return sc.nextLine().trim();
    }


    private String productoCliente() {

        System.out.println("Seleccione producto: ");
        return sc.nextLine().trim();
    }

    /*
    Agregar nuevo pedido a la app
     */
    private void agregarNuevoPedido() {


        nombreCliente = pedirNombreCliente();
        // varible que almacena el listado de productos elegidos por el cliente
        ArrayList<String> productos = solicitarProductos();

        // Validar si el array tiene productos o no
        if (productos.isEmpty()){
            System.out.println("No se han añadido productos");
            return;
        }

        // Asigna el nombre del cliente con los productos elegidos
        String pedido= construirPedido(nombreCliente,productos);
        // Almacena el pedido del cliente
        registroPedido(pedido);
        System.out.println("Pedido realizado con exito");

    }

    private String construirPedido(String cliente, ArrayList<String> productos){
        return cliente + "--" + String.join(",", productos);
    }

    private void registroPedido(String pedido){
        pedidosRealizados.add(pedido);
    }

    private ArrayList<String> solicitarProductos() {
        String entrada;
        ArrayList<String> productos=new ArrayList<>();
        while (true) {
            entrada = capturaProducto();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            String productoValidado=buscarProductoMenu(entrada);
            if(productoValidado!=null){
                productos.add(productoValidado);
            }
            else{
                System.out.println("Producto no válido. Tienes que elegir un producto del menu");
            }
        }
        return productos;
    }

    private String buscarProductoMenu(String entrada) {


        if (productosDesordenados.containsKey(entrada)) {
            System.out.println("Producto correcto");
        } else {
            System.out.println("Producto no está en nuestro  menú");
        }
        return entrada;
    }

    public String capturaProducto () {
            System.out.println("Introduce un producto del menu (o fin para acabar)");
            return sc.nextLine().trim();
    }


}

/*
Tiene  nombre las columnas de las tablas??
pdf Pedro


Hodl Hodl

 */