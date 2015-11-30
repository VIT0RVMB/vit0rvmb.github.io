package web.comicstore.dao;

import java.util.List;

import web.comicstore.entidade.Livros;

public interface DAOLivros {

	public void inserir( Livros l );
	public void atualizar( Livros l);
	public void remover( int codigo );
	public List<Livros> pesquisarPorNome( String nome );
	public List<Livros> pesquisarPorISBN ( String isbn );
	
}
