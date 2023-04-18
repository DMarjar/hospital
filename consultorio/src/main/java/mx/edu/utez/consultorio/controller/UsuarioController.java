package mx.edu.utez.consultorio.controller;

import mx.edu.utez.consultorio.model.Usuario;
import mx.edu.utez.consultorio.service.UsuarioService;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Usuario>>> getAll(){
        System.out.println("GET ALL Usuario");
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> getOne(@PathVariable int id){
        System.out.println("GET ONE Usuario");
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Usuario>> insert(@Valid @RequestBody Usuario usuario){
        System.out.println("INSERT Usuario");
        return new ResponseEntity<>(
                this.service.insert(usuario),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> update(@PathVariable int id, @Valid @RequestBody Usuario usuario){
        System.out.println("PUT Usuario");
        return new ResponseEntity<>(
                this.service.update(id, usuario),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<String>> delete(@PathVariable int id){
        System.out.println("DELETE Usuario");
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

}
