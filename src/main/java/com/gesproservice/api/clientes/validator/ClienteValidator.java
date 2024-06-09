package com.gesproservice.api.clientes.validator;

import com.gesproservice.api.clientes.persistence.dto.ClienteDTO;
import com.gesproservice.utils.exception.BackServiceEnumError;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {
	
	public void validarTipoDocumento(String tipoDoc) {
		if(tipoDoc == null || tipoDoc.equals("")) {
			throw new IllegalArgumentException(BackServiceEnumError.TIPO_DOCUMENTO_INVALIDO.getDescription());
		}
		if(!tipoDoc.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException(BackServiceEnumError.TIPO_DOCUMENTO_INVALIDO.getDescription());
		}
	}
	
	public void validarNumeroDocumento(String numDoc) {
		if(numDoc == null || numDoc.equals("")) {
			throw new IllegalArgumentException(BackServiceEnumError.NUMERO_DOCUMENTO_INVALIDO.getDescription());
		}
		if(!numDoc.matches("[0-9]+")) {
			throw new IllegalArgumentException(BackServiceEnumError.NUMERO_DOCUMENTO_INVALIDO.getDescription());
		}
	}	

	public void validarDatosCompletos(ClienteDTO clienteDTO) throws Exception {
		validarDatosDeIdentidad(clienteDTO);
		validadDatosDeContacto(clienteDTO);
		validarDatosDeDireccion(clienteDTO);
		validadDatosDeCodigoLista(clienteDTO);
		validadDatosDeCodigoVendedor(clienteDTO);
	}
	
	public void validarDatosMinimosActualizar(ClienteDTO clienteDTO) throws Exception {
		validarDatosDeIdentidad(clienteDTO);
		
	}
	
	public void validarDatosMinimosAgregar(ClienteDTO clienteDTO) throws Exception {
		validarDatosDeIdentidad(clienteDTO);
		
	}

	private void validarDatosDeIdentidad(ClienteDTO clienteDTO) throws Exception {
		if (clienteDTO.getDocTipo() == null) {
			System.out.println("Falta completar Tipo de Documento");
			throw new Exception("Falta completar Tipo de Documento.");
		}
		if (clienteDTO.getDocNumero() == null) {
			System.out.println("Falta completar Número de Documento.");
			throw new Exception("Falta completar Número de Documento.");
		}
	}
	
	private void validadDatosDeContacto(ClienteDTO clienteDTO) throws Exception {
		if (clienteDTO.getDetalleNombre() == null) {
			System.out.println("Falta completar Nombre/Apellido/RazónSocial.");
			throw new Exception("Falta completar Nombre/Apellido/RazónSocial.");
		}
		if (clienteDTO.getContactoTel01() == null && clienteDTO.getContactoTel02() == null) {
			System.out.println("Falta completar Número de Teléfono.");
			throw new Exception("Falta completar Número de Teléfono.");
		}
		if (clienteDTO.getContactoEmail() == null) {
			System.out.println("Falta completar Dirección de Mail.");
			throw new Exception("Falta completar Dirección de Mail.");
		}
	}
	
	private void validarDatosDeDireccion(ClienteDTO clienteDTO) throws Exception {
		if (clienteDTO.getDirCalle() == null) {
			System.out.println("Falta completar Dirección.");
			throw new Exception("Falta completar Dirección.");
		}
		if (clienteDTO.getDirNumero() == null) {
			System.out.println("Falta completar Número.");
			throw new Exception("Falta completar Número.");
		}
		if (clienteDTO.getDirLetraNumeroDepto() == null) {
			System.out.println("Falta completar Letra/Número Departamento.");
			throw new Exception("Falta completar Letra/Número Departamento.");
		}
		if (clienteDTO.getDirCodLocalidad() == null) {
			System.out.println("Falta completar Código/Detalle de la Localidad.");
			throw new Exception("Falta completar Código/Detalle de la Localidad.");
		}
		if (clienteDTO.getDirCodProvincia() == null) {
			System.out.println("Falta completar Código/Detalle de la Provincia.");
			throw new Exception("Falta completar Código/Detalle de la Provincia.");
		}		
	}
	
	private void validadDatosDeCodigoLista(ClienteDTO clienteDTO) throws Exception {
		if (clienteDTO.getCodigoLista() == null) {
			System.out.println("Falta completar Código/Tipo Lista.");
			throw new Exception("Falta completar Código/Tipo Lista.");
		}
	}
	
	private void validadDatosDeCodigoVendedor(ClienteDTO clienteDTO) throws Exception {
		if (clienteDTO.getCodigoVendedor() == null) {
			System.out.println("Falta completar Código/Detalle del Vendedor.");
			throw new Exception("Falta completar Código/Detalle del Vendedor.");
		}
	}	
}
