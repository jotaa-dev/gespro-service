package com.gesproservice.config.base.service;

import com.gesproservice.config.base.entity.BaseEntity;
import com.gesproservice.config.base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <Entity extends BaseEntity, ID extends Serializable> 
							implements BaseService<Entity, ID> {
	
	protected BaseRepository<Entity, ID> baseRepository;
	protected EntityManager entityManager;
	
	// CONSTRUCTOR
	public BaseServiceImpl(BaseRepository<Entity, ID> baseRepository, EntityManager entityManager) {
		this.baseRepository = baseRepository;
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Entity> findAll() throws Exception {
		try {
			List<Entity> entityList = baseRepository.findAll();
			return entityList;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Entity findById(ID id) throws Exception {
		try {
			Optional<Entity> entityOptional = baseRepository.findById(id);
			return entityOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Entity save(Entity entity) throws Exception {
		try {
			entity = baseRepository.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Entity update(ID id, Entity entity) throws Exception {
		try {
			Optional<Entity> entityOptional = baseRepository.findById(id);
			Entity entityUpdate = entityOptional.get();
			entityUpdate = baseRepository.save(entity);
			return entityUpdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(ID id) throws Exception {
		try {
			if (baseRepository.existsById(id)) {
				baseRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
}
