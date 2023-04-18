package mx.edu.utez.consultorio.controller;

import mx.edu.utez.consultorio.model.Medico;
import mx.edu.utez.consultorio.service.MedicoService;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital/medico")
@CrossOrigin(origins = "*")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Medico>>> getALl(){
        System.out.println("GET ALL Medico");
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Medico>> getOne(@PathVariable int id){
        System.out.println("GET ONE Medico");
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Medico>> insert(@Valid @RequestBody Medico medico){
        System.out.println("INSERT Medico");
        return new ResponseEntity<>(
                this.service.insert(medico),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<Medico>> update(@PathVariable int id, @Valid @RequestBody Medico medico){
        System.out.println("PUT Medico");
        return new ResponseEntity<>(
                this.service.update(id, medico),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<String>> delete(@PathVariable int id){
        System.out.println("DELETE Medico");
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }


}
