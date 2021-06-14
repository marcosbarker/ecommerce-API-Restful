package com.residencia.ecommerce.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EsqueciSenhaVO {
	
	@NotBlank(message = "Insira seu e-mail")
    @Email
    @Pattern(regexp = ".+@.+\\..+", message = "E-mail fornecido não é válido")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
