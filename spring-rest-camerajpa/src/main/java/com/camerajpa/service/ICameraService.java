package com.camerajpa.service;

import com.camerajpa.exceptions.CameraNotFoundException;
import com.camerajpa.exceptions.IdNotFoundException;
import com.camerajpa.model.Camera;

import java.util.List;

public interface ICameraService {

    void addCamera(Camera camera);
    void updateCamera(Camera camera);
    void deleteCamera(int cameraId);
    Camera getById(int cameraId) throws IdNotFoundException;
    List<Camera> getAll();
    List<Camera> getByBrand(String brand) throws CameraNotFoundException;
    List<Camera> getByCameraType(String cameraType) throws CameraNotFoundException;
    List<Camera> getByLensType(String lensType) throws CameraNotFoundException;
    List<Camera> getByBrandAndPriceLessThan(String brand, double price) throws CameraNotFoundException;
    List<Camera> getByCameraTypeAndLensType(String cameraType,String lensType) throws CameraNotFoundException;


}
