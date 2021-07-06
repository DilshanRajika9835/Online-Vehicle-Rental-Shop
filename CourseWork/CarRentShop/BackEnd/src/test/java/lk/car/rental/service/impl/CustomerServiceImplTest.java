package lk.car.rental.service.impl;

import lk.car.rental.config.WebAppConfig;
import lk.car.rental.config.WebRootConfig;
import lk.car.rental.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @Autowired
    CustomerRepo customerRepo;
    @Test
    void addCustomer() {

    }

    @Test
    void findCustomer() {

    }
}