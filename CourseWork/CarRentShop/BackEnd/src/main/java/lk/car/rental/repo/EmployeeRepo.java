package lk.car.rental.repo;

import lk.car.rental.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
    @Query(value = "SELECT  distinct d.pickLocate,d.pickDate,d.pickTime,d.dropLocate,d.dropDate,d.dropTime,b.bookingID,v.carID,e.empNIC, b.date ,b.time,e.empName from \n" +
            "customer c,booking b,Employee e,bookingDetail d,Car v where c.customernic=b.customernic && e.empNIC=? && b.bookingID=d.bookingID",nativeQuery = true)
    List<Object[]> getAllBookingByDriver(String empNIC);




}
