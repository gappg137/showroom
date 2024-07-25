package com.car.showroom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.showroom.entity.Car;
import com.car.showroom.service.CarService;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    CarService carService;

    
    @CrossOrigin
    @PostMapping("/addCar")
    public  ResponseEntity<?> addCar(@RequestBody Car car)
    {
        return carService.addCar(car);
    }

    @CrossOrigin
    @GetMapping("/getCar")
    public ResponseEntity<List<Car>> getAllCars()
    {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/getCar/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id)
    {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("upcar/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car,@PathVariable Long id)

    {
        return carService.updateCar(car, id);

    }

    @DeleteMapping("dcar/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        carService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/samecompany")
    public ResponseEntity<?> gethighestprice()
    {
        return null;
 
    }


    @GetMapping("/cars/abovePrice")
    public List<Car> getCarsAbovePrice(@RequestParam Double targetPrice)
    {

        return carService.getCarAbovePrice(targetPrice);   
    }
    @GetMapping("/range")
    public List<Car> findCarsByPriceRange(@RequestParam Double minPrice,@RequestParam Double maxPrice)
    {
        return carService.findCarsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/models")
    public List<?> sameCompany(@RequestParam String company)
    {

        return carService.sameCompany(company);
    }


    @GetMapping("/start")
    public List<Car> findStartCompany(@RequestParam String letter)
    {

        return carService.findStartCompany(letter);
    }

}
