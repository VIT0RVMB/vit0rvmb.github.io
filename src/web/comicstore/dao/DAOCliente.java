	package web.comicstore.dao;

import java.util.List;

import web.comicstore.entidade.Cliente;

public interface DAOCliente {
	
	public void inserir( Cliente c );
	public void atualizar( String cpf, Cliente c );
	public void remover( String cpf );
	public List<Cliente> pesquisarPorNome( String nome );
	public List<Cliente> pesquisarPorCpf( String cpf );
	public Cliente pesquisarEditarCliente(String cpf);
	
}
