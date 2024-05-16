package br.com.systemmembercontrol.model;

import br.com.systemmembercontrol.enums.Profile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    @Column
    private LocalDate birthday;

    @Column
    private LocalDate dataCreation = LocalDate.now();
}
