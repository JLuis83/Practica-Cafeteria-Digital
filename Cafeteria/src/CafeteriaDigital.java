import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


        public class CafeteriaDigital {

            public static class datos {
                public static Scanner sc = new Scanner(System.in);
                public static ArrayList<String> arrayPedido = new ArrayList<>();
                public static LinkedList<String> linkPedido = new LinkedList<>();
                public static ArrayList<String> arrayProductos = new ArrayList<>();
            }

            public static void main(String[] args) {

                int opcion;


                do{
                    System.out.println("Menu Cafeteria");
                    System.out.println("1-Añadir pedido");
                    System.out.println("2-Mostrar pedido");
                    System.out.println("3-Mostrar menú");
                    System.out.println("4-Siguiente pedido");
                    System.out.println("0-Salir");
                    System.out.println("Elige una opcion");


                    opcion = datos.sc.nextInt();
                    datos.sc.nextLine();



                    switch (opcion) {
                        case 1 -> anadirPedido();
                        case 2 -> mostrarPedido();
                        case 3 -> mostrarProductos();
                        case 4 -> System.out.println("Siguiente pedido");
                        case 0 -> System.out.println("Saliendo....");
                        default -> System.out.println("Opcion no valida");
                    }
                } while (opcion != 0);

            }

            public static void anadirPedido() {


                System.out.println("Mostrar Menu");
                datos.arrayProductos.add("Cafe");
                datos.arrayProductos.add("Donuts");
                datos.arrayProductos.add("Té");
                datos.arrayProductos.add("Tostadas");
                datos.arrayProductos.add("Churros");
                datos.arrayProductos.add("Te verde");
                datos.arrayProductos.add("Mermelada");
                datos.arrayProductos.add("Leche");
                datos.arrayProductos.add("Cereales");


                int opcion;

                do {
                    for (int i = 0; i < datos.arrayProductos.size(); i++) {
                        System.out.println((i + 1) + "-" + datos.arrayProductos.get(i));
                    }


                    System.out.println("Elige tu menú");
                    opcion = datos.sc.nextInt();
                    datos.sc.nextLine();

                    //chatgpt
                    if (opcion > 0 && opcion <= datos.arrayProductos.size()) {
                        String elegido = datos.arrayProductos.get(opcion - 1);
                        datos.arrayPedido.add(elegido);
                        System.out.println("Añadido: " + elegido);
                    } else if (opcion != 0) {
                        System.out.println("No valido");

                    }
                }while (opcion !=0);

                System.out.println("\nPEDIDO FINAL:");
                datos.arrayPedido.forEach(seleccionado -> System.out.println("- " + seleccionado));//chatgpt

                System.out.println("Pulsa Enter para continuar");
                datos.sc.nextLine();
            }

            public static void mostrarPedido() {


            }


            public static void mostrarProductos() {


                System.out.println("Mostrar Menu (Pulsa 0 para salir)");
                System.out.println("=================================");
                System.out.println("Cafe - 1,20");
                System.out.println("Donuts - 2,00");
                System.out.println("Té - 1,50");
                System.out.println("Tostadas - 1,70");
                System.out.println("Churros - 2,50");
                System.out.println("Te verde - 1,30");
                System.out.println("Mermelada - 1,60");
                System.out.println("Leche - 1,80");
                System.out.println("Cereales - 1,70");
                System.out.println("=================================");
            }

        }

/*
        String nombreCliente= "";

                System.out.println("Introduce tu nombre: ");
        nombreCliente= datos.sc.nextLine();
*/