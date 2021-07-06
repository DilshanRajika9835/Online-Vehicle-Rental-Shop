package lk.car.rental.dto;


import lk.car.rental.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {

    private String bookingID;
    private String date;
    private String time;
    private CustomerDTO customer;






}

