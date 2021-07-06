package lk.car.rental.repo;

import lk.car.rental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking,String> {

    @Query(value = "SELECT bookingID FROM Booking  ORDER BY bookingID DESC LIMIT 1", nativeQuery = true)
    String getOrderID();
}
