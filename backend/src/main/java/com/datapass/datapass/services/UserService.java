package com.datapass.datapass.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datapass.datapass.dto.UserDTO;
import com.datapass.datapass.entities.User;
import com.datapass.datapass.repositories.UserRepository;
import com.datapass.datapass.services.exceptions.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		
		List<UserDTO> listDto = new ArrayList<>();
		for(User cat : list) {
			listDto.add(new UserDTO(cat));
		}
		
		return listDto;
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new EntityNotFoundException("Not found."));
		return new UserDTO(entity);
	}
}
