package br.com.systemmembercontrol.model.dto.response;

import br.com.systemmembercontrol.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse implements Serializable {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private Profile profile;
    private LocalDate birthday;
    private LocalDate dataCreation;
}
