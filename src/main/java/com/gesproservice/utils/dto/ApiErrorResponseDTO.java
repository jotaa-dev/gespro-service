package com.gesproservice.utils.dto;

import java.io.Serializable;

public class ApiErrorResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String descripcion;

	public ApiErrorResponseDTO() {
		super();
	}
	
	public ApiErrorResponseDTO(Integer codigoErr, String descripcionErr) {
		super();
		this.codigo = codigoErr;
		this.descripcion = descripcionErr;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigoErr) {
		this.codigo = codigoErr;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcionErr) {
		this.descripcion = descripcionErr;
	}
	

}
