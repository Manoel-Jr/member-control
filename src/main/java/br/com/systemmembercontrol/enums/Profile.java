package br.com.systemmembercontrol.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum Profile {

    MEMBER(1, "MEMBER"),CONGREGATED(2, "CONGREGATED"),USER_MEMBER(3, "USER_MEMBER");

    private final Integer code;
    private final String description;

    Profile(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Profile toEnum(Integer code){
        if(code == null){
            return null;
        }
        for(Profile x : Profile.values()){
            if (code.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalArgumentException("Ivalid Profile!!");
    }
}
