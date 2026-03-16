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
    public Papel (Long id)
}
