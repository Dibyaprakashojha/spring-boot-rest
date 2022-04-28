package com.furnapp.controllers;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture-api")
public class FurnitureController {
    @Autowired
    IFurnitureService iFurnitureService;

    @PostMapping("/furnitures")
    public ResponseEntity<Void> addFurniture(@RequestBody Furniture furniture){
        iFurnitureService.addFurniture(furniture);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/furnitures")
    public ResponseEntity<Void> updateFurniture(@RequestBody Furniture furniture){
        iFurnitureService.updateFurniture(furniture);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/furnitures/furniture-id/{furnitureId}")
    public ResponseEntity<Void> deleteFurniture(@PathVariable("furnitureId") int furnitureId){
        iFurnitureService.deleteFurniture(furnitureId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/furnitures/furniture-id/{furnitureId}")
    ResponseEntity<Furniture> findById(@PathVariable("furnitureId") int furnitureId){
        Furniture furniture = iFurnitureService.findById(furnitureId);
        return ResponseEntity.ok(furniture);
    }

    @GetMapping("/furnitures")
    ResponseEntity<List<Furniture>> showAll(){
        List<Furniture> furniture = iFurnitureService.findAll();
        return ResponseEntity.ok(furniture);
    }


    @GetMapping("/furnitures/category/{category}")
    public ResponseEntity<List<Furniture>> findByCategory(@PathVariable("category")Category category)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByCategory(category);
        return ResponseEntity.ok().header("desc", "get by category").body(furnitures);
    }

    @GetMapping("/furnitures/brand/{brand}")
    public ResponseEntity<List<Furniture>> findByBrand(@PathVariable("brand")String brand)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByBrand(brand);
        return ResponseEntity.ok().header("desc", "get by brand").body(furnitures);
    }

    @GetMapping("/furnitures/material/{material}")
    public ResponseEntity<List<Furniture>> findByMaterial(@PathVariable("material")String material)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByMaterial(material);
        return ResponseEntity.ok().header("desc", "get by material").body(furnitures);
    }

    @GetMapping("/furnitures/style/{style}")
    public ResponseEntity<List<Furniture>> findByStyle(@PathVariable("style")Style style)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByStyle(style);
        return ResponseEntity.ok().header("desc", "get by material").body(furnitures);
    }

    @GetMapping("/furnitures/room-type/{roomType}")
    public ResponseEntity<List<Furniture>> findByRoomType(@PathVariable("roomType")String roomType)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByRoomType(roomType);
        return ResponseEntity.ok().header("desc", "get by room-type").body(furnitures);
    }

    @GetMapping("/furnitures/storage-available/{storage}")
    public ResponseEntity<List<Furniture>> findByStorageAvailable(@PathVariable("storage")boolean storageAvailable)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByStorageAvailable(storageAvailable);
        return ResponseEntity.ok().header("desc", "get by storage-availability").body(furnitures);
    }

    @GetMapping("/furnitures/price/min-price/{minPrice}/max-price/{maxPrice}")
    public ResponseEntity<List<Furniture>> findByPriceRange(@PathVariable("minPrice")int minPrice,@PathVariable("maxPrice") double maxPrice)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok().header("desc", "get by price-range").body(furnitures);
    }

    @GetMapping("/furnitures/material/{material}/brand/{brand}")
    public ResponseEntity<List<Furniture>> findByMatAndBrand(@PathVariable("material")String material, @PathVariable("brand")String brand)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByMatAndBrand(material, brand);
        return ResponseEntity.ok().header("desc", "get by material-brand").body(furnitures);
    }

    @GetMapping("/furnitures/room/{roomType}/category/{category}")
    public ResponseEntity<List<Furniture>> findByRoomAndCategory(@PathVariable("roomType")String roomType, @PathVariable("category")Category category)throws FurnitureNotFoundException{
        List<Furniture> furnitures = iFurnitureService.findByRoomAndCategory(roomType, category);
        return ResponseEntity.ok().header("desc", "get by roomType-category").body(furnitures);
    }

    @GetMapping("/furnitures/find-total")
    public ResponseEntity<Integer> findTotal(){
        int total = iFurnitureService.findTotal();
        return ResponseEntity.ok().header("desc", "get by total-entries").body(total);
    }

    @GetMapping("/furnitures/furniture-category-price/{category}")
    public ResponseEntity<Integer> findCategoryCost(@PathVariable("category") Category category){
        int categoryCost = iFurnitureService.findCategoryCost(category);
        return ResponseEntity.ok().header("desc", "get by category-cost").body(categoryCost);
    }
}
