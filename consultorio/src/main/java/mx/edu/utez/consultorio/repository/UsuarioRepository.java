package mx.edu.utez.consultorio.repository;

import mx.edu.utez.consultorio.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
}
