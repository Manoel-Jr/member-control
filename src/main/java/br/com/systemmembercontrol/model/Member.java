package br.com.systemmembercontrol.model;

import br.com.systemmembercontrol.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member extends Pessoa{

//    @Id


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String name;
//
//    @Column
//    private String phone;
//
//    @Column(unique = true)
//    private String email;
//
//    @Enumerated(EnumType.STRING)
//    private Profile profile;
//
//    private LocalDate birthday;
//
//    private LocalDate dataCreation = LocalDate.now();
}
