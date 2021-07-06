package lk.car.rental.service;

import lk.car.rental.dto.CustomerDTO;
import lk.car.rental.entity.Customer;

import java.util.List;


public interface CustomerService {

     boolean addCustomer(CustomerDTO dto);
     boolean findCustomer(String nic ,String password);
     CustomerDTO findUser(String nic, String password);
     CustomerDTO getCustomer(String custID);
     List<CustomerDTO> getAllCustomer();



}
