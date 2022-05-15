package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository iProductRepository;
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
	public List<Product> getByCategory(String category)  {
		return iProductRepository.findByCategory(category);
	}

	@Override
	public List<Product> getByChoice(String choice)  {
		return iProductRepository.findByChoice("%"+choice+"%");
		}

	@Override
	public List<Product> getByPriceLessThan(double price) {
		return iProductRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Product> getByBrandStartingWith(String brand)  {
		return iProductRepository.findByBrandStartingWith(brand);
	}

	@Override
	public Product getById(int productId) {
		return iProductRepository.findById(productId).get();
	}

}
