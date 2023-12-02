package com.datapass.datapass.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datapass.datapass.dto.PassDTO;
import com.datapass.datapass.entities.Pass;
import com.datapass.datapass.repositories.PassRepository;
import com.datapass.datapass.services.exceptions.DatabaseException;
import com.datapass.datapass.services.exceptions.ResourceNotFoundException;

@Service
public class PassService {
	
	@Autowired
	private PassRepository repository;
	
	@Transactional(readOnly = true)
	public Page<PassDTO> findAllPaged(PageRequest pageRequest) {
		Page<Pass> list = repository.findAll(pageRequest);
		
		return list.map(x -> new PassDTO(x));
	}	
	
	@Transactional(readOnly = true)
	public PassDTO findById(Long id) {
		Optional<Pass> obj = repository.findById(id);
		Pass entity = obj.orElseThrow(() -> new ResourceNotFoundException("Not found."));
		return new PassDTO(entity);
	}
	
	@Transactional
	public PassDTO insert(PassDTO dto) {
		Pass entity = new Pass();
		//entity.setName(dto.getName());
		entity = repository.save(entity);
		return new PassDTO(entity);
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public PassDTO update(Long id, PassDTO dto) {
		try {
		Pass entity = repository.getOne(id);
		//entity.setName(dto.getName());
		//entity.setUrl(dto.getUrl());
		//entity.setLogin(dto.getLogin());
		//entity.setPass(dto.getPass());
		//entity = repository.save(entity);
		return new PassDTO(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found.");
		}
	
	}
	
	@Transactional //(propagation = Propagation.SUPPORTS) COM ERRO 
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		try {
	        	repository.deleteById(id);    		
		}
	    	catch (DataIntegrityViolationException e) {
	        	throw new DatabaseException("Falha de integridade referencial");
	   	}
	}

}
