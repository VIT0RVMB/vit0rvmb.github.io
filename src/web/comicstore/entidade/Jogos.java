package web.comicstore.entidade;

public class Jogos extends Produto{
	
	private String distribuidora;
	private String genero;
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public String getDistribuidora() {
		return distribuidora;
	}
	
}
