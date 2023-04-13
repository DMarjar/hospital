package mx.edu.utez.consultorio.service;

import mx.edu.utez.consultorio.model.Medicina;
import mx.edu.utez.consultorio.model.Medico;
import mx.edu.utez.consultorio.repository.MedicoRepository;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Medico>> getAll(){
        List<Medico> medicos = this.repository.findAll();
        if(medicos.isEmpty()){
            return new CustomResponse<>(null, true, 204, "No se encontraron medicos..");
        }
        return new CustomResponse<>(medicos, false, 200, "Son todos los medicos.");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Medico> getOne(int id){
        Optional<Medico> optionalMedico = this.repository.findById(id);
        if(!optionalMedico.isPresent()){
            return new CustomResponse<>(null, true, 404, "No se encontro el medico.");
        }
        Medico medico = optionalMedico.get();
        return new CustomResponse<>(medico, false, 200,"Informacion del medico.");
    }

    @Transactional
    public CustomResponse<Medico> insert(Medico medico){
        if(this.repository.existsById(medico.getId())){
            return new CustomResponse<>(null, true, 400, "El ID del medico ya existe");
        }
        Medico medicoSave = this.repository.save(medico);
        return new CustomResponse<>(medicoSave, false, 200, "Informacion del medico registrado correctamente");
    }

    @Transactional
    public CustomResponse<Medico> update(int id, Medico medico){
        if(!this.repository.existsById(id)){
            return new CustomResponse<>(null, true, 404, "El medico a modificar no existe");
        }
        medico.setId(id);
        Medico medicoUpdate = this.repository.save(medico);
        return new CustomResponse<>(medicoUpdate, false, 200, "Informacion de la medico actualizada");
    }

    @Transactional
    public CustomResponse<String> delete(int id){
        Optional<Medico> medicoDelete = this.repository.findById(id);
        if(!medicoDelete.isPresent()){
            return new CustomResponse(null, true, 404, "El medico a eliminar no existe..");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(null, false, 200,  "Medico eliminado correctamente.");
    }

}
