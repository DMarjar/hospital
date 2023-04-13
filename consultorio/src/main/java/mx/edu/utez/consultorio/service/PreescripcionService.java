package mx.edu.utez.consultorio.service;

import mx.edu.utez.consultorio.model.Preescripcion;
import mx.edu.utez.consultorio.repository.PreescripcionRespository;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.CodecConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PreescripcionService {
    @Autowired
    private PreescripcionRespository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Preescripcion>> getAll(){
        List<Preescripcion> preescripciones = this.repository.findAll();
        if(preescripciones.isEmpty()){
            return new CustomResponse<>(null, true, 204, "No se encontraron preescripciones..");
        }
        return new CustomResponse<>(preescripciones, false, 200, "Son todas las preescripciones...");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Preescripcion> getOne(int id){
        Optional<Preescripcion> optionalPreescripcion = this.repository.findById(id);
        if(!optionalPreescripcion.isPresent()){
            return new CustomResponse<>(null, true, 404, "No se encontro la preescripcion...");
        }
        Preescripcion preescripcion = optionalPreescripcion.get();
        return new CustomResponse<>(preescripcion, false, 200, "Informacion de la preescripcion.");
    }

    @Transactional
    public CustomResponse<Preescripcion> insert(Preescripcion preescripcion){
        if(this.repository.existsById(preescripcion.getId())){
            return new CustomResponse<>(null, true, 400, "El ID de la preescripcion ya existe");
        }
        Preescripcion preescripcionSave = this.repository.save(preescripcion);
        return new CustomResponse<>(preescripcionSave, false, 200, "Informacion de la preescripcion registrada correctamente");
    }

    @Transactional
    public CustomResponse<Preescripcion> update(int id, Preescripcion preescripcion){
        if(!this.repository.existsById(id)){
            return new CustomResponse<>(null, true, 404, "La preescripcion a modificar no existe");
        }
        preescripcion.setId(id);;
        Preescripcion preescripcionUpdate = this.repository.save(preescripcion);
        return new CustomResponse<>(preescripcionUpdate, false, 200, "Informacion de la preescripcion actualizada ");
    }

    @Transactional
    public CustomResponse<String> delete(int id){
        Optional<Preescripcion> preescripcionDelete = this.repository.findById(id);
        if(!preescripcionDelete.isPresent()){
            return new CustomResponse<>(null, true, 404, "La preescripcion a eliminar no existe..");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(null, false, 200, "Preescripcion eliminada correctamte.");
    }

}
