package br.com.elastic.services;

import br.com.elastic.exceptions.ResourceNotFoundException;
import br.com.elastic.model.ClientEntity;
import br.com.elastic.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;


@Service
public class ClientServices {
	
    private Logger logger= Logger.getLogger(ClientServices.class.getName());
   @Autowired
   ClientRepository clientRepository;
    
   public List<ClientEntity> findAll() {
   	
		return clientRepository.findAll();
   	
   }
  
	public ClientEntity create(ClientEntity product) {
    	logger.info("Creating one client!");
    	return clientRepository.save(product);
    	
    }
    public ClientEntity update(ClientEntity client) {
    	logger.info("Updating one client!");
    	ClientEntity entity = clientRepository.findById(client.getId ())
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    	entity.setNome (client.getNome());
    	entity.setNome(client.getNome());
    	entity.setCnpj(client.getCnpj());
    	entity.setEndereco(client.getEndereco());
    	entity.setBairro(client.getBairro());
    	entity.setCidade(client.getCidade());
    	entity.setComplemento(client.getComplemento());
    	entity.setEstado(client.getEstado());
		entity.setBoleto(client.getBoleto());
		entity.setCep(client.getCep());
    	return clientRepository.save(entity);
    	
    }
  
	public ClientEntity findByid(Long id) {
    	logger.info("Finding one client!");
     	return clientRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    }
	public void delete(Long id) {
		logger.info("Deleting one client!");
		ClientEntity entity = clientRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
		 clientRepository.delete(entity);
	}
}
