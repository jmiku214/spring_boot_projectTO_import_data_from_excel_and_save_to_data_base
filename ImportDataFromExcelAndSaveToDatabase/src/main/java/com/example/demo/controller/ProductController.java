package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Helper;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExcelFormat(file)) {
			//true
			
			this.productService.save(file);
			return ResponseEntity.ok(Map.of("message", "file uploaded sucessfully and data is now saved to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload an excel file!!");
	}
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return this.productService.getAllProducts();
	}
	
}
