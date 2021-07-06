package lk.car.rental.service.impl;


import lk.car.rental.entity.Customer;
import lk.car.rental.dto.CustomerDTO;
import lk.car.rental.repo.CustomerRepo;
import lk.car.rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Project_Name:BackEnd
 * @Date:2021-06-15
 * @Date_Name:Tuesday
 * @Time:11:30 AM
 * @Author:DILSHAN_RAJIKA
 * @Since:1.0.0
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        final Customer customer = modelMapper.map(dto, Customer.class);
        final Customer save = customerRepo.save(customer);
        if(save!=null){
            return true;
        }
   return false;
    }

    @Override
    public boolean findCustomer(String nic, String password) {
        final Optional<Customer> find = customerRepo.findById(nic);
        if(find.isPresent()){
            final Customer customer = find.get();
            return customer.getPassword().equals(password) && customer.getCustomerNIC().equals(nic);
        }

        return false;
    }

    @Override
    public CustomerDTO findUser(String nic, String password) {
        Customer customer = customerRepo.findCustomer(nic, password);
            if(customer!=null){
               return modelMapper.map(customer,CustomerDTO.class);
            }
            return null;
    }

    @Override
    public CustomerDTO getCustomer(String custID) {
        final Optional<Customer> customer = customerRepo.findById(custID);
        if(customer.isPresent()){
            return modelMapper.map(customer.get(), CustomerDTO.class);

        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        final List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }


}
