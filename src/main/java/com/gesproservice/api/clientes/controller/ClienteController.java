package com.gesproservice.api.clientes.controller;

import com.gesproservice.api.clientes.persistence.dto.ClienteDTO;
import com.gesproservice.api.clientes.persistence.entity.ClienteEntity;
import com.gesproservice.api.clientes.service.ClienteServiceImpl;
import com.gesproservice.config.base.controller.BaseControllerImpl;
import com.gesproservice.utils.dto.ApiErrorResponseDTO;
//import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/clientes")
public class ClienteController extends BaseControllerImpl<ClienteEntity, ClienteServiceImpl>{
	
	//@Operation(summary = "Permite actualizar un registro de cliente ya existente.")
	@PutMapping("/actulizarCliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(service.updateCliente(clienteDTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(("{\"error\": \"" + e.getMessage() + "\"}"));
		}
	}	
	
	//@Operation(summary = "Permite agregar un nuevo registro de cliente.")
	@PostMapping("/agregarCliente")
	public ResponseEntity<?> agregarCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(service.addCliente(clienteDTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(("{\"error\": \"" + e.getMessage() + "\"}"));
		}
	}
	
	//@Operation(summary = "Obtiene todos los datos de un cliente.")
	@GetMapping("/obtenerCliente/{docTipo}/{docNum}")
	public ResponseEntity<?> obtenerClientePorDni(@PathVariable String docTipo, @PathVariable String docNum) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(service.getClientePorDni(docTipo, docNum));
		} catch (IllegalArgumentException e) {	
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiErrorResponseDTO(HttpStatus.NOT_FOUND.value(), e.getMessage()));
		}
	}	
	
	//@Operation(summary = "Obtiene una lista es base a diferentes parametros.")
	@PostMapping("/obtenerClientes")
	public ResponseEntity<?> obtenerClientes(@RequestBody ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(service.getClientes(clienteDTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(("{\"error\": \"" + e.getMessage() + "\"}"));
		}
	}

}
