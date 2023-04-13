package mx.edu.utez.consultorio.repository;

import mx.edu.utez.consultorio.model.Preescripcion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreescripcionRespository extends MongoRepository<Preescripcion, Integer> {
}
