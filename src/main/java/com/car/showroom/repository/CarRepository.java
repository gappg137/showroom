package com.car.showroom.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.car.showroom.entity.Car;

@Repository

public interface CarRepository extends JpaRepository<Car,Long>{

    
    boolean existsByModelName(String modelName);

    List<Car> findByPriceGreaterThan(Double price);

    List<Car> findByCompany(String company);

    @Query("Select c FROM Car c WHERE c.company= :company") 
    List<Car> sameCompany( String company);

    @Query(value = "Select * FROM Car WHERE Price BETWEEN :minPrice AND :maxPrice",nativeQuery = true)
    List<Car> findCarsByPriceRange(@Param("minPrice")double minPrice,@Param("maxPrice")double maxPrice);

    @Query(value = "SELECT * FROM Car  WHERE company LIKE :letter%",nativeQuery = true)
    List<Car> findStartCompany(@Param("letter") String letter);
    
}
