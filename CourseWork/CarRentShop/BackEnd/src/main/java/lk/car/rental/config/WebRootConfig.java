package lk.car.rental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Project_Name:BackEnd
 * @Date:2021-06-15
 * @Date_Name:Tuesday
 * @Time:7:44 AM
 * @Author:DILSHAN_RAJIKA
 * @Since:1.0.0
 **/
@Configuration
@Import({JPAConfig.class})
public class WebRootConfig {
}
