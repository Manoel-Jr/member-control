package br.com.systemmembercontrol.excepion.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

    private LocalDateTime timestemp;
    private Integer status;
    private String error;
    private String path;
}
