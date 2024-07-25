package com.car.showroom.service;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.car.showroom.entity.Car;

@Service
public interface CarService  {

    ResponseEntity<?> addCar(Car car);

    List<Car> getAllCars();

    Optional<Car> getCarById(Long id);

    ResponseEntity<Car> updateCar(Car car,Long id);

    // ResponseEntity<?> gethighestprice();

    void deleteProduct(Long id);
    ResponseEntity<?> gethighestprice();

    List <Car> getCarAbovePrice(Double price);


    List<Car> sameCompany(String company);
    List<Car> findCarsByPriceRange(Double minPrice,Double maxPrice);
    List<Car> findStartCompany(String letter);
}
