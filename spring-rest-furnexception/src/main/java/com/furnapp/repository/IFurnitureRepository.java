package com.furnapp.repository;


import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFurnitureRepository extends JpaRepository<Furniture,Integer> {

    //derived queries
    List<Furniture> findByCategory(Category category);
    List<Furniture> findByBrand(String brand);
    List<Furniture> findByMaterial(String material);
    List<Furniture> findByStyle(Style style);
    List<Furniture> findByRoomType(String roomType);
    List<Furniture> findByStorageAvailable(boolean storageAvailable);

    // custom query
    @Query("from Furniture f where f.price between ?1 and ?2")
    List<Furniture> findByPriceRange(int minPrice, double maxPrice);
    @Query("from Furniture f where f.material =?1 and f.brand=?2")
    List<Furniture> findByMatAndBrand(String material, String brand);
    @Query("from Furniture f where f.roomType =?1 and f.category=?2")
    List<Furniture> findByRoomAndCategory(String roomType, Category category);

    //native query
    @Query(value="select count(*) from furniture",nativeQuery = true)
    Integer findTotal();

    //named query
    @Query(name="getCategoryCost",nativeQuery = true)
    Integer findCategoryCost(Category category);
}
