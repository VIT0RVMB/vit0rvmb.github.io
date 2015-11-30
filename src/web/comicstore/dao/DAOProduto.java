package web.comicstore.dao;

import java.util.List;

import web.comicstore.entidade.Produto;

public interface DAOProduto {
	public void inserir( Produto j );
	public void atualizar( Produto j );
	public void remover( int codigo );
	public List<Produto> pesquisarPorNome( String nome );
					
}
