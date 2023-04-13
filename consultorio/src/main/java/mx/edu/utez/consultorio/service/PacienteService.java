package mx.edu.utez.consultorio.service;

import mx.edu.utez.consultorio.model.Paciente;
import mx.edu.utez.consultorio.repository.PacienteRepository;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Paciente>> getAll() {
        List<Paciente> pacientes = this.repository.findAll();
        if (pacientes.isEmpty()) {
            return new CustomResponse<>(null, true, 204, "No se encontraron pacientes..");
        }
        return new CustomResponse<>(pacientes, false, 200, "Son todos los pacientes.");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Paciente> getOne(int id) {
        Optional<Paciente> optionalPaciente = this.repository.findById(id);
        if (!optionalPaciente.isPresent()) {
            return new CustomResponse<>(null, true, 404, "No se encontro el paciente...");
        }
        Paciente paciente = optionalPaciente.get();
        return new CustomResponse<>(paciente, false, 200, "Informacion del paciente.");
    }

    @Transactional
    public CustomResponse<Paciente> insert(Paciente paciente) {
        if (this.repository.existsById(paciente.getId())) {
            return new CustomResponse<>(null, true, 400, "El ID de la paciente ya existe");
        }
        Paciente pacienteSave = this.repository.save(paciente);
        return new CustomResponse<>(pacienteSave, false, 200, "Informacion del paciente registrado.");
    }
    
    @Transactional
    public CustomResponse<Paciente> update(int id, Paciente paciente){
        if(!this.repository.existsById(id)){
            return new CustomResponse<>(null, true, 404, "El paciente a modificar no existe");
        }
        paciente.setId(id);
        Paciente pacienteUpdate = this.repository.save(paciente);
        return new CustomResponse<>(pacienteUpdate, false, 200, "Informacion del paciente actualizada");
    }

    @Transactional
    public CustomResponse<String> delete(int id){
        Optional<Paciente> pacienteDelete = this.repository.findById(id);
        if(!pacienteDelete.isPresent()){
            return new CustomResponse<>(null, true, 404, "El paciente a eilimar no existe");
        }
        this.repository.deleteById(id);;
        return new CustomResponse<>(null, false, 200, "Paciente eliminado correctamente");
    }

}
