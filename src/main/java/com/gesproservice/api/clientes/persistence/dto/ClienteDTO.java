package com.gesproservice.api.clientes.persistence.dto;

public class ClienteDTO {
	
	// DATOS-DE-IDENTIDAD
	private String docTipo;	
	private String docNumero;
	
	// DATOS-DE-CONTACTO
	private String detalleNombre;
	private String contactoTel01;
	private String contactoTel02;
	private String contactoEmail;
	
	// DATOS-DE-DIRECCION
	private String dirCalle;
	private String dirNumero;
	private String dirLetraNumeroDepto;
	private Byte dirCodLocalidad;
	private Byte dirCodProvincia;
	
	// OTROS-DATOS
	private Byte codigoLista;
	private Byte codigoVendedor;
	
	private Boolean estadoHabilitado;
	/*
	*/
	public String getDocTipo() {
		return docTipo;
	}
	public void setDocTipo(String docTipo) {
		this.docTipo = docTipo;
	}
	public String getDocNumero() {
		return docNumero;
	}
	public void setDocNumero(String docNumero) {
		this.docNumero = docNumero;
	}
	public String getDetalleNombre() {
		return detalleNombre;
	}
	public void setDetalleNombre(String nombre) {
		this.detalleNombre = nombre;
	}
	public String getContactoTel01() {
		return contactoTel01;
	}
	public void setContactoTel01(String contactoTel01) {
		this.contactoTel01 = contactoTel01;
	}
	public String getContactoTel02() {
		return contactoTel02;
	}
	public void setContactoTel02(String contactoTel02) {
		this.contactoTel02 = contactoTel02;
	}
	public String getContactoEmail() {
		return contactoEmail;
	}
	public void setContactoEmail(String contactoEmail) {
		this.contactoEmail = contactoEmail;
	}
	public String getDirCalle() {
		return dirCalle;
	}
	public void setDirCalle(String dirCalle) {
		this.dirCalle = dirCalle;
	}
	public String getDirNumero() {
		return dirNumero;
	}
	public void setDirNumero(String dirNumero) {
		this.dirNumero = dirNumero;
	}
	public String getDirLetraNumeroDepto() {
		return dirLetraNumeroDepto;
	}
	public void setDirLetraNumeroDepto(String dirDepto) {
		this.dirLetraNumeroDepto = dirDepto;
	}
	public Byte getDirCodLocalidad() {
		return dirCodLocalidad;
	}
	public void setDirCodLocalidad(Byte dirCodLocalidad) {
		this.dirCodLocalidad = dirCodLocalidad;
	}
	public Byte getDirCodProvincia() {
		return dirCodProvincia;
	}
	public void setDirCodProvincia(Byte dirCodProvincia) {
		this.dirCodProvincia = dirCodProvincia;
	}
	public Byte getCodigoLista() {
		return codigoLista;
	}
	public void setCodigoLista(Byte codigoLista) {
		this.codigoLista = codigoLista;
	}
	public Byte getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Byte codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public Boolean getEstadoHabilitado() {
		return estadoHabilitado;
	}
	public void setEstadoHabilitado(Boolean estadoHabilitado) {
		this.estadoHabilitado = estadoHabilitado;
	}
}
