package mx.edu.utez.consultorio.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "pacientes")
public class Paciente {
    @MongoId
    private int id;
    private String nombre;

    private String apellidos;

    private int numeroSeguro;

    private Sexo sexo;

    private double alturaMetros;

    private double pesoKg;

    private int edad;

    public Paciente(int id, String nombre, String apellidos, int numeroSeguro, Sexo sexo, double alturaMetros, double pesoKg, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroSeguro = numeroSeguro;
        this.sexo = sexo;
        this.alturaMetros = alturaMetros;
        this.pesoKg = pesoKg;
        this.edad = edad;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(int numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getAlturaMetros() {
        return alturaMetros;
    }

    public void setAlturaMetros(double alturaMetros) {
        this.alturaMetros = alturaMetros;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
