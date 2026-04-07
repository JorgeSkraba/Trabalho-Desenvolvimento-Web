package _Bimestre.demo.model.repository;

import _Bimestre.demo.model.entity.Materia;
import org.springframework.data.repository.CrudRepository;

public interface MateriaRepository extends CrudRepository <Materia, Long> {
}
