package _Bimestre.demo.controller;

import _Bimestre.demo.model.entity.Materia;
import _Bimestre.demo.model.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping("/novo")
    public ResponseEntity<?> novaMateria(@RequestBody Materia materia) {
        try{
            Boolean criou = materiaService.novaMateria(materia);
            if(criou) {
                return ResponseEntity.status(201).body(true);
            } else {
                return ResponseEntity.badRequest().body(false);
            }
        }   catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Materia>> getMateriais() {
        List<Materia> materias = materiaService.getMaterias();
        if(!materias.isEmpty()){
            return ResponseEntity.status(200).body(materias);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMateriaPorId(@PathVariable("id") Long id) {
        try {
            Materia materia = materiaService.getMateriaPorId(id);
            return ResponseEntity.ok(materia);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarMateriaPorId(@RequestBody Materia materia) {
        return ResponseEntity.status(400).body(false);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagarMateria(@PathVariable("id") Long id) {
        try {
            materiaService.apagarMateria(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
