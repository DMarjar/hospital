package mx.edu.utez.consultorio.repository;

import mx.edu.utez.consultorio.model.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, Integer> {
}
