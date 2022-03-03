package br.com.microservice.fornecedor.config.validacao;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public class ErroDeFormularioDto {

	private String campo;
	private String erro;
	
	public ErroDeFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
