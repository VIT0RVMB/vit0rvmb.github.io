package Testes;

import java.util.List;

import web.comicstore.controle.FuncionarioLoginMB;
import web.comicstore.dao.DAOFuncionarioLogin;
import web.comicstore.dao.DAOFuncionarioLoginImpl;
import web.comicstore.dao.DAOJogos;
import web.comicstore.dao.DAOJogosImpl;
import web.comicstore.dao.DAOProduto;
import web.comicstore.dao.DAOProdutoImpl;
import web.comicstore.entidade.FuncionarioLogin;
import web.comicstore.entidade.Jogos;
import web.comicstore.entidade.Produto;

public class TesteBanco {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOFuncionarioLogin daofl= new DAOFuncionarioLoginImpl();
		FuncionarioLogin fl = new FuncionarioLogin();
		DAOJogos daoj = new DAOJogosImpl();
		Jogos jogo = new Jogos();
		fl.setUserID("vmborges");
		fl.setSenha("333");
		
//		daofl.inserir(fl);
		
		
		DAOProduto daop = new  DAOProdutoImpl();
		Produto produtoAtual = new Produto();
		produtoAtual.setNome("a");
		List<Produto> listaProduto=daop.pesquisarPorNome(produtoAtual .getNome());
		
		System.out.println("sahusauh"+listaProduto.get(0));
		
		
//		daofl.validaLogin(fl);
	}

	public String validaLogin(FuncionarioLogin fl){
		String status=null;
		DAOFuncionarioLogin daofl = new DAOFuncionarioLoginImpl();
		fl=daofl.pesquisar(fl.getUserID());
		if(fl.getSenha().equals(fl.getSenha())){
			status="\teste";
		}else{
			System.out.println("Senha Incorreta");
		}
		/*if(getUserID().equals("vmborges")&&getSenha().equalsIgnoreCase("30051994")){
			status="\teste";
		}*/
		return status;
	}


}
