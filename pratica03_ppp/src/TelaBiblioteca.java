import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.io.*;

public class TelaBiblioteca extends JFrame {
    private ArrayList<Biblioteca> listaLivrosRevistas = new ArrayList<>();
    private JTextArea localListagem;

    public TelaBiblioteca() {
        grandeMetodo();
    }

    private void grandeMetodo(){
        setTitle(" -----Controle de material bibliotecário ----- " + "\n");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        localListagem = new JTextArea(8, 30);
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

        getContentPane().add(painel, "North");
        getContentPane().add(painelLista, "Center");

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoCarregar = new JButton("Carregar");

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarLista();
            }
        });

        botaoCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarLista();
                atualizarListagem();
            }
        });

        JPanel painelSalvarCarregar = new JPanel();
        painelSalvarCarregar.add(botaoSalvar);
        painelSalvarCarregar.add(botaoCarregar);
        getContentPane().add(painelSalvarCarregar, "South");

        carregarDadosIniciais();


    }

    private void carregarDadosIniciais(){
        listaLivrosRevistas.add(new Livro("Tudo é Rio", 2014, "Carla Madeira"));
        listaLivrosRevistas.add(new Revista("Capricho",1952, "Editora Abril"));
        listaLivrosRevistas.add(new Livro("Pessoais Normais", 2022, "Sally Rooney"));
    }

    private void atualizarListagem() {
        localListagem.setText("");
        for (Biblioteca material : listaLivrosRevistas) {
            localListagem.append(material.getDados() + "\n");
        }
    }

    private void salvarLista() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("biblioteca.dat"))) {
            oos.writeObject(listaLivrosRevistas);
            JOptionPane.showMessageDialog(this, "Lista salva com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a lista: " + e.getMessage());
        }
    }

    private void carregarLista() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("biblioteca.dat"))) {
            listaLivrosRevistas = (ArrayList<Biblioteca>) ois.readObject();
            JOptionPane.showMessageDialog(this, "Lista carregada com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a lista: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TelaBiblioteca tela = new TelaBiblioteca();
        tela.setVisible(true);
    }

}