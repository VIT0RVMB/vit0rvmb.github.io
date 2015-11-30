package web.comicstore.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.SQLError;


import web.comicstore.dao.DAOCliente;
import web.comicstore.dao.DAOClienteImpl;
import web.comicstore.entidade.Cliente;


@ManagedBean(name="clmb")
@SessionScoped
public class ClienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5110913467100493418L;
	private Cliente c;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	private DAOCliente daoc;
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}
	public DAOCliente getDaoc() {
		return daoc;
	}
	public void setDaoc(DAOCliente daoc) {
		this.daoc = daoc;
	}
	
	public ClienteMB(){
		c = new Cliente();
		daoc=new DAOClienteImpl();
		
	}
	
	//pq void? usa string pra retornar a pagina pra onde isso vai mandar
	public void registraCliente(Cliente c){
			String msg="";
			
				
			
				daoc.inserir(c);
				msg="Usário Cadastrado no Sistema com Sucesso!";
				c = new Cliente();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage(msg) );
			
	}		
	
	public String pesquisar() { 
		String msg = "Erro ao pesquisar Cliente";
		try {
			listaCliente = daoc.pesquisarPorNome(nome);
			msg = "Foram encontrados " + listaCliente.size() + " clientes";
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage( msg ) );
		return "consulta";
	}
			
		
		
	
	
}
