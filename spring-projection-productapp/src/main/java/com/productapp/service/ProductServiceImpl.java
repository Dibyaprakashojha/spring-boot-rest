package com.productapp.service;

import com.productapp.model.*;
import com.productapp.repository.IProductBrandViewRepository;
import com.productapp.repository.IProductRepository;
import com.productapp.repository.IProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private IProductViewRepository iProductViewRepository;

    @Autowired
    private IProductBrandViewRepository iProductBrandViewRepository;


    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.save(product);
    }


    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> getByCategory(String category) {
        return iProductRepository.findByCategory(category);
    }

    @Override
    public List<Product> getByChoice(String choice) {
        return iProductRepository.findByChoice("%" + choice + "%");
    }

    @Override
    public List<Product> getByPriceLessThan(double price) {
        return iProductRepository.findByPriceLessThan(price);
    }

    @Override
    public List<Product> getByBrandStartingWith(String brand) {
        return iProductRepository.findByBrandStartingWith(brand);
    }

    @Override
    public Product getById(int productId) {
        return iProductRepository.findById(productId).get();
    }

    @Override
    public List<BrandDTO> getByBrand(String brand) {
        return iProductRepository.findByBrand(brand);
    }

    @Override
    public List<CategoryDTO> getByCategoryAndPriceLessThan(String category, double price) {
        return iProductRepository.findByCategoryAndPrice(category, price);
    }

    @Override
    public ProductDetails getByName(String name) {
        return iProductRepository.findByName(name);
    }

    @Override
    public List<ProductView> getAllProducts() {
        return iProductViewRepository.findAll();
    }

    @Override
    public List<ProductBrandView> getByBrandProduct(String brand) {
        return iProductBrandViewRepository.findByBrand(brand);
    }

    @Override
    public List<ProductDetailsEx> findByBrand(String brand) {
        return iProductRepository.getByBrand(brand);
    }

    @Override
    @Transactional
    public List<Product> readAllProducts() {
        return iProductRepository.readAllProducts();
    }

    @Override
    @Transactional
    public List<Product> readByBrand(String brand) {
        return iProductRepository.readByBrand(brand);
    }

    @Override
    public double getTotalCost(String brand) {
        return iProductRepository.getTotalCost(brand);
    }
}
