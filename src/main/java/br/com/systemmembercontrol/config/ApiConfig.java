package br.com.systemmembercontrol.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ModelMapper model(){
        return new ModelMapper();
    }
}
