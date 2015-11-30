package web.comicstore.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.context.FacesContext;


import web.comicstore.dao.DAOJogos;
import web.comicstore.dao.DAOJogosImpl;
import web.comicstore.entidade.Jogos;

@ManagedBean(name="jmb")
@SessionScoped
public class JogosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1229271082313197631L;
	
	private Jogos jogoAtual;
	private DAOJogos daoj;

	private List<Jogos> listaPesquisa;
	
	public JogosMB(){
		setJogoAtual(new Jogos());
		setDaoj(new DAOJogosImpl());
	}

	public DAOJogos getDaoj() {
		return daoj;
	}

	public void setDaoj(DAOJogos daoj) {
		this.daoj = daoj;
	}

	public Jogos getJogoAtual() {
		return jogoAtual;
	}

	public void setJogoAtual(Jogos jogoAtual) {
		this.jogoAtual = jogoAtual;
	}
	
	public String inserir(){
		String msg = "Erro ao adicionar jogo";
		
		daoj.inserir(jogoAtual);
		msg = "Jogo inserido com sucesso";
		jogoAtual = new Jogos();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		
		//mudar para a url da pag de jogos
		return "formNovoJogo";
	}
	
	public String pesquisar() { 
		String msg = "Erro ao pesquisar artefatos";
		try {
			listaPesquisa = daoj.pesquisarPorNome(jogoAtual.getNome());
			msg = "Foram encontrados " + listaPesquisa.size() + " jogos";
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		
		//mudar para a url da pag de jogos
		return "";
	}
	public String excluir(Jogos jo) { 
		String msg = "Erro ao remover o artefato";
		try {
			daoj.remover(jo.getCodigo());
			msg = "Jogo removido com sucesso";
			jogoAtual = new Jogos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		//mudar para a url da pag de jogos
		return "";
	}

}
