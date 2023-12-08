package com.alianza.clients.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FieldsValidationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que determina el nombre del campo/atributo/propiedad
	 */
	private String fieldName;

	/**
	 * Atributo que determina el contenido del mensaje
	 */
	private String message;

}
