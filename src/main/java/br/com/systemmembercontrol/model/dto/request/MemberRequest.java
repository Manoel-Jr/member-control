package br.com.systemmembercontrol.model.dto.request;

import br.com.systemmembercontrol.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest implements Serializable {

    private String name;
    private String phone;
    private String email;
    private Profile profile;
    private LocalDate birthday;
}
