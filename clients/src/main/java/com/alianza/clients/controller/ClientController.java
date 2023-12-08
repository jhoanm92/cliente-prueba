package com.alianza.clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.clients.dto.ClientDTO;
import com.alianza.clients.dto.ResponseDTO;
import com.alianza.clients.service.ClientServiceInterf;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/client")
@Validated
public class ClientController {

	@Autowired
	private ClientServiceInterf clientService;

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<ClientDTO>>> list() {
		ResponseDTO<List<ClientDTO>> responseDTO = new ResponseDTO<>();
		List<ClientDTO> list = this.clientService.getAll();
		HttpStatus httpStatus = HttpStatus.OK;
		responseDTO.setCodeStatus(httpStatus.value());
		responseDTO.setMessageInfo("Operacion exitosa");
		responseDTO.setData(list);
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<String>> save(@Valid @RequestBody(required = true) ClientDTO dto) {
		ResponseDTO<String> responseDTO = new ResponseDTO<>();
		this.clientService.save(dto);
		HttpStatus httpStatus = HttpStatus.CREATED;
		responseDTO.setCodeStatus(httpStatus.value());
		responseDTO.setMessageInfo("Operacion exitosa");
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

	@GetMapping(value = "/search/{sharedKey}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<ClientDTO>>> searchBySharedKey(
			@PathVariable(value = "sharedKey", required = true) String sharedKey) {
		ResponseDTO<List<ClientDTO>> responseDTO = new ResponseDTO<>();
		List<ClientDTO> listOutDto = this.clientService.search(sharedKey);
		HttpStatus httpStatus = HttpStatus.OK;
		responseDTO.setCodeStatus(httpStatus.value());
		responseDTO.setMessageInfo("Operacion exitosa");
		responseDTO.setData(listOutDto);
		return new ResponseEntity<>(responseDTO, httpStatus);
	}

}
