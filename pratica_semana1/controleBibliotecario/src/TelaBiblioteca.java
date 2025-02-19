import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaBiblioteca extends JFrame {
    private ArrayList<Biblioteca> listaLivrosRevistas = new ArrayList<>();
    private JTextArea localListagem;

    public TelaBiblioteca() {
        setTitle(" -----Prática semana 1: Controle de material bibliotecáro ----- " + "\n");
        setSize(200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //--se não colocar o programa continua executando mesmo se fechar a janelinhas
        JPanel painel = new JPanel();
        JTextField espacoNome = new JTextField(30);
        JTextField espacoAno = new JTextField(15);
        JButton botaoAdd = new JButton("Adicionar");

        botaoAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String titulo = espacoNome.getText();
                int ano = Integer.parseInt(espacoAno.getText());

                Livro livro = new Livro(titulo, ano, "Desconhecido");
                listaLivrosRevistas.add(livro);
                espacoNome.setText("");
                espacoAno.setText("");

            }
        });

        painel.add(new JLabel("Título:"));
        painel.add(espacoNome);
        painel.add(new JLabel("Ano:"));
        painel.add(espacoAno);
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


