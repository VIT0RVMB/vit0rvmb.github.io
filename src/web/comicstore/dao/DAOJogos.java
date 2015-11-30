package web.comicstore.dao;

import java.util.List;

import web.comicstore.entidade.Jogos;

public interface DAOJogos {

	public void inserir( Jogos j );
	public void atualizar( Jogos j );
	public void remover( int codigo );
	public List<Jogos> pesquisarPorNome( String nome );
	public List<Jogos> pesquisarPorDistribuidora ( String distribuidora );
	public List<Jogos> pesquisarPorGenero(String genero);
	
}
