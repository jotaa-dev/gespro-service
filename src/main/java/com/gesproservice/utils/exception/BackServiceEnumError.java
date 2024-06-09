package com.gesproservice.utils.exception;

public enum BackServiceEnumError {

	TIPO_DOCUMENTO_INVALIDO(1100, "Tipo de Documento Invalido"),
	NUMERO_DOCUMENTO_INVALIDO(1101, "Número de Documento Invalido"),
	TIPO_DOCUMENTO_FALTANTE(1111, "El numero de doc no puede estar vacio");
	
	private Integer code;
	private String description;
	
	BackServiceEnumError(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}
