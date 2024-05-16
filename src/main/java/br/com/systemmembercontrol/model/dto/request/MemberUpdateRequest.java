package br.com.systemmembercontrol.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdateRequest {

    private String email;
    private String phone;
}
