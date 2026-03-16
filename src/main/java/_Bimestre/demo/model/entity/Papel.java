package _Bimestre.demo.model.entity;

import jakarta.persistence.*;

@Entity(name = "papeis")
public class Papel {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String papel;

    public Papel(){

    }
    public Papel (Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}
