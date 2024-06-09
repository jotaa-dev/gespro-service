package com.gesproservice.config.base.service;

import com.gesproservice.config.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService <Entity extends BaseEntity, ID extends Serializable> {
	public List<Entity> findAll() throws Exception;
	public Entity findById(ID id) throws Exception;
	public Entity save(Entity entity) throws Exception;
	public Entity update(ID id, Entity entity) throws Exception;
	public boolean delete (ID id) throws Exception;
}
