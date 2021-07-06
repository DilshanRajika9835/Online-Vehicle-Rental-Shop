package lk.car.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    private String empNIC;
    private  String empName;
    private String empAddress;
    private String empEmail;
    private String phoneNumber;
    private String gender;
    private String birthday;
    private String empPost;


}
