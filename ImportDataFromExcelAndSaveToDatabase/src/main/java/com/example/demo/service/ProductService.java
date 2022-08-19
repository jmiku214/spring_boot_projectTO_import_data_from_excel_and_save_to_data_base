package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Helper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void save(MultipartFile file) {
		try {
			List<Product> products = Helper.convertExcelToListOfProduct(file.getInputStream());
			this.productRepository.saveAll(products);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}
}
