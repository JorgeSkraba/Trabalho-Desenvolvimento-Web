package _Bimestre.demo.model.service;

import _Bimestre.demo.model.entity.Aluno;
import _Bimestre.demo.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImp  implements AlunoService{
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean novoAluno (Aluno aluno) throws Exception {
        try {
            aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
            repository.save(aluno);
            return true;
        }catch (Exception e) {
            throw new Exception("Ocorreu um erro ao tentar criar um aluno. \n" + e.getMessage());
        }
    }

    @Override
    public List<Aluno> getAlunos() {
        return (List<Aluno>) repository.findAll();
    }

    @Override
    public Aluno getAlunoPorId(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Aluno não encontrado"));
    }

    @Override
    public Boolean apagarAluno(Long id) throws Exception {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        } else {
            throw new IllegalArgumentException("Aluno não encontrado");
        }
    }

    @Override
    public Aluno buscarPorEmail(String email){
        if(repository.findByEmail(email) != null){
            return repository.findByEmail(email);
        } else{
            throw new IllegalArgumentException("Email não encontrado");
        }
    }
}
