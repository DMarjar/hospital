package mx.edu.utez.consultorio.repository;

import mx.edu.utez.consultorio.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Integer> {
}
