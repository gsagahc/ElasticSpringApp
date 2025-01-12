package br.com.elastic.controller;

import br.com.elastic.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.elastic.services.ProductServices;
import java.util.List;




@RestController
@RequestMapping("/produto")
public class ProductController {

	
    @Autowired	
	private ProductServices service;
    @Cacheable(value = "listaProdutos", key ="#id_produto", condition="#p0!=null")
	@GetMapping( produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ProductEntity> findAll()
		 {
		return service.findAll();
			
	}
	@GetMapping(value = "/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ProductEntity findByid(@PathVariable(value = "id") Long id)
	{
		return service.findByid(id);
		
		
		
	}
	@PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
			     consumes =MediaType.APPLICATION_JSON_VALUE)

	public ProductEntity create(@RequestBody ProductEntity product)
	{
		return service.create(product);
		
		
		
	}
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
			    consumes =MediaType.APPLICATION_JSON_VALUE)
	public ProductEntity update(@RequestBody ProductEntity product)
	{
		return service.update(product);
		
		
		
	}
	@DeleteMapping(value = "/{id}")
	
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id)
	{
		 service.delete(id);
		 return ResponseEntity.noContent().build();
		
		
		
		
	}
}
