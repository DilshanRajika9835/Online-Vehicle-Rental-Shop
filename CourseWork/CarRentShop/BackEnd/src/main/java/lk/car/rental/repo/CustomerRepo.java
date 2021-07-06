package lk.car.rental.repo;


import lk.car.rental.entity.Customer;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @Project_Name:BackEnd
 * @Date:2021-06-15
 * @Date_Name:Tuesday
 * @Time:7:55 AM
 * @Author:DILSHAN_RAJIKA
 * @Since:1.0.0
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {
@Query(value = "SELECT * FROM Customer WHERE CustomerNIC=? && password=?",nativeQuery = true)
Customer findCustomer(String CustomerNIC,String password);




}
