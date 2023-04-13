package mx.edu.utez.consultorio.model;

public class Consultorio {
    private int id;
    private String piso;
    private Medico medico;

public Consultorio(int id, String piso, Medico medico) {
        this.id = id;
        this.piso = piso;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
