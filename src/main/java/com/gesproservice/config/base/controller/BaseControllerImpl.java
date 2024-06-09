package com.gesproservice.config.base.controller;

import com.gesproservice.config.base.entity.BaseEntity;
import com.gesproservice.config.base.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class BaseControllerImpl <Entity extends BaseEntity, Service extends BaseServiceImpl<Entity, Long>> 
							implements BaseController <Entity, Long> {

	@Autowired
	protected Service service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	/*
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Entity entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Entity entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	*/	
}
