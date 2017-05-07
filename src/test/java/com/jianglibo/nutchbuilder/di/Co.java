/**
 * 2016 jianglibo@gmail.com
 *
 */
package com.jianglibo.nutchbuilder.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Co {
    
    @Bean(name="romx")
    @Qualifier(value="romx")
    @Primary
    public ObjectMapper omx() {
        return new ObjectMapper();
    }

}
