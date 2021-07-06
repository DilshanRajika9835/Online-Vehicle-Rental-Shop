package lk.car.rental.service;

import lk.car.rental.dto.CustomerDTO;
import lk.car.rental.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO getEmployee(String EmpID);
    List<EmployeeDTO> getAllEmployee();
    List<Object[]>  getAllEmployeeBooking(String empNIC);

}
