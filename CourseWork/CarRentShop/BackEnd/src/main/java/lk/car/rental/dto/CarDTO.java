package lk.car.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {

    private String  carID;
    private String brand;
    private  String carType;
    private String carImg1;
    private String carImg2;
    private String carImg3;
    private String carImg4;
    private String description;
    private int passengers;
    private String transmission_type;
    private String fuelType;
    private double dailyRate;
    private double monthlyRate;
    private double extraKm;
    private double runKm;
    private String color;
}
