package com.alianza.clients.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alianza.clients.dto.FieldsValidationDTO;
import com.alianza.clients.dto.ResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO<List<FieldsValidationDTO>>> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpServletRequest request) {
		ResponseDTO<List<FieldsValidationDTO>> responseDTO = new ResponseDTO<>();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		responseDTO.setCodeStatus(httpStatus.value());
		responseDTO.setData(this.obtenerCamposErroresInDTO(ex.getBindingResult().getFieldErrors()));
		responseDTO.setMessageInfo("Complete correctamente los datos");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	private List<FieldsValidationDTO> obtenerCamposErroresInDTO(List<FieldError> errores) {
		return errores.stream().map(errorField -> {
			FieldsValidationDTO fieldsValidationDTO = new FieldsValidationDTO();
			fieldsValidationDTO.setFieldName(errorField.getField());
			fieldsValidationDTO.setMessage(errorField.getDefaultMessage());
			return fieldsValidationDTO;
		}).collect(Collectors.toList());
	}

}
