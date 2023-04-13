package mx.edu.utez.consultorio.controller;


import mx.edu.utez.consultorio.model.Preescripcion;
import mx.edu.utez.consultorio.service.PreescripcionService;
import mx.edu.utez.consultorio.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital/prescripcion")
public class PreescripcionController {
    @Autowired
    private PreescripcionService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Preescripcion>>> getAll(){
        System.out.println("GET ALL Preescripcion");
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Preescripcion>> getOne(@PathVariable int id){
        System.out.println("GET ONE Preescripcion");
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Preescripcion>> insert(@Valid @RequestBody Preescripcion preescripcion){
        System.out.println("INSERT Preescripion");
        return  new ResponseEntity<>(
                this.service.insert(preescripcion),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<Preescripcion>> update(@PathVariable int id, @Valid @RequestBody Preescripcion preescripcion){
        System.out.println(" PUT Preescripion");
        return new ResponseEntity<>(
                this.service.update(id, preescripcion),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<String>> delete(@PathVariable int id){
        System.out.println("DELETE Preescripion");
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

}
