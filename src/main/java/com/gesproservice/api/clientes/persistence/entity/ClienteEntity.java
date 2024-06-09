package com.gesproservice.api.clientes.persistence.entity;

import com.gesproservice.config.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity extends BaseEntity {

	private static final long serialVersionUID = -8005935957663164924L;

//*************************************************
//	ATRIBUTOS: start
//*************************************************			
	
	@Column(name = "cli_doc_tipo")
	private String cliDocTipo;	
	
	@Column(name = "cli_doc_numero")
	private String cliDocNumero;

	@Column(name = "cli_detalle_nombre")
	private String cliDetalleNombre;
	
	@Column(name = "cli_contacto_tel_01")
	private String cliContactoTel01;
	
	@Column(name = "cli_contacto_tel_02")
	private String cliContactoTel02;
	
	@Column(name = "cli_contacto_email")
	private String cliContactoEmail;
	
	@Column(name = "cli_dir_calle")
	private String cliDirCalle;
	
	@Column(name = "cli_dir_numero")
	private String cliDirNumero;
	
	@Column(name = "cli_dir_letra_numero_depto")
	private String cliDirLetraNumeroDepto;
	
	@Column(name = "cli_dir_cod_localidad")
	private Short cliDirCodLocalidad;
		
	@Column(name = "cli_dir_cod_provincia")
	private Byte cliDirCodProvincia;

	@Column(name = "cli_codigo_lista")
	private Byte cliCodigoLista;
	
	@Column(name = "cli_codigo_vendedor")
	private Byte cliCodigoVendedor;
	
	@Column(name = "cli_estado_habilitado")
	private Boolean cliEstadoHabilitado;
	
	
//*************************************************
//	ATRIBUTOS: end
//*************************************************	
	
	
//*************************************************
//	GETTERS & SETTERS: start
//*************************************************	
	
	public String getCliDocTipo() {
		return cliDocTipo;
	}

	public void setCliDocTipo(String cliDocTipo) {
		this.cliDocTipo = cliDocTipo;
	}	
	
	public String getCliDocNumero() {
		return cliDocNumero;
	}

	public void setCliDocNumero(String cliDocNumero) {
		this.cliDocNumero = cliDocNumero;
	}

	public String getCliDetalleNombre() {
		return cliDetalleNombre;
	}

	public void setCliDetalleNombre(String cliNombreApellido) {
		this.cliDetalleNombre = cliNombreApellido;
	}
	
	public String getCliContactoTel01() {
		return cliContactoTel01;
	}

	public void setCliContactoTel01(String cliContactoTel01) {
		this.cliContactoTel01 = cliContactoTel01;
	}

	public String getCliContactoTel02() {
		return cliContactoTel02;
	}

	public void setCliContactoTel02(String cliContactoTel02) {
		this.cliContactoTel02 = cliContactoTel02;
	}

	public String getCliContactoEmail() {
		return cliContactoEmail;
	}

	public void setCliContactoEmail(String cliContactoEmail) {
		this.cliContactoEmail = cliContactoEmail;
	}

	public String getCliDirCalle() {
		return cliDirCalle;
	}

	public void setCliDirCalle(String cliDirCalle) {
		this.cliDirCalle = cliDirCalle;
	}

	public String getCliDirNumero() {
		return cliDirNumero;
	}

	public void setCliDirNumero(String cliDirNumero) {
		this.cliDirNumero = cliDirNumero;
	}
	
	public String getCliDirLetraNumeroDepto() {
		return cliDirLetraNumeroDepto;
	}

	public void setCliDirLetraNumeroDepto(String cliDirDepto) {
		this.cliDirLetraNumeroDepto = cliDirDepto;
	}

	public Short getCliDirCodLocalidad() {
		return cliDirCodLocalidad;
	}

	public void setCliDirCodLocalidad(Short cliDirLocalidad) {
		this.cliDirCodLocalidad = cliDirLocalidad;
	}

	public Byte getCliDirCodProvincia() {
		return cliDirCodProvincia;
	}

	public void setCliDirCodProvincia(Byte cliDirProvincia) {
		this.cliDirCodProvincia = cliDirProvincia;
	}

	public Byte getCliCodigoLista() {
		return cliCodigoLista;
	}

	public void setCliCodigoLista(Byte cliCodigoLista) {
		this.cliCodigoLista = cliCodigoLista;
	}

	public Byte getCliCodigoVendedor() {
		return cliCodigoVendedor;
	}

	public void setCliCodigoVendedor(Byte cliCodigoVendedor) {
		this.cliCodigoVendedor = cliCodigoVendedor;
	}
	
	public Boolean getCliEstadoHabilitado() {
		return cliEstadoHabilitado;
	}

	public void setCliEstadoHabilitado(Boolean cliHabilitado) {
		this.cliEstadoHabilitado = cliHabilitado;
	}
	
//*************************************************
//	GETTERS & SETTERS: end
//*************************************************		
}
