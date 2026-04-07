package _Bimestre.demo.model.service;

import _Bimestre.demo.model.entity.Materia;

import java.util.List;

public interface MateriaService {
    Boolean novaMateria(Materia materia) throws Exception;
    List<Materia> getMaterias();
    Materia getMateriaPorId(Long id) throws Exception;
    Boolean apagarMateria(Long id) throws Exception;
}
