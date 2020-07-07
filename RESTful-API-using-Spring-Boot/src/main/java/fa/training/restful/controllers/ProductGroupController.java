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

import fa.training.restful.entities.ProductGroup;
import fa.training.restful.exceptions.ResourceNotFoundException;
import fa.training.restful.repositories.ProductGroupRepository;

@RestController
@RequestMapping("/api/v1/productgroup")

public class ProductGroupController {

	@Autowired
	private ProductGroupRepository productgroupRepository;
	
	/**
	* Get all product group list.
	*
	* @return the list
	*/
	@GetMapping("/list")
	public List<ProductGroup> getAllProductGroup() {
		return productgroupRepository.findAll();
	}
	
	/**
	* Gets product group by id.
	*
	* @param productgroupId the product group id
	* @return the product group by id
	* @throws ResourceNotFoundException the resource not found exception
	*/
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductGroup> getProductgroupById(@PathVariable(value = "id") Long productgroupId) throws ResourceNotFoundException {
		
		ProductGroup productgroup = productgroupRepository.findById(productgroupId).orElseThrow(() -> new ResourceNotFoundException("Product Group not found on: " + productgroupId));
		
		return ResponseEntity.ok().body(productgroup);
	}
	
	/**
	* Create product group.
	*
	* @param product group the product group
	* @return the product group
	*/
	@PostMapping("/add")
	public ProductGroup create(@Validated @RequestBody ProductGroup productgroup) {
		return productgroupRepository.save(productgroup);
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
	public ResponseEntity<ProductGroup> update(@PathVariable(value = "id") Long productgroupId,@Validated @RequestBody ProductGroup productgroupDetails) throws ResourceNotFoundException {
	
		ProductGroup productgroup = productgroupRepository.findById(productgroupId).orElseThrow(() -> new ResourceNotFoundException("Product Group not found on: " + productgroupId));
	
		productgroup.setName(productgroupDetails.getName());
		productgroup.setPrice(productgroupDetails.getPrice());
		final ProductGroup updatedProductGroup = productgroupRepository.save(productgroup);
	
		return ResponseEntity.ok(updatedProductGroup);
	}
	
	
	/**
	* Delete product group map.
	*
	* @param productgroupId the product group id
	* @return the map
	* @throws Exception the exception
	*/
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long productgroupId) throws Exception {
		
		ProductGroup productgroup = productgroupRepository.findById(productgroupId).orElseThrow(() -> new ResourceNotFoundException("Product Group not found on: " + productgroupId)); 
	
		productgroupRepository.delete(productgroup);
	
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
	
		return response;
	}
	
	
}
