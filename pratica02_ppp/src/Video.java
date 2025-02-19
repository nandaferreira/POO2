public class Video extends Biblioteca {
    private String autor;
    private int duracao;

    public Video(String titulo, int ano, String autor, int duracao){
        super(titulo, ano);
        this.autor = autor;
        this.duracao = duracao;
    }

    public String getautor(){return autor;}
    public void setautor(String autor){this.autor = autor;}

    public int getduracao(){return duracao;}
    public void setduracao(int duracao){this.duracao = duracao;}

    public String getDados(){
        return("Titulo do video: " + super.titulo + "\n"
                + "Ano: " + super.ano + "\n"
                + "Autor: " + autor + "\n"
                + "Duração" + duracao + "\n"
        );
    }

}

