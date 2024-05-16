package br.com.systemmembercontrol.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "congregados")
@NoArgsConstructor
@AllArgsConstructor
public class Congregated extends Pessoa implements Serializable {
}
