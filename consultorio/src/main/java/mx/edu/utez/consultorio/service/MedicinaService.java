package mx.edu.utez.consultorio.service;

import mx.edu.utez.consultorio.model.Medicina;
import mx.edu.utez.consultorio.repository.MedicinaRepository;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicinaService {
    @Autowired
    private MedicinaRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Medicina>> getAll(){
        List<Medicina> medicinas = this.repository.findAll();
        if(medicinas.isEmpty()){
            return new CustomResponse<>(null, true, 204, "No se encontraron medicinas..");
        }
        return new CustomResponse<>(medicinas, false, 200, "son todas las medicinas.");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Medicina> getOne(int id){
        Optional<Medicina> optionalMedicina = this.repository.findById(id);
        if(!optionalMedicina.isPresent()){
            return new CustomResponse<>(null, true, 404, "No se encontro la medicina solicitada..");
        }
        Medicina medicina = optionalMedicina.get();
        return new CustomResponse<>(medicina, false, 200, "Informacion de la medicina.");
    }

    @Transactional
    public CustomResponse<Medicina> insert(Medicina medicina) {
        if (this.repository.existsById(medicina.getId())) {
            return new CustomResponse<>(null, true, 400, "El ID de la medicina ya existe");
        }
        Medicina medicinaSave = this.repository.save(medicina);
        return new CustomResponse<>(medicinaSave, false, 200, "Informacion de la medicina registrada correctamente");
    }

    @Transactional
    public CustomResponse<Medicina> update(int id, Medicina medicina){
        if(!this.repository.existsById(id)){
            return new CustomResponse<>(null, true, 404, "La medicina a modificar no existe");
        }
        medicina.setId(id);
        Medicina medicinaUpdate = this.repository.save(medicina);
        return new CustomResponse<>(medicinaUpdate, false, 200, "Informacion de la medicina actualizada");
    }


    @Transactional
    public CustomResponse<String> delete(int id){
        Optional<Medicina> medicinaDelete = this.repository.findById(id);
        if(!medicinaDelete.isPresent()){
            return new CustomResponse(null, true, 404, "La medicina a eliminar no existe..");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(null, false, 200,  "Medicina eliminada correctamente.");
    }

}
