package _Bimestre.demo.model.service;

import _Bimestre.demo.model.entity.Aluno;

import java.util.List;

public interface AlunoService {
    Boolean novoAluno(Aluno aluno) throws Exception;
    List<Aluno> getAlunos();
    Aluno getAlunoPorId(Long id) throws Exception;
    Boolean apagarAluno(Long id) throws Exception;
    Aluno buscarPorEmail(String email);
}
