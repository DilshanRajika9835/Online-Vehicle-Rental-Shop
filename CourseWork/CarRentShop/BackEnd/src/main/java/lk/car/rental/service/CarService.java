package lk.car.rental.service;

import lk.car.rental.dto.CarDTO;
import lk.car.rental.dto.CustomerDTO;

import java.util.List;

public interface CarService {
    CarDTO getCar(String CarID);
    List<CarDTO> getAllCar();
}
