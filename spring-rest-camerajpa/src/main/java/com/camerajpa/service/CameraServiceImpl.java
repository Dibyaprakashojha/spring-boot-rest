package com.camerajpa.service;

import com.camerajpa.model.Camera;
import com.camerajpa.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements ICameraService {

    @Autowired
    ICameraRepository cameraRepository;

    @Override
    public void addCamera(Camera camera) {
        cameraRepository.save(camera);
    }

    @Override
    public void updateCamera(Camera camera) {
        cameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
        cameraRepository.deleteById(cameraId);

    }

    @Override
    public Camera getById(int cameraId) {
        return cameraRepository.findById(cameraId).get();
    }

    @Override
    public List<Camera> getAll() {
        return cameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrand(String brand) {
        return cameraRepository.findByBrand(brand);
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) {
        return cameraRepository.findByCameraType(cameraType);
    }

    @Override
    public List<Camera> getByLensType(String lensType) {
        return cameraRepository.findByLensType(lensType);
    }

    @Override
    public List<Camera> getByBrandAndPriceLessThan(String brand, double price) {
        return cameraRepository.findByBrandAndPriceLessThan(brand,price);
    }

    @Override
    public List<Camera> getByCameraTypeAndLensType(String cameraType, String lensType) {
        return cameraRepository.findByCameraTypeAndLensType(cameraType, lensType);
    }
}
