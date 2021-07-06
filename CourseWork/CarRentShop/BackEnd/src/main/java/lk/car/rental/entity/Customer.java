package lk.car.rental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @Project_Name:BackEnd
 * @Date:2021-06-15
 * @Date_Name:Tuesday
 * @Time:7:54 AM
 * @Author:DILSHAN_RAJIKA
 * @Since:1.0.0
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Customer{
    @Id
    private String customerNIC;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;
    private String city;
    private String province;
    private String profile;
    private String fontIdentity;
    private String backIdentity;
    private String fontLicense;
    private String backLicense;


}
