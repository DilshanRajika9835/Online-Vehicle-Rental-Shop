package lk.car.rental.repo;

import lk.car.rental.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookingDetailRepo extends JpaRepository<BookingDetail,String> {


    @Query(value = "SELECT  distinct d.pickLocate,d.pickDate,d.pickTime,d.dropLocate,d.dropDate,d.dropTime,b.bookingID,v.carID,e.empNIC from \n" +
            "customer c,booking b,Employee e,bookingDetail d,Car v where c.customernic=b.customernic && c.customerNIC=? && b.bookingID=d.bookingID",nativeQuery = true)
    List<Object[]> getCustomerBookingDetails(String CustomerNIC);

}
