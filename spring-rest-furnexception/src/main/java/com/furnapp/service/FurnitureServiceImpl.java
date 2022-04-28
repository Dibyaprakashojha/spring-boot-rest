package com.furnapp.service;

import com.furnapp.exceptions.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FurnitureServiceImpl implements IFurnitureService {

    IFurnitureRepository iFurnitureRepository;
    @Autowired
    public void setiFurnitureRepository(IFurnitureRepository iFurnitureRepository) {
        this.iFurnitureRepository = iFurnitureRepository;
    }

    @Override
    public void addFurniture(Furniture furniture) {
        iFurnitureRepository.save(furniture);
    }

    @Override
    public void updateFurniture(Furniture furniture) {
        iFurnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        iFurnitureRepository.deleteById(furnitureId);
    }

    @Override
    public Furniture findById(int furnitureId) {
        return iFurnitureRepository.findById(furnitureId).get();
    }

    @Override
    public List<Furniture> findAll() {
        return iFurnitureRepository.findAll();
    }

    @Override
    public List<Furniture> findByCategory(Category category) {
        List<Furniture> furniture = iFurnitureRepository.findByCategory(category);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Category Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByBrand(String brand) {
        List<Furniture> furniture = iFurnitureRepository.findByBrand(brand);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Brand Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByMaterial(String material) {
        List<Furniture> furniture = iFurnitureRepository.findByMaterial(material);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Material Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByStyle(Style style) {
        List<Furniture> furniture = iFurnitureRepository.findByStyle(style);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Style Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByRoomType(String roomType) {
        List<Furniture> furniture = iFurnitureRepository.findByRoomType(roomType);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Room-Type Not Found");
        return furniture;
    }



    @Override
    public List<Furniture> findByStorageAvailable(boolean storageAvailable) {
        List<Furniture> furniture = iFurnitureRepository.findByStorageAvailable(storageAvailable);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Room-Type Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByPriceRange(int minPrice, double maxPrice) {
        List<Furniture> furniture = iFurnitureRepository.findByPriceRange(minPrice, maxPrice);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Room-Type Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByMatAndBrand(String material, String brand) {
        List<Furniture> furniture = iFurnitureRepository.findByMatAndBrand(material, brand);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Room-Type Not Found");
        return furniture;
    }

    @Override
    public List<Furniture> findByRoomAndCategory(String roomType, Category category) {
        List<Furniture> furniture = iFurnitureRepository.findByRoomAndCategory(roomType, category);
        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Room-Type Not Found");
        return furniture;
    }

    @Override
    public Integer findTotal() {
        return iFurnitureRepository.findTotal();
    }

    @Override
    public Integer findCategoryCost(Category category) {
        return iFurnitureRepository.findCategoryCost(category);
    }
}
