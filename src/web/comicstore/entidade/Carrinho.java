package web.comicstore.entidade;

import java.util.ArrayList;
import java.util.List;

import web.comicstore.constroleVendas.ControleVendas;

public class Carrinho {
		Produto p = new Produto ();
		ControleVendas cv = new ControleVendas();
		Produto_Carrinho pc = new Produto_Carrinho();
		
	public List<Produto_Carrinho> adicionarCarrinho(String nome, int quant){
		List<Produto_Carrinho> listaCarrinho = new ArrayList<Produto_Carrinho>();
		String n=nome;	
		p=cv.realizaPesquisaCarrinho(n);
		pc.setId(p.getCodigo());
		pc.setNome(p.getNome());
		pc.setPreco(p.getPreco());
		pc.setDesc(p.getDescricao());
		pc.setQuantidade(cv.recebeQuantidade(quant));
	
	
		listaCarrinho.add(pc);
			
		
		
		return listaCarrinho;
		
	}
	
}
