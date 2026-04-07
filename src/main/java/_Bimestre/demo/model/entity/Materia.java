package _Bimestre.demo.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String descricao;

    @ElementCollection
    @CollectionTable(
        name = "materia_horario",
            joinColumns = @JoinColumn(name = "materia_id")
    )
    private List<String> horarios;

    public Materia(String nome, List<String> horarios, String descricao) {
        this.nome = nome;
        this.horarios = horarios;
        this.descricao = descricao;
    }

    public Materia(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String horarios = String.join(", ", this.horarios);

        return "Materia{" +
                "nome='" + nome + '\'' +
                "horarios='" + horarios + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}