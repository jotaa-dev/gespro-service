package com.gesproservice.api.clientes.service;

import com.gesproservice.api.clientes.persistence.dto.ClienteDTO;
import com.gesproservice.api.clientes.persistence.entity.ClienteEntity;
import com.gesproservice.api.clientes.persistence.mapper.ClienteMapper;
import com.gesproservice.api.clientes.persistence.repository.ClienteRepository;
import com.gesproservice.api.clientes.validator.ClienteValidator;
import com.gesproservice.config.base.repository.BaseRepository;
import com.gesproservice.config.base.service.BaseServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<ClienteEntity, Long>{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteValidator clienteValidator;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	public ClienteServiceImpl(BaseRepository<ClienteEntity, Long> baseRepository,
								EntityManager entityManager) {
		super(baseRepository, entityManager);
	}
	
	/** 
	 * Descripción: funcion que nos permite identificar si existe el cliente
	 * registrado en la base de datos.
	 * 
	 * @param docTipo Tipo de Documento (DNI, ETC)
	 * @param docNum Numero de identificación, sin puntos ni caracteres.
	 * 
	 * @return Devuelve un valor true/false
	 * 
	 * */
	public boolean existeRegistro(String docTipo, String docNum) {
		return clienteRepository.existsByCliDocTipoAndCliDocNumero(docTipo, docNum);
	}
	

	public List<ClienteDTO> getClientes(ClienteDTO clienteDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ClienteEntity> clienteModelCriteriaQuery = criteriaBuilder.createQuery(ClienteEntity.class);
		
		Root<ClienteEntity> clienteModelRoot = clienteModelCriteriaQuery.from(ClienteEntity.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		// Doc_Tipo
		if(clienteDTO.getDocTipo() != null || !clienteDTO.getDocTipo().isEmpty()) {
			predicates.add(criteriaBuilder.and(criteriaBuilder
					.equal(clienteModelRoot.get("cliDocTipo"), clienteDTO.getDocTipo())));
		}
		
		// Doc_Num
		if(clienteDTO.getDocNumero() != null || !clienteDTO.getDocNumero().isEmpty()) {
			predicates.add(criteriaBuilder.and(criteriaBuilder
					.equal(clienteModelRoot.get("cliDocNumero"), clienteDTO.getDocNumero())));
		}
		
		// Nombre
		if(clienteDTO.getDetalleNombre() != null || !clienteDTO.getDetalleNombre().isEmpty()) {
			predicates.add(criteriaBuilder.and(criteriaBuilder
					.like(clienteModelRoot.get("cliNombre"), clienteDTO.getDetalleNombre())));
		}
		
		
		clienteModelCriteriaQuery = clienteModelCriteriaQuery
										.select(clienteModelRoot)
										.where(predicates.toArray(new Predicate[]{}));
		
		List<ClienteEntity> entityList = entityManager.createQuery(clienteModelCriteriaQuery).getResultList();
		List<ClienteDTO> dtoList = clienteMapper.toListaClienteDTO(entityList);
		
		return dtoList;
	}	
	
	public ClienteDTO getClientePorDni(String docTipo, String docNum) throws Exception {
		clienteValidator.validarTipoDocumento(docTipo);
		clienteValidator.validarNumeroDocumento(docNum);
		
		try {
			ClienteEntity clienteEntity = new ClienteEntity();
			ClienteDTO clienteDto = new ClienteDTO();
			
			clienteEntity = clienteRepository.getClientePorDni(docTipo, docNum);
			
			if (clienteEntity != null) {
				clienteDto = clienteMapper.toClienteDTO(clienteEntity);	
			} else {
				throw new Exception("Registro no encontrado");
			}
			
			return clienteDto;
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
		
	}
	
	public ClienteDTO addCliente(ClienteDTO clienteDTO) throws Exception {
		try {
			clienteValidator.validarDatosMinimosAgregar(clienteDTO);
		
			boolean addRegistro = !existeRegistro(clienteDTO.getDocTipo(), clienteDTO.getDocNumero());
			
			if (addRegistro) {
				ClienteEntity entity = new ClienteEntity();
				entity = clienteMapper.toClienteEntity(clienteDTO);
				entity = clienteRepository.save(entity);
				clienteDTO = clienteMapper.toClienteDTO(entity);
			} else {
				 throw new Exception("El registro ya existe.");
			}
			return clienteDTO;	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Metodo que se encarga de actualizar los datos de un cliente especifico
	 * 
	 * @param clienteDTO
	 * @return
	 * @throws Exception
	 */
	public ClienteDTO updateCliente(ClienteDTO clienteDTO) throws Exception {
		try {
			
			clienteValidator.validarDatosMinimosActualizar(clienteDTO);
			
			boolean updateRegistro = existeRegistro(clienteDTO.getDocTipo(), clienteDTO.getDocNumero());
			
			if (updateRegistro) {
				ClienteEntity entity = new ClienteEntity();
				entity = clienteMapper.toClienteEntity(clienteDTO);
				entity = clienteRepository.save(entity);
				clienteDTO = clienteMapper.toClienteDTO(entity);				
			}
			return clienteDTO;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
