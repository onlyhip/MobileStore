package fa.training.restful.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.training.restful.entities.Product;
import fa.training.restful.exceptions.ResourceNotFoundException;
import fa.training.restful.repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	/**
	* Get all product list.
	*
	* @return the list
	*/
	@GetMapping("/list")
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	/**
	* Gets product by id.
	*
	* @param productId the product id
	* @return the product by id
	* @throws ResourceNotFoundException the resource not found exception
	*/
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
		
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found on: " + productId));
		
		return ResponseEntity.ok().body(product);
	}
	
	/**
	* Create product.
	*
	* @param product the product 
	* @return the product 
	*/
	@PostMapping("/add")
	public Product create(@Validated @RequestBody Product product) {
		return productRepository.save(product);
	}
	
	
	/**
	* Update product group response entity.
	*
	* @param productgroupId the product group id
	* @param productgroupDetails the product group details
	* @return the response entity
	* @throws ResourceNotFoundException the resource not found exception
	*/
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> update(@PathVariable(value = "id") Long productId,@Validated @RequestBody Product productDetails) throws ResourceNotFoundException {
	
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found on: " + productId));
	
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		product.setDescription(productDetails.getDescription());
		product.setUsersid(productDetails.getUsersid());
		product.setProductgroupid(productDetails.getProductgroupid());
		final Product updatedProduct = productRepository.save(product);
	
		return ResponseEntity.ok(updatedProduct);
	}
	
	
	/**
	* Delete product map.
	*
	* @param productId the product id
	* @return the map
	* @throws Exception the exception
	*/
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long productId) throws Exception {
		
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found on: " + productId)); 
	
		productRepository.delete(product);
	
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
	
		return response;
	}

}
