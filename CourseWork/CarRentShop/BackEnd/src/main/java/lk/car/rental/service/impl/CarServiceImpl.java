package lk.car.rental.service.impl;

import lk.car.rental.dto.CarDTO;
import lk.car.rental.entity.Car;
import lk.car.rental.repo.CarRepo;
import lk.car.rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CarRepo carRepo;
    @Override
    public CarDTO getCar(String CarID) {
        final Optional<Car> car = carRepo.findById(CarID);
        if(car.isPresent()){
           return modelMapper.map(car.get(),CarDTO.class);
        }
        return null;
    }

    @Override
    public List<CarDTO> getAllCar() {
        final List<Car> all = carRepo.findAll();
       return modelMapper.map(all,new TypeToken< List<Car> >(){}.getType());
    }
}
