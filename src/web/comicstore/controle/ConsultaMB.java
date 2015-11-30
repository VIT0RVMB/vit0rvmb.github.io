package web.comicstore.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import web.comicstore.dao.DAOCliente;
import web.comicstore.dao.DAOClienteImpl;
import web.comicstore.entidade.Cliente;

@ManagedBean(name="cmb")
@SessionScoped
public class ConsultaMB {
	
	private Cliente c;
	private DAOCliente daoc=new DAOClienteImpl();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private String cpf;
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String insereCpf(){
		 String pagina;
		 String msg=cpf;
		/*SessionUtil su = new SessionUtil();
		su.setParam("sessao", cpf);*/
		 FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		pagina="/consulta.xhtml";
		return pagina;
	}
	
	public void recuperaCpf(){
		SessionUtil.getParam("sessao");
	}
	public ConsultaMB(){
		c=new Cliente();
		daoc=new DAOClienteImpl();
		
	}
	
	
	
	public String pesquisa(){
		listaCliente = daoc.pesquisarPorNome(c.getNome());
		return null;
		
	}
}
