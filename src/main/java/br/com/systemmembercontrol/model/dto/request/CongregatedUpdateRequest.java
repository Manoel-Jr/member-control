package br.com.systemmembercontrol.model.dto.request;

import br.com.systemmembercontrol.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongregatedUpdateRequest {

    private String phone;
    private Profile profile;
    private String email;
}
