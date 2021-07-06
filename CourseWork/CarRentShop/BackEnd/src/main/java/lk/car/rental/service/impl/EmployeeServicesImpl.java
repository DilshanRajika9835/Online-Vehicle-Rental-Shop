package lk.car.rental.service.impl;

import lk.car.rental.dto.EmployeeDTO;
import lk.car.rental.entity.Employee;
import lk.car.rental.repo.EmployeeRepo;
import lk.car.rental.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServicesImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public EmployeeDTO getEmployee(String empID) {
        final Optional<Employee> employee = employeeRepo.findById(empID);
        if(employee.isPresent()){
            return  modelMapper.map(employee.get(),EmployeeDTO.class);
        }
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        final List<Employee> all = employeeRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<Employee>>(){}.getType());
    }

    @Override
    public List<Object[]> getAllEmployeeBooking(String empNIC) {
        final List<Object[]> bookingList = employeeRepo.getAllBookingByDriver(empNIC);
        if(bookingList.size()!=0){
            return bookingList;
        }

        return null;


    }
}
