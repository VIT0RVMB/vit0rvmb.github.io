package web.comicstore.controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;

import web.comicstore.dao.DAOFuncionarioLogin;
import web.comicstore.dao.DAOFuncionarioLoginImpl;
import web.comicstore.entidade.FuncionarioLogin;

@ManagedBean(name="flmb")
@ApplicationScoped
public class FuncionarioLoginMB implements Serializable{


	private static final long serialVersionUID = 1007050321065490792L;
	private FuncionarioLogin fl;
	private DAOFuncionarioLogin daofl;
	
	public FuncionarioLoginMB(){
		fl = new FuncionarioLogin();
		daofl = new  DAOFuncionarioLoginImpl();
	}

	public FuncionarioLogin getFl() {
		return fl;
	}

	public void setFl(FuncionarioLogin fl) {
		this.fl = fl;
	}
	
	public String validaLogin(FuncionarioLogin fl){
		String msgFaces="";
		String pagina = "";
		FuncionarioLogin fl1 = new FuncionarioLogin();
		try{
			fl1=daofl.pesquisar(fl.getUserID());
			if(fl1.getSenha().equals(fl.getSenha())){
				
				System.out.println("LOGIN REALIZADO");
				System.out.println("Senha Correta: "+fl1.getSenha()+"Digitada: "+fl.getSenha());
				pagina="home";
			}else{
				msgFaces="Senha incorreta";
				System.out.println("Senha Incorreta");
				System.out.println("Senha Correta: "+fl1.getSenha()+"Digitada: "+fl.getSenha());
				pagina="/index";
			}
		}catch(NullPointerException e){
			msgFaces="Usuário não encontrado";
			System.out.println("Usuário Não encontrado");
			pagina="/index";
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msgFaces) );
		return pagina;
	}
	
	public String adicionar(){
		
		String msg = "Erro ao adicionar o funcionario";
		try {
			daofl.inserir(fl);
			fl = new FuncionarioLogin();
			System.out.println(fl.getUserID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage(msg) );
		return "/index";
				
	}
	
}
