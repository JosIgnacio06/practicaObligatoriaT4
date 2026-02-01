package modelos;

import utils.EmailUtils;
import utils.TelegramUtils;

public class Usuarios {
    private String email;
    private String clave;
    private String nombre;

    private Productos producto1;
    private Productos producto2;

    private Productos producto1Vendido;
    private Productos producto2Vendido;

    private String token;
    private boolean validado;
    private boolean primerInicioSesion;

    // Constructor
    public Usuarios(String email, String clave, String nombre) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;

        this.producto1 = null;
        this.producto2 = null;
        this.producto1Vendido = null;
        this.producto2Vendido = null;

        this.validado = false;
        this.primerInicioSesion = true;

        this.token = ""; // token vacío al crear
    }

    // ======================= GETTERS / SETTERS =======================
    public String getEmail() { return email; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setClave(String clave) { this.clave = clave; }

    public boolean isValidado() { return validado; }
    public boolean isPrimerInicioSesion() { return primerInicioSesion; }
    public void setPrimerInicioSesion(boolean primerInicioSesion) { this.primerInicioSesion = primerInicioSesion; }

    public String getToken() { return token; }

    // ======================= SESIÓN =======================
    public boolean validarInicioSesion(String email, String clave){
        return this.validado && this.email.equals(email) && this.clave.equals(clave);
    }

    public boolean credencialesCorrectas(String email, String clave) {
        return this.email.equals(email) && this.clave.equals(clave);
    }

    // ======================= MODIFICAR DATOS =======================
    public void modificarDatosPersonales(String nombre, String email, String clave) {
        this.setNombre(nombre);
        this.setClave(clave);

        if (!this.email.equals(email)) {
            this.email = email;
            generarYEnviarToken(); // genera token y envía correo
            this.validado = false;
        }
    }

    // ======================= TOKEN =======================
    private static String generarToken() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            token.append(caracteres.charAt((int)(Math.random() * caracteres.length())));
        }
        return token.toString();
    }

    // Genera token y envía correo
    public void generarYEnviarToken() {
        if (email == null || email.isBlank()) {
            System.out.println("No se puede enviar token: email vacío o nulo");
            return;
        }

        this.token = generarToken();

        String asunto = "Código de verificación FernanPop";
        String cuerpo = "Hola " + this.nombre + ",\n\n" +
                "Tu código de verificación es: " + this.token + "\n\n" +
                "Introduce este código en la aplicación para validar tu correo.\n\n" +
                "Saludos,\nFernanPop Team";

        try {
            EmailUtils.enviarEmail(this.email, asunto, cuerpo);
            System.out.println("Se ha enviado un correo de verificación a " + this.email);
        } catch (Exception e) {
            System.out.println("ERROR: No se pudo enviar el correo. Revisa la conexión o la configuración de Gmail.");
            e.printStackTrace();
        }
    }

    public boolean validarToken(String tokenIntroducido) {
        if (tokenIntroducido == null || tokenIntroducido.isBlank()) {
            System.out.println("Token vacío. Intenta de nuevo.");
            return false;
        }

        if (this.token.equals(tokenIntroducido)) {
            this.validado = true;
            this.primerInicioSesion = false;
            System.out.println("Email validado correctamente.");
            return true;
        } else {
            System.out.println("Token incorrecto, inténtalo de nuevo.");
            return false;
        }
    }

    // ======================= PRODUCTOS =======================
    public boolean producto1ocupado() { return producto1 != null; }
    public boolean producto2ocupado() { return producto2 != null; }

    // ======================= AGREGAR PRODUCTO CON EMAIL Y TELEGRAM =======================
    public void agregarProducto(Productos p) {
        if (!producto1ocupado()) producto1 = p;
        else if (!producto2ocupado()) producto2 = p;
        else {
            System.out.println("Ya tienes 2 productos a la venta.");
            return;
        }

        // Enviar email al usuario
        String asunto = "Producto añadido en FernanPop";
        String cuerpo = "Hola " + nombre + ",\n\nHas añadido un nuevo producto:\n" +
                "Nombre: " + p.getNombre() + "\nPrecio: " + p.getPrecio() + "\nID: " + p.getId() + "\n\nGracias por usar FernanPop!";
        EmailUtils.enviarEmail(email, asunto, cuerpo);

        // Enviar Telegram al admin
        String mensajeAdmin = "Nuevo producto añadido por " + nombre + " (" + email + "):\n" +
                "Nombre: " + p.getNombre() + "\nPrecio: " + p.getPrecio() + "\nID: " + p.getId();
        TelegramUtils.enviarMensajeAdmin(mensajeAdmin);
    }

    // ======================= VENDER PRODUCTOS CON EMAIL Y TELEGRAM =======================
    public String venderProducto1() {
        if (!producto1ocupado()) return "No hay producto 1 a la venta.";

        Productos vendido = producto1;
        if (producto1Vendido == null) producto1Vendido = producto1;
        else producto2Vendido = producto1;
        producto1 = null;

        // Email al vendedor
        String asunto = "Producto vendido en FernanPop";
        String cuerpo = "Hola " + nombre + ",\n\nTu producto ha sido vendido:\n" +
                "Nombre: " + vendido.getNombre() + "\nPrecio: " + vendido.getPrecio() + "\nID: " + vendido.getId() +
                "\n\nGracias por usar FernanPop!";
        EmailUtils.enviarEmail(email, asunto, cuerpo);

        // Telegram al admin
        String mensajeAdmin = "Producto vendido:\nVendedor: " + nombre + " (" + email + ")\n" +
                "Nombre: " + vendido.getNombre() + "\nPrecio: " + vendido.getPrecio() + "\nID: " + vendido.getId();
        TelegramUtils.enviarMensajeAdmin(mensajeAdmin);

        return "Producto vendido con éxito.";
    }

    public String venderProducto2() {
        if (!producto2ocupado()) return "No hay producto 2 a la venta.";

        Productos vendido = producto2;
        if (producto2Vendido == null) producto2Vendido = producto2;
        else producto1Vendido = producto2;
        producto2 = null;

        // Email al vendedor
        String asunto = "Producto vendido en FernanPop";
        String cuerpo = "Hola " + nombre + ",\n\nTu producto ha sido vendido:\n" +
                "Nombre: " + vendido.getNombre() + "\nPrecio: " + vendido.getPrecio() + "\nID: " + vendido.getId() +
                "\n\nGracias por usar FernanPop!";
        EmailUtils.enviarEmail(email, asunto, cuerpo);

        // Telegram al admin
        String mensajeAdmin = "Producto vendido:\nVendedor: " + nombre + " (" + email + ")\n" +
                "Nombre: " + vendido.getNombre() + "\nPrecio: " + vendido.getPrecio() + "\nID: " + vendido.getId();
        TelegramUtils.enviarMensajeAdmin(mensajeAdmin);

        return "Producto vendido con éxito.";
    }

    // ======================= OTROS MÉTODOS =======================
    public String productosALaVenta() {
        String lista = "";
        if (producto1ocupado())
            lista += "Producto 1:\nNombre: " + producto1.getNombre() + "\nPrecio: " + producto1.getPrecio();
        if (producto2ocupado()) {
            if (!lista.isEmpty()) lista += "\n\n";
            lista += "Producto 2:\nNombre: " + producto2.getNombre() + "\nPrecio: " + producto2.getPrecio();
        }
        return lista;
    }

    public String historicoVentas() {
        String lista = "";
        if (producto1Vendido != null) lista += "Producto vendido:\nNombre: " + producto1Vendido.getNombre() + "\nPrecio: " + producto1Vendido.getPrecio() + "\n";
        if (producto2Vendido != null) lista += "Producto vendido:\nNombre: " + producto2Vendido.getNombre() + "\nPrecio: " + producto2Vendido.getPrecio();
        if (lista.isEmpty()) return "No has vendido ningún producto.";
        return lista;
    }

    public String historicoCompras() { return historicoVentas(); }

    public String borrarProducto1() { producto1 = null; return "Producto borrado."; }
    public String borrarProducto2() { producto2 = null; return "Producto borrado."; }

    public int numAleatorio100k() { return (int) (Math.random() * 100000) + 1; }

    public String todasVentas() {
        if (!producto1ocupado() && !producto2ocupado()) return "Usuario " + email + " no tiene productos en venta.";
        String lista = "Productos de " + nombre + ":\n";
        if (producto1ocupado()) lista += "Producto 1:\nNombre: " + producto1.getNombre() + "\nPrecio: " + producto1.getPrecio() + "\n";
        if (producto2ocupado()) lista += "Producto 2:\nNombre: " + producto2.getNombre() + "\nPrecio: " + producto2.getPrecio();
        return lista;
    }

    @Override
    public String toString() {
        return "Email= " + email + "\nNombre= " + nombre + "\nValidado= " + validado;
    }
}
