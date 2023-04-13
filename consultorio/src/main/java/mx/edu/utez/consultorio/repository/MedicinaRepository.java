package mx.edu.utez.consultorio.repository;

import mx.edu.utez.consultorio.model.Medicina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinaRepository extends MongoRepository<Medicina, Integer> {
    //void deleteById(int id);
}
