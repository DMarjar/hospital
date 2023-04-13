package mx.edu.utez.consultorio.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "medicinas")
public class Medicina {
    @MongoId
    private int id;
    private String nombre;
    private String presentacion;
    private int cantidad;

    public Medicina(int id, String nombre, String presentacion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
