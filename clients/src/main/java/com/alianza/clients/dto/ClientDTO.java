package com.alianza.clients.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String sharedKey;

	@NotBlank
	private String bussinessId;

	@NotBlank
	private String email;

	@NotBlank
	private String phone;

	private LocalDate dataAdded;


	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;


	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

}
