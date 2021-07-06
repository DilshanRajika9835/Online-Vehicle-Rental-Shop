package lk.car.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private String empNIC;
    private  String empName;
    private String empAddress;
    private String empEmail;
    private String phoneNumber;
    private String gender;
    private String birthday;
    private String empPost;
}
