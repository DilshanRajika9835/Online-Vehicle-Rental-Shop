package lk.car.rental.service;

import lk.car.rental.dto.BookingDTO;
import lk.car.rental.dto.BookingDetailDTO;

import java.util.List;

public interface BookingService {
     boolean addBooking(BookingDTO dto, BookingDetailDTO bookingDetailDTO);
    String getBookingID();
    List<Object[]> getCustomerBookingList(String CustomerNIC);
}
