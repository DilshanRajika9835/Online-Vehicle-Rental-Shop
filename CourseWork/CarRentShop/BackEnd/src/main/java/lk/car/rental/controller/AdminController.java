package lk.car.rental.controller;

import lk.car.rental.dto.CarDTO;
import lk.car.rental.dto.CustomerDTO;
import lk.car.rental.dto.EmployeeDTO;
import lk.car.rental.service.BookingService;
import lk.car.rental.service.CarService;
import lk.car.rental.service.CustomerService;
import lk.car.rental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    BookingService bookingService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CarService carService;
    @Autowired
    CustomerService customerService;

    @GetMapping(path = {"/allCustomer"})
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();

    }
    @GetMapping(path = {"/allCar"})
    public List<CarDTO> getAllCar(){
        return carService.getAllCar();

    }

    @GetMapping(path = {"/allEmployee"})
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
}
