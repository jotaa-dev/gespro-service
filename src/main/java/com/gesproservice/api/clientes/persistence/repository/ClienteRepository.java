package com.gesproservice.api.clientes.persistence.repository;

import com.gesproservice.api.clientes.persistence.entity.ClienteEntity;
import com.gesproservice.config.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<ClienteEntity, Long>{
	
	boolean existsByCliDocTipoAndCliDocNumero(String cliDocTipo, String cliDocNum);
	
	@Query(value = "SELECT * FROM clientes WHERE clientes.cli_doc_tipo = :docTipo and clientes.cli_doc_numero = :docNum",
			nativeQuery = true)
	ClienteEntity getClientePorDni(@Param("docTipo") String docTipo, @Param("docNum") String docNum);
	
	
	
}
