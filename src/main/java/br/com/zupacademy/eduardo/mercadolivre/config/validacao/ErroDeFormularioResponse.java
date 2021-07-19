package br.com.zupacademy.eduardo.mercadolivre.config.validacao;

import javax.validation.constraints.NotBlank;

public class ErroDeFormularioResponse {
	
	@NotBlank
	private String campo;
	
	@NotBlank
	private String erro;
	
	public ErroDeFormularioResponse(String campo, String erro) {
		
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
