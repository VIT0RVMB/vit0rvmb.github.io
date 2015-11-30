package web.comicstore.controle.copy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import web.comicstore.dao.DAOProduto;
import web.comicstore.dao.DAOProdutoImpl;
import web.comicstore.entidade.Produto;
@ManagedBean(name="pmb")
@SessionScoped
public class ProdutoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5714778180134537292L;
	private Produto produtoAtual;
	private DAOProduto daop;
	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	private List<Produto> listaProduto = new ArrayList<Produto>();
	
	public ProdutoMB(){
		setProdutoAtual(new Produto());
		setDaop(new DAOProdutoImpl());
	}

	public Produto getProdutoAtual() {
		return produtoAtual;
	}

	public void setProdutoAtual(Produto produtoAtual) {
		this.produtoAtual = produtoAtual;
	}

	public DAOProduto getDaop() {
		return daop;
	}

	public void setDaop(DAOProduto daop) {
		this.daop = daop;
	}
	
	public String adicionar(){
		String msg = "Erro ao adicionar jogo";
		
		daop.inserir(produtoAtual);
		msg = "Jogo inserido com sucesso";
		produtoAtual = new Produto();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		
		//mudar para a url da pag de produto
		return "";
	}
	
	public String pesquisar() { 
		String msg = "Erro ao pesquisar os Produtos";
		try {
			listaProduto = daop.pesquisarPorNome(produtoAtual.getNome());
			msg = "Foram encontrados " + listaProduto.size() + " Produtos";
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		
		//mudar para a url da pag de produto
		return "consultaProduto";
	}
	public String excluir(Produto p) { 
		String msg = "Erro ao remover o Produto";
		try {
			daop.remover(p.getCodigo());
			msg = "Produto removido com sucesso";
			produtoAtual = new Produto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		//mudar para a url da pag de produto
		return "";
	}

}
