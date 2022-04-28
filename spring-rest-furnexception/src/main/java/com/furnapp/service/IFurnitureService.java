package com.furnapp.service;


import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFurnitureService {

    void addFurniture(Furniture furniture);
    void updateFurniture(Furniture furniture);
    void deleteFurniture(int furnitureId);
    Furniture findById(int furnitureId);
    List<Furniture> findAll();

    // derived query
    List<Furniture> findByCategory(Category category)throws FurnitureNotFoundException;
    List<Furniture> findByBrand(String brand)throws FurnitureNotFoundException;
    List<Furniture> findByMaterial(String material)throws FurnitureNotFoundException;
    List<Furniture> findByStyle(Style style)throws FurnitureNotFoundException;
    List<Furniture> findByRoomType(String roomType)throws FurnitureNotFoundException;
    List<Furniture> findByStorageAvailable(boolean storageAvailable)throws FurnitureNotFoundException;

    //native query
    List<Furniture> findByPriceRange(int minPrice, double maxPrice)throws FurnitureNotFoundException;
    List<Furniture> findByMatAndBrand(String material, String brand)throws FurnitureNotFoundException;
    List<Furniture> findByRoomAndCategory(String roomType, Category category)throws FurnitureNotFoundException;
    Integer findTotal();

    //named query
    Integer findCategoryCost(Category category);

}
