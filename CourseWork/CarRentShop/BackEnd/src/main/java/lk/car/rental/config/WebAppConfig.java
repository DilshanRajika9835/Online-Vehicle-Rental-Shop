package lk.car.rental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project_Name:BackEnd
 * @Date:2021-06-15
 * @Date_Name:Tuesday
 * @Time:7:43 AM
 * @Author:DILSHAN_RAJIKA
 * @Since:1.0.0
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.car.rental")
public class WebAppConfig {
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public Date date(){
        return new Date();
    }


}
