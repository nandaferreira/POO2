abstract class Biblioteca {
    protected String titulo;
    protected int ano;

    public Biblioteca (String titulo, int ano){
        this.titulo = titulo;
        this.ano = ano;
    }
    public abstract String getDados();

}
