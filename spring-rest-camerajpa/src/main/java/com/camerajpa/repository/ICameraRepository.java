package com.camerajpa.repository;

import com.camerajpa.exceptions.CameraNotFoundException;
import com.camerajpa.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICameraRepository extends JpaRepository<Camera,Integer> {
    List<Camera> findByBrand(String brand);
    List<Camera> findByCameraType(String cameraType);
    List<Camera> findByLensType(String lensType);
    List<Camera> findByBrandAndPriceLessThan(String brand, double price);
    List<Camera> findByCameraTypeAndLensType(String cameraType,String lensType);
    
}
