package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//implements ActionListener
public class TelaPrincipal extends JFrame  {
    
    //atributos
    private JPanel panel;
    private JPanel panel_botoes;
    private JButton bt_novo;
    private JButton bt_deletar;
    private JButton bt_sair;
    private JLabel label_title;
    //itens do menu
    private JMenuBar b_menu;
    private JMenu menu_programa;
    private JMenuItem item_cadastro;
    private JMenuItem item_sair;
    
    public TelaPrincipal() {
        this.initialize();
        this.setExtendedState(NORMAL);
    }
    
    //inicialização
    public void initialize(){
        //botões
        bt_novo = new JButton("Novo");
        bt_deletar = new JButton("Apagar");
        bt_sair = new JButton("Sair");
        //título
        label_title = new JLabel("Listagem de Produtos");
        //painéis
        panel = new JPanel();
        panel_botoes = new JPanel();
        b_menu = new JMenuBar();
        menu_programa = new JMenu("Programa");
        item_cadastro = new JMenuItem("Cadastrar Produtos");
        item_sair = new JMenuItem("Sair");

        //layout do painel total
        panel.setLayout(new BorderLayout(5, 5));
        //tamanho da janela
        this.setBounds(0, 0, 800, 400);
        this.setPreferredSize(new Dimension(800, 400));

        //adicao de elementos
        panel.add(label_title, BorderLayout.PAGE_START);

        //subpainel de botoes
        panel_botoes.setLayout(new GridLayout(6, 1, 10, 10));
        //configura os botoes
        bt_sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        bt_novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro c = new TelaCadastro();
            }
        });
        
        //configura o item do menu
        item_sair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        //configura o item do menu
        item_cadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro c = new TelaCadastro();
            }
        });
        //adiciona
        panel_botoes.add(bt_novo);
        panel_botoes.add(bt_deletar);
        panel_botoes.add(bt_sair);
        //coloca o subpainel no painel-mae
        panel.add(panel_botoes, BorderLayout.LINE_END);
        
        //configuração do menu
        //adicao dos itens do menu
        menu_programa.add(item_cadastro);
        menu_programa.addSeparator();
        menu_programa.add(item_sair);
        b_menu.add(menu_programa);
        this.setJMenuBar(b_menu); //seta o menu
        
        // adiciona o panel no Frame
        this.add(panel);
        this.pack();
        //define o título da janela
        this.setTitle("Cadastro de Produtos");
        //exibe
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //define que quando fechar a janela, o programa acaba
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
