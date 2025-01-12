package br.com.elastic.controller;

import br.com.elastic.model.ClientEntity;
import br.com.elastic.model.ProductEntity;
import br.com.elastic.services.ClientServices;
import br.com.elastic.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClientController {

	
    @Autowired	
	private ClientServices service;
    @Cacheable(value = "listaClientes", key ="#id_cliente", condition="#p0!=null")
	@GetMapping( produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ClientEntity> findAll()
		 {
		return service.findAll();
			
	}
	@GetMapping(value = "/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ClientEntity findByid(@PathVariable(value = "id") Long id)
	{
		return service.findByid(id);
		
		
		
	}
	@PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
			     consumes =MediaType.APPLICATION_JSON_VALUE)

	public ClientEntity create(@RequestBody ClientEntity client)
	{
		return service.create(client);
		
		
		
	}
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
			    consumes =MediaType.APPLICATION_JSON_VALUE)
	public ClientEntity update(@RequestBody ClientEntity client)
	{
		return service.update(client);
		
		
		
	}
	@DeleteMapping(value = "/{id}")
	
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id)
	{
		 service.delete(id);
		 return ResponseEntity.noContent().build();
		
		
		
		
	}
}
