package lk.car.rental.controller;

import lk.car.rental.dto.*;
import lk.car.rental.service.BookingService;
import lk.car.rental.service.CarService;
import lk.car.rental.service.CustomerService;
import lk.car.rental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CarService carService;
    @Autowired
    CustomerService customerService;


    @PostMapping(path = "/place",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean rentCar(@RequestBody BookingList bookingList) {
        final String bookingID = bookingService.getBookingID();
        System.out.println("Booking Id "+bookingID);
        final BookingDetailDTO bookingDetailDTO = bookingList.getBookingDetailDTO();
        bookingDetailDTO.getBooking().setBookingID(bookingID);
        final String carID = bookingDetailDTO.getCar().getCarID();
        final CarDTO car = carService.getCar(carID);
        bookingDetailDTO.setCar(car);
        final String empNIC = bookingDetailDTO.getEmployee().getEmpNIC();
        final EmployeeDTO employee = employeeService.getEmployee(empNIC);
        bookingDetailDTO.setEmployee(employee);

        final BookingDTO bookingDTO = bookingList.getBookingDTO();
        bookingDTO.setBookingID(bookingID);
        final String customerNIC = bookingDTO.getCustomer().getCustomerNIC();
        final CustomerDTO customer = customerService.getCustomer(customerNIC);
        bookingDetailDTO.getBooking().setCustomer(customer);
        bookingDTO.setCustomer(customer);
        return bookingService.addBooking(bookingList.getBookingDTO(), bookingList.getBookingDetailDTO());


    }

    @GetMapping(value = "/details",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Object[]> getBookingDetail(String customerNIC){
         return bookingService.getCustomerBookingList(customerNIC);
    }




}
