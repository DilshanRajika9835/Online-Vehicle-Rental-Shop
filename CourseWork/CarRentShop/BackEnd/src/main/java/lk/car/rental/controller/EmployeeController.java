package lk.car.rental.controller;

import lk.car.rental.service.BookingService;
import lk.car.rental.service.CarService;
import lk.car.rental.service.CustomerService;
import lk.car.rental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    BookingService bookingService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CarService carService;
    @Autowired
    CustomerService customerService;
    @GetMapping(params = {"empNIC"})
    public List<Object[]> getEmployeeBooking(@RequestParam String empNIC){
        System.out.println(empNIC);
        return employeeService.getAllEmployeeBooking(empNIC);
    }

}
