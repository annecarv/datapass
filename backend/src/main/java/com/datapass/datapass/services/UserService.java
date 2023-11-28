package com.datapass.datapass.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datapass.datapass.dto.UserDTO;
import com.datapass.datapass.entities.User;
import com.datapass.datapass.repositories.UserRepository;
import com.datapass.datapass.services.exceptions.DatabaseException;
import com.datapass.datapass.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		
		return list.map(x -> new UserDTO(x));
	}	
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Not found."));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		entity.setFirstname(dto.getFirstname());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
		User entity = repository.getOne(id);
		entity.setFirstname(dto.getFirstname());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity = repository.save(entity);
		return new UserDTO(entity);
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
