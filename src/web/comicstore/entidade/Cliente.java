package web.comicstore.entidade;

import java.text.SimpleDateFormat;


public class Cliente {

	private String cpf;
	private String nome;
	private java.util.Date nascimento;
	private String endereco;
	private String complemento;
	private String telefone;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public java.util.Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(java.util.Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	

}
