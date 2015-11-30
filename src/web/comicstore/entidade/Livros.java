package web.comicstore.entidade;

public class Livros extends Produto{

	private String isbn;
	private String autor;
	private String editora;
	
	public String getISBN() {
		return isbn;
	}
	public void setISBN(String ISBN) {
		isbn = ISBN;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
