package br.com.wefin.payload.request;

import javax.validation.constraints.NotBlank;

public class PersonRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String cpfOrCnpj;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}
}
