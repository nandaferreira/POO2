import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaBiblioteca extends JFrame {
    private ArrayList<Biblioteca> listaLivrosRevistas = new ArrayList<>();
    private JTextArea localListagem;

    public TelaBiblioteca() {
        setTitle(" -----Prática semana 2: Controle de material bibliotecário ----- " + "\n");
        setSize(200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //--se não colocar o programa continua executando mesmo se fechar a janelinhas
        JPanel painel = new JPanel();
        JTextField espacoNome = new JTextField(30);
        JTextField espacoAno = new JTextField(15);
        JTextField espacoAutor = new JTextField(30);
        JTextField espacoDuracao = new JTextField(15);
        JComboBox<String> tipoMaterial = new JComboBox<>(new String[]{"Livro", "Revista", "Vídeo"});
        JButton botaoAdd = new JButton("Adicionar");

        botaoAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String titulo = espacoNome.getText();
                int ano = Integer.parseInt(espacoAno.getText());
                String tipo = (String) tipoMaterial.getSelectedItem();

                if (tipo.equals("Livro")) {
                    String autor = espacoAutor.getText();
                    Livro livro = new Livro(titulo, ano, autor);
                    listaLivrosRevistas.add(livro);
                } else if (tipo.equals("Revista")) {
                    String editora = espacoAutor.getText();
                    Revista revista = new Revista(titulo, ano, editora);
                    listaLivrosRevistas.add(revista);
                } else if (tipo.equals("Vídeo")) {
                    String autor = espacoAutor.getText();
                    int duracao = Integer.parseInt(espacoDuracao.getText());
                    Video video = new Video(titulo, ano, autor, duracao);
                    listaLivrosRevistas.add(video);
                }

                espacoNome.setText("");
                espacoAno.setText("");
                espacoAutor.setText("");
                espacoDuracao.setText("");
            }
        });

        painel.add(new JLabel("Tipo:"));
        painel.add(tipoMaterial);
        painel.add(new JLabel("Título:"));
        painel.add(espacoNome);
        painel.add(new JLabel("Ano:"));
        painel.add(espacoAno);
        painel.add(new JLabel("Autor/Editora:"));
        painel.add(espacoAutor);
        painel.add(new JLabel("Duração (min):"));
        painel.add(espacoDuracao);
        painel.add(botaoAdd);

        JPanel painelLista = new JPanel();
        localListagem = new JTextArea(8, 20);
        JButton botaoListar = new JButton("Listar");

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                localListagem.setText("");
                for (Biblioteca material : listaLivrosRevistas) {
                    localListagem.append(material.getDados() + "\n");
                }
            }
        });

        painelLista.add(new JScrollPane(localListagem));
        painelLista.add(botaoListar);

        // Adiciona os painéis à janela
        getContentPane().add(painel, "North");
        getContentPane().add(painelLista, "Center");
    }

    public static void main(String[] args) {
        TelaBiblioteca tela = new TelaBiblioteca();
        tela.setVisible(true);
    }
}