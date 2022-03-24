package com.dlvsystem.elettrocablagginomsf.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf
{
    @Bean
    public static ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }

    public Conf()
    {
        //
    }

}
