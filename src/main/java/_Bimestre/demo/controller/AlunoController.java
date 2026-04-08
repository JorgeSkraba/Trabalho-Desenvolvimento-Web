package _Bimestre.demo.controller;

import _Bimestre.demo.model.entity.Aluno;
import _Bimestre.demo.model.entity.Materia;
import _Bimestre.demo.model.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping("/novo")
    public ResponseEntity<?> novoAluno(@RequestBody Aluno aluno) {
        try{
            Boolean criou = alunoService.novoAluno(aluno);
            if(criou) {
                return ResponseEntity.status(201).body(true);
            } else {
                return ResponseEntity.badRequest().body(false);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos(){
        List<Aluno> alunos = alunoService.getAlunos();
        if(!alunos.isEmpty()) {
            return ResponseEntity.status(200).body(alunos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlunoPorId(@PathVariable("id") Long id){
        try{
            Aluno aluno = alunoService.getAlunoPorId(id);
            return ResponseEntity.ok(aluno);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarMateriaPorId(@RequestBody Aluno aluno) {
        return ResponseEntity.status(400).body(false);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagarAluno(@PathVariable("id") Long id) {
        try {
            Boolean deletou = alunoService.apagarAluno(id);
            if(deletou) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
