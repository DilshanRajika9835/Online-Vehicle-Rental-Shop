package lk.car.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Car {
    @Id
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
