package br.com.elastic.services;

import br.com.elastic.exceptions.ResourceNotFoundException;
import br.com.elastic.model.ProductEntity;
import br.com.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;


@Service
public class ProductServices {
	
    private Logger logger= Logger.getLogger(ProductServices.class.getName());
   @Autowired
   ProductRepository productRepository;
    
   public List<ProductEntity> findAll() {
   	
		return productRepository.findAll();
   	
   }
  
	public ProductEntity create(ProductEntity product) {
    	logger.info("Creating one pet!");
    	return productRepository.save(product);
    	
    }
    public ProductEntity update(ProductEntity product) {
    	logger.info("Updating one product!");
    	ProductEntity entity = productRepository.findById(product.getId ())
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    	entity.setNome (product.getNome ());
    	entity.setDescricao(product.getDescricao());
    	entity.setTipo(product.getTipo());
    	entity.setNcm(product.getNcm());
    	entity.setUnidade(product.getUnidade());
    	entity.setPrecoCusto(product.getPrecoCusto());
    	entity.setPrecoVenda(product.getPrecoVenda());
    	entity.setSnEstocavel(product.getSnEstocavel());
    	return productRepository.save(entity);
    	
    }
  
	public ProductEntity findByid(Long id) {
    	logger.info("Finding one product!");
     	return productRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    }
	public void delete(Long id) {
		logger.info("Deleting one product!");
		ProductEntity entity = productRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
		 productRepository.delete(entity);
	}
}
