package _Bimestre.demo.model.service;

import _Bimestre.demo.model.entity.Materia;
import _Bimestre.demo.model.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImp implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    @Override
    public Boolean novaMateria(Materia materia) throws Exception {
        try {
            repository.save(materia);
            return true;
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro ao tentar criar um produto. \n" + e.getMessage());
        }
    }

    @Override
    public List<Materia> getMaterias() {
        return (List<Materia>) repository.findAll();
    }

    @Override
    public Materia getMateriaPorId(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow( () -> new Exception("Matéria não encontrada"));
    }

    @Override
    public Boolean apagarMateria(Long id) throws Exception {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        } else {
            throw new IllegalArgumentException("Materia não encontrada");
        }
    }
}
