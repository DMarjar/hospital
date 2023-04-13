package mx.edu.utez.consultorio.service;

import mx.edu.utez.consultorio.model.Usuario;
import mx.edu.utez.consultorio.repository.UsuarioRepository;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Usuario>> getAll(){
        List<Usuario> usuarios = this.repository.findAll();
        if(usuarios.isEmpty()){
            return new CustomResponse<>(null, true, 204, "No se encontraron usuarios..");
        }
        return new CustomResponse<>(usuarios, false, 200, "Son todos los usuarios.");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Usuario> getOne(int id){
        Optional<Usuario> optionalUsuario = this.repository.findById(id);
        if(!optionalUsuario.isPresent()){
            return new CustomResponse<>(null, false, 404, "No se encontro el usuario..");
        }
        Usuario usuario = optionalUsuario.get();
        return new CustomResponse<>(usuario, false, 200, "Informacion del usuario.");
    }

    @Transactional
    public CustomResponse<Usuario> insert(Usuario usuario){
        if(this.repository.existsById(usuario.getId())){
            return new CustomResponse<>(null, true, 400, "El ID del usuario ya existe");
        }
        Usuario usuarioSave = this.repository.save(usuario);
        return new CustomResponse<>(usuarioSave, false, 200, "Informacion del usuario registrado correctamente");
    }

    @Transactional
    public CustomResponse<Usuario> update(int id, Usuario usuario){
        if(!this.repository.existsById(id)){
            return new CustomResponse<>(null, false, 404, "El usuario a modificar no existe");
        }
        usuario.setId(id);
        Usuario usuarioUpdate = this.repository.save(usuario);
        return new CustomResponse<>(usuarioUpdate, false, 200, "Informacion del usuario actualizada");
    }

    @Transactional
    public CustomResponse<String> delete(int id){
        Optional<Usuario> usuarioDelete = this.repository.findById(id);
        if(!usuarioDelete.isPresent()){
            return new CustomResponse<>(null, true, 404, "El usuario a eliminar no existe..");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(null, false, 200, "Usuario eliminado correctamte.");
    }


}
