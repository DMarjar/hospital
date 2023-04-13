package mx.edu.utez.consultorio.service;

import mx.edu.utez.consultorio.model.Consultorio;
import mx.edu.utez.consultorio.repository.ConsultorioRepository;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultorioService {
    @Autowired
    private ConsultorioRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Consultorio>> getAll(){
        List<Consultorio> consultorios = this.repository.findAll();
        if(consultorios.isEmpty()){
            return new CustomResponse<>(null, true, 204, "No se encontraron consultorios..");
        }
        return new CustomResponse<>(consultorios, false, 200, "son todos los consultorios.");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Consultorio> getOne(int id){
        Optional<Consultorio> optionalConsultorio = this.repository.findById(id);
        if(!optionalConsultorio.isPresent()){
            return new CustomResponse<>(null, true, 404, "No se encontro el consultorio..");
        }
        Consultorio consultorio = optionalConsultorio.get();
        return new CustomResponse<>(consultorio, false, 200, "Informacion del consultorio.");
    }

    @Transactional
    public CustomResponse<Consultorio> insert(Consultorio consultorio) {
        if (this.repository.existsById(consultorio.getId())) {
            return new CustomResponse<>(null, true, 400, "El ID del consultorio ya existe");
        }
        Consultorio consultorioSave = this.repository.save(consultorio);
        return new CustomResponse<>(consultorioSave, false, 200, "Informacion del consultorio registrada correctamente");
    }

    @Transactional
    public CustomResponse<Consultorio> update(int id, Consultorio consultorio){
        if(!this.repository.existsById(id)){
            return new CustomResponse<>(null, true, 404, "La medicina a modificar no existe");
        }
        consultorio.setId(id);
        Consultorio consultorioUpdate = this.repository.save(consultorio);
        return new CustomResponse<>(consultorioUpdate, false, 200, "Informacion del consultorio actualizada");
    }


    @Transactional
    public CustomResponse<String> delete(int id){
        Optional<Consultorio> consultorioDelete = this.repository.findById(id);
        if(!consultorioDelete.isPresent()){
            return new CustomResponse(null, true, 404, "El consultorio a eliminar no existe..");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(null, false, 200,  "Consultorio eliminado correctamente.");
    }
}
