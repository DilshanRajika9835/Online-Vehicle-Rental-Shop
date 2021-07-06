package lk.car.rental.dto;

import lk.car.rental.entity.Booking;
import lk.car.rental.entity.Car;
import lk.car.rental.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetailDTO {

    private String pickLocate;
    private String pickTime;
    private String pickDate;
    private String dropLocate;
    private String dropTime;
    private String dropDate;
    private BookingDTO booking;
    private EmployeeDTO employee;
    private CarDTO car;

    }
