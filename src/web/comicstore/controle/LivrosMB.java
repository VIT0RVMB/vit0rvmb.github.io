package web.comicstore.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import web.comicstore.dao.DAOLivros;
import web.comicstore.dao.DAOLivrosImpl;
import web.comicstore.entidade.Livros;

@ManagedBean(name="lmb")
@SessionScoped
public class LivrosMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6512384737745954097L;
	private Livros livroAtual;
	private DAOLivros daol;
	private List<Livros> listaPesquisa;
	
	
	public Livros getLivroAtual() {
		return livroAtual;
	}
	public void setLivroAtual(Livros livroAtual) {
		this.livroAtual = livroAtual;
	}
	public DAOLivros getDaol() {
		return daol;
	}
	public void setDaol(DAOLivros daol) {
		this.daol = daol;
	}
	
	public LivrosMB(){
		livroAtual = new Livros();
		daol = new DAOLivrosImpl();
	}
	
	public String inserir(){
		String msg = "Erro ao adicionar livro";
		
		daol.inserir(livroAtual);
		msg = "Livro inserido com sucesso";
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));
		
		//url
		return "formNovoLivro";
	}
	
	//não sei se a gente vai implementar todos os pesquisar
	public String pesquisar() { 
		String msg = "Erro ao pesquisar artefatos";
		try {
			listaPesquisa = daol.pesquisarPorNome(livroAtual.getNome());
			msg = "Foram encontrados " + listaPesquisa.size() + " jogos";
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		
		//mudar para a url da pag de livros
		return "";
	}
	public String excluir(Livros li) { 
		String msg = "Erro ao remover o artefato";
		try {
			daol.remover(li.getCodigo());
			msg = "Jogo removido com sucesso";
			livroAtual = new Livros();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		//mudar para a url da pag de livros
		return "";
	}
	

}
