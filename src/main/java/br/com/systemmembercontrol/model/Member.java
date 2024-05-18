package br.com.systemmembercontrol.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "members")
public class Member extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
