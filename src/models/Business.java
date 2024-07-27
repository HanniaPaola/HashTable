package models;

public class Business {
    private String id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String estado;

    public Business(String id, String nombre, String direccion, String ciudad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Business [ID=" + id + ", Name=" + nombre + ", Address=" + direccion + ", City=" + ciudad + ", State= " + estado + "]";
    }

    public String getId() {
        return id;
    }
}
