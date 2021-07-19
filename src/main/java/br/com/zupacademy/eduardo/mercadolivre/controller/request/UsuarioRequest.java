package br.com.zupacademy.eduardo.mercadolivre.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.eduardo.mercadolivre.config.anotacao.UniqueValue;
import br.com.zupacademy.eduardo.mercadolivre.modelo.Usuario;
import br.com.zupacademy.eduardo.mercadolivre.seguranca.CriptoSenha;

public class UsuarioRequest {

	@UniqueValue(domainClass= Usuario.class, fieldName="email")
	private @Email @NotBlank String email;
	private @NotBlank @Length(min = 6) String senha;
	@PastOrPresent
	private LocalDateTime instanteCriacao = LocalDateTime.now();
	
	public UsuarioRequest(@Email @NotBlank String email, @NotBlank @Length(min = 6) String senha) {
		super();
		this.email = email;
		this.senha = senha;
		
	}
	
	public Usuario toModel()
	{
		CriptoSenha criptoSenha = new CriptoSenha(senha);
		return new Usuario(this.email, criptoSenha, this.instanteCriacao);
	}
}
