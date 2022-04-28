package com.camerajpa.controllers;

import com.camerajpa.model.Camera;
import com.camerajpa.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera-api")
public class CameraController {
    @Autowired
    ICameraService cameraService;

    // http://localhost:8081/camera-api/cameras
    @PostMapping("/cameras")
    public ResponseEntity<Void> addCamera(@RequestBody Camera camera) {
        cameraService.addCamera(camera);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    // http://localhost:8081/camera-api/cameras
    @DeleteMapping("/cameras/cameraId/{cameraId}")
    public ResponseEntity<Void> deleteCamera(@PathVariable("cameraId") int cameraId) {
        cameraService.deleteCamera(cameraId);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.OK)
                        .header("desc", "deleting one product by id")
                        .build();
        return responseEntity;
    }

    // http://localhost:8081/camera-api/cameras
    @PutMapping("/cameras")
    public ResponseEntity<Void> updateCamera(@RequestBody Camera camera) {
        cameraService.updateCamera(camera);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    @GetMapping("/cameras/cameraId/{cameraId}")
    public Camera showByCameraId(@PathVariable("cameraId") int cameraId) {
        return cameraService.getById(cameraId);
    }


    @GetMapping("/cameras")
    public ResponseEntity<List<Camera>> showCameras() {
        List<Camera> cameras = cameraService.getAll();
        return ResponseEntity.ok().header("desc", "get all cameras").body(cameras);
    }

    @GetMapping("/cameras/brand/{brand}")
    public ResponseEntity<List<Camera>> showByCameraBrand(@PathVariable("brand") String brand) {
        List<Camera> cameras = cameraService.getByBrand(brand);
        return ResponseEntity.ok().header("desc", "get by brand").body(cameras);
    }

    @GetMapping("/cameras/cameraType/{cameraType}")
    public ResponseEntity<List<Camera>> showByCameraType(@PathVariable("cameraType") String cameraType) {
        List<Camera> cameras = cameraService.getByCameraType(cameraType);
        return ResponseEntity.ok().header("desc", "get by camera-type").body(cameras);
    }

    @GetMapping("/cameras/lensType/{lensType}")
    public ResponseEntity<List<Camera>> showByLensType(@PathVariable("lensType") String lensType) {
        List<Camera> cameras = cameraService.getByLensType(lensType);
        return ResponseEntity.ok().header("desc", "get by lens-type").body(cameras);
    }

    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public ResponseEntity<List<Camera>> showByBrandAndPrice(@PathVariable("brand") String brand, @PathVariable("price") double price) {
        List<Camera> cameras = cameraService.getByBrandAndPriceLessThan(brand,price);
        return ResponseEntity.ok().header("desc", "get by brand and price").body(cameras);
    }

    @GetMapping("/cameras/cameraType/{cameraType}/lensType/{lensType}")
    public ResponseEntity<List<Camera>> showByBrandAndPrice(@PathVariable("cameraType") String cameraType, @PathVariable("lensType") String lensType) {
        List<Camera> cameras = cameraService.getByCameraTypeAndLensType(cameraType,lensType);
        return ResponseEntity.ok().header("desc", "get by camera-type and lens-type").body(cameras);
    }

}
