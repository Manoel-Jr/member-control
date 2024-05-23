package br.com.systemmembercontrol.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "christians")
public class Christian extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String baptized;
}
