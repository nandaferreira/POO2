public class Livro extends Biblioteca {
    private String autor;

    public Livro(String titulo, int ano, String autor) {
        super(titulo, ano);
        this.autor = autor;
    }

    public String getautor(){
        return autor;
    }
    public void setautor(String autor){
        this.autor = autor;
    }

    public String getDados(){
        return "Livro:"  + super.titulo + "\n"
                + "Ano: " + super.ano + "\n"
                + "Autor: " + autor;
    }
}
