package _Bimestre.demo.security;

import _Bimestre.demo.model.entity.Aluno;
import _Bimestre.demo.model.service.AlunoService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetails implements UserDetailsService {

    private AlunoService alunoService;

    public CustomUserDetails(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Aluno aluno = alunoService.buscarPorEmail(email);

        if (aluno == null){
            throw new UsernameNotFoundException("usuário não encontrado");
        }

        return User.builder()
                .username(aluno.getEmail())
                .password(aluno.getSenha())
                .roles(aluno.getPapeisString().toArray(new String [0]))
                .build();
    }
}
