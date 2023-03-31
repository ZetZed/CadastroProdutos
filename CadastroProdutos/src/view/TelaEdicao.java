package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.DAOProdutos;
import model.Produto;

/**
 *
 * @author Diego R. S. Arimura
 */
public class TelaEdicao extends JFrame{
    
    // atributos
    private DAOProdutos dao;
    private Produto produto;
    private JList<Produto> lista;
    
    private boolean produtoAtualizado = false;
    
    private JLabel label_status;
    private JLabel label_codigo;
    private JLabel label_codBarras;
    private JLabel label_referencia;
    private JLabel label_departamento;
    private JLabel label_nomeProduto;
    private JLabel label_nomeAbreviado;
    private JLabel label_preco;
    private JLabel label_custo;
    private JLabel label_margem;
    
    private Object[] status = {"ATIVO", "INATIVO"};
    private JComboBox campo_status= new JComboBox(status);
    private Object[] department = {"ELETRÔNICOS", "VESTUÁRIO", "ALIMENTOS", "BEBIDAS", "HIGIENE PESSOAL", "LIMPEZA", "PAPELARIA", "FERRAMENTAS", "BRINQUEDOS", "MÓVEIS", "DECORAÇÃO", "ESPORTE", "PET SHOP", "INSTRUMENTOS MUSICAIS", "ACESSÓRIOS PARA CELULAR E ELETRÔNICOS", "JARDINAGEM", "AUTOMOTIVO", "SAÚDE E BEM-ESTAR", "CONSTRUÇÃO E REFORMA"};
    private JComboBox campo_departamento = new JComboBox(department);
    private JTextField campo_codigo;
    private JTextField campo_codBarras;
    private JTextField campo_referencia;
    private JTextField campo_nomeProduto;
    private JTextField campo_nomeAbreviado;
    private JTextField campo_preco;
    private JTextField campo_custo;
    private JTextField campo_margem;
    private JButton bt_salvar;
    private JButton bt_cancelar;
      
    public boolean isProdutoAtualizado(){
        return produtoAtualizado;
    }
    
    public TelaEdicao(Produto produto, DAOProdutos dao, JList<Produto> lista) {
        this.produto = produto;
        this.dao = dao;
        this.lista = lista;
        this.initialize();
        this.setExtendedState(NORMAL);
    }
    
    public void initialize() {
        // Configuração da janela        
        this.setBounds(0, 0, 800, 400);
        this.setPreferredSize(new Dimension(800, 400));
        this.setLayout(new BorderLayout(10, 10));
        this.setTitle("Edição de Produto");
        
        
        // Componentes da tela
        label_status = new JLabel("STATUS");
        label_codigo = new JLabel("CÓDIGO:");
        label_codBarras = new JLabel("CÓD. BARRAS:");
        label_referencia = new JLabel("REFERÊNCIA:");
        label_departamento = new JLabel("DEPARTAMENTO/SETOR");
        label_nomeProduto = new JLabel("NOME PRODUTO:");
        label_nomeAbreviado = new JLabel("NOME ABREVIADO:");
        label_preco = new JLabel("PREÇO:");
        label_custo = new JLabel("CUSTO:");
        label_margem = new JLabel("MARGEM:");
        
        campo_status.setSelectedItem(produto.getSelectedStatus());
        campo_codigo = new JTextField(String.valueOf(produto.getCodigo()));
        campo_codBarras = new JTextField(String.valueOf(produto.getCodigoBarras()));
        campo_referencia = new JTextField(produto.getReferencia());
        campo_departamento.setSelectedItem(produto.getDepartamento());
        campo_nomeProduto = new JTextField(produto.getNomeProduto());
        campo_nomeAbreviado = new JTextField(produto.getNomeAbreviado());
        campo_preco = new JTextField(String.valueOf(produto.getPreco()));
        campo_custo = new JTextField(String.valueOf(produto.getCusto()));
        campo_margem = new JTextField(String.valueOf(produto.getMargem()));
        
        bt_salvar = new JButton("SALVAR");
        bt_cancelar = new JButton("CANCELAR");
    
        // Painéis
        JPanel panel_campos = new JPanel(new GridLayout(11, 2));
        JPanel panel_botoes = new JPanel(new GridLayout(1, 2, 5, 5));
        
        // Adiciona os componentes aos painéis
        panel_campos.add(label_status);
        panel_campos.add(campo_status);
        panel_campos.add(label_codigo);
        panel_campos.add(campo_codigo);
        panel_campos.add(label_codBarras);
        panel_campos.add(campo_codBarras);
        panel_campos.add(label_referencia);
        panel_campos.add(campo_referencia);
        panel_campos.add(label_departamento);
        panel_campos.add(campo_departamento);
        panel_campos.add(label_nomeProduto);
        panel_campos.add(campo_nomeProduto);
        panel_campos.add(label_nomeAbreviado);
        panel_campos.add(campo_nomeAbreviado);
        panel_campos.add(label_preco);
        panel_campos.add(campo_preco);
        panel_campos.add(label_custo);
        panel_campos.add(campo_custo);
        panel_campos.add(label_margem);
        panel_campos.add(campo_margem);
        panel_botoes.add(bt_salvar);
        panel_botoes.add(bt_cancelar);
        
        // Adiciona os painéis à janela
        this.add(panel_campos, BorderLayout.CENTER);
        this.add(panel_botoes, BorderLayout.SOUTH);
        
        // Configuração dos botões
        bt_salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualiza o produto
                produto.setSelectedStatus((String) campo_status.getSelectedItem());
                produto.setCodigo(Integer.parseInt(campo_codigo.getText()));
                produto.setCodigoBarras(Integer.parseInt(campo_codBarras.getText()));
                produto.setReferencia(campo_referencia.getText());
                produto.setDepartamento((String) campo_departamento.getSelectedItem());
                produto.setNomeProduto(campo_nomeProduto.getText());
                produto.setNomeAbreviado(campo_nomeAbreviado.getText());
                produto.setPreco(Double.parseDouble(campo_preco.getText()));
                produto.setCusto(Double.parseDouble(campo_custo.getText()));
                produto.setMargem(Double.parseDouble(campo_margem.getText()));
                boolean sucesso = dao.update(produto);
                
                if(sucesso){
                    produtoAtualizado = true;
                    String msg = "ATUALIZADO!";
                    System.out.println(msg);
                    JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!!!");
                    lista.setModel(dao.list());
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR!!!");
                }
            }
        });
        
              
        
        bt_cancelar.addActionListener(e -> {
            dispose();
            TelaPrincipal telaPrincipal;
            try {
                telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }    
        });
        
        //Exibe a janela
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
}
