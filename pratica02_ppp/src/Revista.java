public class Revista extends Biblioteca {
    private String editora;

    public Revista(String titulo, int ano, String editora){
        super(titulo, ano);
        this.editora = editora;
    }

    public String geteditora(){
        return editora;
    }

    public void seteditora(String editora){
        this.editora = editora;
    }
    public String getDados(){
        return "Nome: " + super.titulo + "\n"
                + "Ano publicação: " + super.ano + "\n"
                + "Editora: " + editora;
    }
}
