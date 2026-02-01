package vistas;

import modelos.Productos;
import modelos.Usuarios;
import utils.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Usuarios iniciales vacíos
        Usuarios usuario1 = new Usuarios(null, null, null);
        Usuarios usuario2 = new Usuarios(null, null, null);

        while(true) { // Bucle principal de la app para volver al menú de inicio
            Usuarios usuarioActivo = null;

            // Cabecera de la app
            System.out.println(Utils.cabecera());

            // Menú inicial: Login, Registro o Salir
            String opcionInicial;
            do {
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrar nuevo usuario");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                opcionInicial = s.nextLine();

                switch(opcionInicial) {
                    case "1":
                        usuarioActivo = iniciarSesion(s, usuario1, usuario2);
                        break;
                    case "2":
                        usuarioActivo = registrarUsuario(s, usuario1, usuario2);
                        break;
                    case "3":
                        System.out.println("Saliendo de la aplicación...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while(usuarioActivo == null);

            // Programa principal
            String op;
            do {
                Utils.pulsaContinuar(s);
                op = pintaMenu(s);

                switch (op) {
                    case "1": mostrarDatosUsuario(usuarioActivo); break;
                    case "2": modificarDatosUsuario(s, usuarioActivo, usuario1, usuario2); break;
                    case "3": mostrarProductosUsuario(usuarioActivo); break;
                    case "4": introducirNuevoProducto(s, usuarioActivo); break;
                    case "5": verTodasLasVentas(usuario1, usuario2); break;
                    case "6": venderProducto(s, usuarioActivo, 1); break;
                    case "7": venderProducto(s, usuarioActivo, 2); break;
                    case "8": cerrarOBorrarVenta(s, usuarioActivo); break;
                    case "9":
                        System.out.println("Volviendo al menú de inicio...");
                        op = "salir"; // rompe este bucle y vuelve al while principal
                        break;
                    default: Utils.opErroneo();
                }

            } while (!op.equals("salir"));
        }
    }

    // =====================================================
    // INICIAR SESIÓN CON 3 INTENTOS
    // =====================================================
    static Usuarios iniciarSesion(Scanner s, Usuarios u1, Usuarios u2) {
        Usuarios u = null;
        String email, clave;
        int intentos = 0;

        do {
            if(intentos >= 3) {
                System.out.println("Has superado 3 intentos. Volviendo al menú principal.");
                return null;
            }

            System.out.print("Email: ");
            email = s.nextLine();
            System.out.print("Clave: ");
            clave = s.nextLine();

            if (u1.getEmail() != null && u1.credencialesCorrectas(email, clave) && u1.isValidado()) u = u1;
            if (u2.getEmail() != null && u2.credencialesCorrectas(email, clave) && u2.isValidado()) u = u2;

            // Usuario no validado
            if (u == null) {
                if (u1.getEmail() != null && u1.credencialesCorrectas(email, clave) && !u1.isValidado()) u = pedirToken(s, u1);
                else if (u2.getEmail() != null && u2.credencialesCorrectas(email, clave) && !u2.isValidado()) u = pedirToken(s, u2);
                else {
                    System.out.println("Email o clave incorrectos.");
                    Utils.pulsaContinuar(s);
                    intentos++;
                }
            }

        } while(u == null);

        System.out.println("Bienvenido " + u.getNombre());
        return u;
    }

    // =====================================================
    // PEDIR TOKEN
    // =====================================================
    static Usuarios pedirToken(Scanner s, Usuarios u) {
        System.out.println("Debes validar tu email. Se ha enviado un token a tu correo.");
        u.generarYEnviarToken();
        String token;
        do {
            System.out.print("Introduce el token enviado por email: ");
            token = s.nextLine();
        } while(!u.validarToken(token));
        return u;
    }

    // =====================================================
    // REGISTRAR NUEVO USUARIO
    // =====================================================
    static Usuarios registrarUsuario(Scanner s, Usuarios u1, Usuarios u2) {
        System.out.print("Nombre: ");
        String nombre = s.nextLine();

        String email;
        do {
            System.out.print("Email: ");
            email = s.nextLine();
            if ((u1.getEmail() != null && email.equals(u1.getEmail())) ||
                    (u2.getEmail() != null && email.equals(u2.getEmail()))) {
                System.out.println("Email ya registrado. Intenta con otro.");
                email = null;
            }
        } while(email == null);

        System.out.print("Clave: ");
        String clave = s.nextLine();

        // Crear usuario nuevo
        Usuarios nuevo;
        if (u1.getEmail() == null) nuevo = u1;
        else nuevo = u2;

        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setClave(clave);
        nuevo.generarYEnviarToken();

        // Validar token
        String token;
        do {
            System.out.print("Introduce el token enviado a tu email: ");
            token = s.nextLine();
        } while(!nuevo.validarToken(token));

        return nuevo;
    }

    // =====================================================
    // MENÚ PRINCIPAL
    // =====================================================
    public static String pintaMenu(Scanner s) {
        System.out.println(Utils.menuPrincipal());
        return s.nextLine();
    }

    // =====================================================
    // FUNCIONES DE USUARIO
    // =====================================================
    public static void mostrarDatosUsuario(Usuarios u) { System.out.println(u); }

    public static void modificarDatosUsuario(Scanner s, Usuarios u, Usuarios u1, Usuarios u2) {
        System.out.print("Nuevo nombre: ");
        String nombre = s.nextLine();
        System.out.print("Nuevo email: ");
        String email = s.nextLine();
        System.out.print("Nueva clave: ");
        String clave = s.nextLine();

        // Evitar email duplicado
        if ((!u.equals(u1) && email.equals(u1.getEmail())) ||
                (!u.equals(u2) && email.equals(u2.getEmail()))) {
            System.out.println("Email ya existe, no se puede cambiar.");
            return;
        }

        u.modificarDatosPersonales(nombre, email, clave);
        System.out.println("Datos actualizados. Debes validar tu email si cambiaste el correo.");
    }

    public static void mostrarProductosUsuario(Usuarios u) {
        if (!u.producto1ocupado() && !u.producto2ocupado())
            System.out.println("No tienes productos en venta.");
        else
            System.out.println(u.productosALaVenta());
    }

    public static void introducirNuevoProducto(Scanner s, Usuarios u) {
        if (u.producto1ocupado() && u.producto2ocupado()) {
            System.out.println("Ya tienes dos productos a la venta.");
            return;
        }

        System.out.print("Nombre del producto: ");
        String nombre = s.nextLine();

        double precio = 0;
        boolean correcto = false;
        do {
            System.out.print("Precio: ");
            try {
                precio = Double.parseDouble(s.nextLine());
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        } while (!correcto);

        int id = u.numAleatorio100k();
        Productos p = new Productos(id, nombre, precio, u.getEmail());

        u.agregarProducto(p); // envía email + telegram automáticamente
        System.out.println("Producto añadido correctamente.");
    }

    public static void verTodasLasVentas(Usuarios u1, Usuarios u2) {
        System.out.println(u1.todasVentas());
        System.out.println(u2.todasVentas());
    }

    public static void cerrarOBorrarVenta(Scanner s, Usuarios u) {
        System.out.println(Utils.op8());
        String op = s.nextLine();

        if (!u.producto1ocupado() && !u.producto2ocupado()) {
            System.out.println("No tienes productos en venta.");
            return;
        }

        System.out.println(u.productosALaVenta());
        System.out.print("Producto (1-2): ");
        String prod = s.nextLine();

        if (op.equals("1")) {
            if (prod.equals("1")) System.out.println(u.borrarProducto1());
            else if (prod.equals("2")) System.out.println(u.borrarProducto2());
        }

        if (op.equals("2")) {
            if (prod.equals("1")) System.out.println(u.venderProducto1());
            else if (prod.equals("2")) System.out.println(u.venderProducto2());
        }
    }

    // =====================================================
    // FUNCIONES PARA VENDER DIRECTO
    // =====================================================
    public static void venderProducto(Scanner s, Usuarios u, int numProducto) {
        if (numProducto == 1) System.out.println(u.venderProducto1());
        else if (numProducto == 2) System.out.println(u.venderProducto2());
    }
}
