package com.datapass.datapass.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datapass.datapass.dto.PassDTO;
import com.datapass.datapass.services.PassService;

@RestController
@RequestMapping(value="/pass") //Plural, boas práticas
public class PassResource {
	
	@Autowired
	private PassService service;
	
	@GetMapping
	public ResponseEntity<Page<PassDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<PassDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PassDTO> findById(@PathVariable Long id) {
		PassDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);	
	}
	
	@PostMapping
	public ResponseEntity<PassDTO> insert(@RequestBody PassDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);	
	}
	
	@PutMapping(value="/{id}") //Nao indepotente
	public ResponseEntity<PassDTO> update(@PathVariable Long id, @RequestBody PassDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}") 
	public ResponseEntity<PassDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //Status 204
	}
} 
