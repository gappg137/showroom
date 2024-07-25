package com.car.showroom.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.car.showroom.entity.Car;
import com.car.showroom.repository.CarRepository;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    public CarRepository carRepository;

    @Override
    public ResponseEntity<?> addCar(Car car){
        if (carRepository.existsByModelName(car.getModelName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Model already present: " + car.getModelName());
        }
        Car savedCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body("Car saved Successfully: " + savedCar);
    }
    
        
    

    @Override
    public List<Car> getAllCars() {
        
            return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
       
        
        return carRepository.findById(id);
    }

    @Override
    public ResponseEntity<Car> updateCar(Car car, Long id) {


        Car cars = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        
        cars.setCompany(car.getCompany());
        cars.setModelName(car.getModelName());
        cars.setPrice(car.getPrice());
        carRepository.save(cars);
        return new ResponseEntity<Car>(cars,HttpStatus.CREATED);

    
    }

    @Override
    public void deleteProduct(Long id) {
        carRepository.deleteById(id);
    }




    @Override
    public ResponseEntity<?> gethighestprice() {
        // List<?> companyprice = new ArrayList<>();
        // Sort sort =Sort.by(Direction.DESC, "price");

        // List<Car> carlist = carRepository.findAll(sort);

        // for(int i=0;i<carlist.size();i++)
        // {
        //     if(carlist.get(i).getPrice()==(carlist.get(0)
        //     .getPrice()))
        //     {
        //         companyprice.add(carlist.get(i));
        //     }
        // }
        return null;
        
    }




    @Override
    public List<Car> getCarAbovePrice(Double price) {
        // TODO Auto-generated method stub
        return carRepository.findByPriceGreaterThan(price);
    }

    // @Override

    public List<Car> sameCompany(String company)
    {
        // //ArrayList CarsInventory =  new ArrayList<>();
        
        // List<Car> CarsInventory =  carRepository.findByCompany(company);


        

        // return CarsInventory;

        return carRepository.findByCompany(company);


    }




    @Override
    public List<Car> findCarsByPriceRange(Double minPrice, Double maxPrice) {

        return carRepository.findCarsByPriceRange(minPrice, maxPrice);
    }




    @Override
    public List<Car> findStartCompany(String letter) {

        return carRepository.findStartCompany(letter);
    }

    
    
    

}
