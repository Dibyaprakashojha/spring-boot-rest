package com.productapp.controllers;

import com.productapp.model.*;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product-api")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        iProductService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/products/product-id/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId) {
        iProductService.deleteProduct(productId);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.OK)
                        .header("desc", "deleting one product by id")
                        .build();
        return responseEntity;
    }

    @PutMapping("/products")
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        iProductService.updateProduct(product);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    @GetMapping("/products/product-id/{productId}")
    public ResponseEntity<Product> getById(@PathVariable("productId") int productId) {
        Product product = iProductService.getById(productId);
        return ResponseEntity.ok().header("desc", "get by id").body(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = iProductService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting all products");
        headers.add("info", "get all method called");
        ResponseEntity<List<Product>> productResponseEntity =
                new ResponseEntity(products, headers, HttpStatus.OK);
        return productResponseEntity;
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category) {
        List<Product> products = iProductService.getByCategory(category);
        return ResponseEntity.ok().header("desc", "get by category").body(products);
    }

    @GetMapping("/products/choice/{choice}")
    public ResponseEntity<List<Product>> getByChoice(@PathVariable("choice") String choice) {
        List<Product> products = iProductService.getByChoice(choice);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by choice");
        ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(products);
        return productResponse;
    }

    @GetMapping("/products/price/{price}")
    public ResponseEntity<List<Product>> getByPriceLessThan(@PathVariable("price") double price) {
        List<Product> products = iProductService.getByPriceLessThan(price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by price");
        return ResponseEntity.ok().headers(httpHeaders).body(products);

    }

    @GetMapping("/products/brand-start/{brand}")
    public ResponseEntity<List<Product>> getByBrandStartingWith(@PathVariable("brand") String brand) {
        List<Product> products = iProductService.getByBrandStartingWith(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by brand");
        ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(products);
        return productResponse;
    }

    @GetMapping("/products/brand/{brand}")
    public ResponseEntity<List<BrandDTO>> getByBrand(@PathVariable("brand") String brand) {
        List<BrandDTO> products = iProductService.getByBrand(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by brand");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }

    @GetMapping("/products/category/{category}/price/{price}")
    public ResponseEntity<List<CategoryDTO>> getByCategoryAndPriceLessThan(@PathVariable("category") String category, @PathVariable("price") double price) {
        List<CategoryDTO> products = iProductService.getByCategoryAndPriceLessThan(category, price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by category and price");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<ProductDetails> getByName(@PathVariable("name") String name) {
        ProductDetails products = iProductService.getByName(name);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by name");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }

    @GetMapping("/products/all")
    public ResponseEntity<List<ProductView>> getAllProducts() {
        List<ProductView> products = iProductService.getAllProducts();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get all");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }

    @GetMapping("/products/all/brand/{brand}")
    public ResponseEntity<List<ProductBrandView>> getByBrandProduct(@PathVariable("brand") String brand) {
        List<ProductBrandView> products = iProductService.getByBrandProduct(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by brand View");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }

    @GetMapping("/products/all/brandex/{brand}")
    public ResponseEntity<List<String>> getAllProductsBrandEx(@PathVariable("brand") String brand) {
        List<ProductDetailsEx> products = iProductService.findByBrand(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        List<String> pdata = new ArrayList<>();
        for (ProductDetailsEx prod:products) {
            String data = prod.getProduct();
            pdata.add(data);
        }
        httpHeaders.add("desc", "get by brand open projection");
        ResponseEntity<List<String>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(pdata);
        return productResponse;
    }

    @GetMapping("/products/get-all")
    public ResponseEntity<List<Product>> readAllProducts() {
        List<Product> products = iProductService.readAllProducts();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get all by stored procedure");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }

    @GetMapping("/products/all/read-brand/{brand}")
    public ResponseEntity<List<Product>> readByBrandProduct(@PathVariable("brand") String brand) {
        List<Product> products = iProductService.readByBrand(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by brand Procedure");
        return ResponseEntity.ok().headers(httpHeaders).body(products);
    }
    @GetMapping("/products/total-cost/{brand}")
    public ResponseEntity<Double> getTotalCost(@PathVariable("brand") String brand) {
        double product = iProductService.getTotalCost(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "total cost by brand Stored-Procedure");
        return ResponseEntity.ok().headers(httpHeaders).body(product);
    }


}
