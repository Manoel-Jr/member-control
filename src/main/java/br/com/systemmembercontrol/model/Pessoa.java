package br.com.systemmembercontrol.model;

import br.com.systemmembercontrol.enums.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa  implements  Serializable {

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
