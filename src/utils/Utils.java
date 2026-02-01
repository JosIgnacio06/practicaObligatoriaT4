package utils;

import java.util.Scanner;

public class Utils {
        private static void limpiarPantalla(){
             for (int i = 0; i < 5; i++) {
                System.out.println();
            }
        }
        public static void pulsaContinuar(Scanner s) {
            System.out.print("Pulsa ENTER para continuar: ");
            s.nextLine();
            limpiarPantalla();
        }

        public static String menuPrincipal(){
            String menu = "********************************** \n";
            menu += "Menú de usuario \n";
            menu += "1. Mostrar mi perfil de usuario.\n";
            menu += "2. Cambiar mis datos personales.\n";
            menu += "3. Ver mis productos en venta.\n";
            menu += "4. Poner a la venta un nuevo producto.\n";
            menu += "5. Ver todos los productos a la venta en mi aplicación.\n";
            menu += "6. Ver mi histórico de ventas.\n";
            menu += "7. Ver mi histórico de compras.\n";
            menu += "8. Cerrar la venta de un producto o quitarlo de la venta.\n";
            menu += "9. Salir.\n";
            menu += "Introduzca la opción deseada: \n";
            return menu;
        }

        public static String cabecera(){
            String cabecera = "Bienvenido al programa FernanPop \n";
                cabecera += "Compra y vende tus artículos en nuestro Centro \n";
            cabecera += "================================================= \n";
            return cabecera;
        }

        public static String op8(){
            String menu8 = "1. Borrar producto.";
            menu8 += "\n2. Comprar producto.";
            menu8 += "\nSeleccione una opción: ";
            return menu8;
        }

        public static void salir(){
            System.out.println("Cerrando sesión...");
        }

        public static void opErroneo(){
            System.out.println("Escribe un valor definido en el menú.");
        }
}
