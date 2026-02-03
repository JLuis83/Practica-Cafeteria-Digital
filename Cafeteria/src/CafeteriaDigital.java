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

    //Pedido
    public static ArrayList<String>pedidos;


    //Mostrar Pedidos
    //public static ArrayList<String,Double> arrayPedido;
    //private static ArrayList<String,Double> arrayPedido;


    public CafeteriaDigital() {  //los metodos relacionados con el constructor no pueden estar static

        //this.arrayPedido = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.productosDesordenados = new HashMap<>();
        this.productosOrdenados = new TreeMap<>();
        this.pedidos= new ArrayList<>();
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


    public  int mostrarMenuPrincipal() {

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

            switch(opcion){
                case 1->{
                    menu();
                    System.out.println("\nPulsa ENTER para volver al menú principal...");
                    sc.nextLine(); // limpiar buffer
                }
                case 2 ->pedido();
                //case 0 -> System.out.println("Salir");
                //default -> System.out.println("saliendo");
            }

    }

    private void cerrarRecurso(){

        CafeteriaDigital.sc.close();
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


    private int leerEntero(){
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

    private void pedido(){

        System.out.println("Nombre Cliente");
        String nombre = sc.nextLine();


        System.out.println("Producto: ");
        String producto = sc.nextLine();


    }

}







/*
Tiene  nombre las columnas de las tablas??
pdf Pedro
como se pasa al pedido que es un array


Hodl Hodl

 */