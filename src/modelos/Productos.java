package modelos;

public class Productos {
    private int id;
    private String nombre;
    private double precio;
    private String email;

    //Constructor
    public Productos(int id, String nombre, double precio, String email) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.email = email;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
