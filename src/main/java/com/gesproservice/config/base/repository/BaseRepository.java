package com.gesproservice.config.base.repository;

import com.gesproservice.config.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<Entity extends BaseEntity, ID extends Serializable> extends JpaRepository<Entity, ID> {

}
