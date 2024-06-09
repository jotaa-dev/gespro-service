package com.gesproservice.config.base.controller;

import com.gesproservice.config.base.entity.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface BaseController <Entity extends BaseEntity, ID extends Serializable> {
	public ResponseEntity<?> getAll();
	/*
	public ResponseEntity<?> getOne(@PathVariable ID id);
	public ResponseEntity<?> save(@RequestBody Entity e);
	public ResponseEntity<?> update(@PathVariable ID id, @RequestBody Entity e);
	public ResponseEntity<?> delete(@PathVariable ID id);
	*/
}
