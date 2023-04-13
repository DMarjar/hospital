package mx.edu.utez.consultorio.repository;

import mx.edu.utez.consultorio.model.Consultorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepository extends MongoRepository<Consultorio, Integer> {
}
