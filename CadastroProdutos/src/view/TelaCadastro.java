package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.DAOProdutos;

/**
 *
 * @author Diego R. S. Arimura
 */
public class TelaCadastro extends JDialog{
    
    // atributo
    private JPanel panel;
    
    public TelaCadastro() {
        this.initialize();
        this.setModal(true);
    }
    
    //inicialização da janela
    public void initialize(){
        //cria o novo objeto para o JPanel
        panel = new JPanel(new GridBagLayout());
        
        //grid layout
        //12 linhas e 2 colunas
        GridLayout gl = new GridLayout(12, 2, 10, 10);
        panel.setLayout(gl); 
        
        //Adicionando Labels, ComboBoxes, TextField e Buttons
        panel.add(new JLabel("STATUS"));
        Object[] status = {"ATIVO", "INATIVO"};
        JComboBox statusComboBox = new JComboBox(status);
        panel.add(statusComboBox);
        panel.add(new JLabel("CÓDIGO:"));
        JTextField codigoField = new JTextField();
        panel.add(codigoField);
        panel.add(new JLabel("CÓD. BARRAS:"));
        JTextField codigoBarrasField = new JTextField();
        panel.add(codigoBarrasField);
        panel.add(new JLabel("REFERÊNCIA:"));
        JTextField referenciaField = new JTextField();
        panel.add(referenciaField);
        panel.add(new JLabel("DEPARTAMENTO/SETOR"));
        Object[] department = {"ELETRÔNICOS", "VESTUÁRIO", "ALIMENTOS", "BEBIDAS", "HIGIENE PESSOAL", "LIMPEZA", "PAPELARIA", "FERRAMENTAS", "BRINQUEDOS", "MÓVEIS", "DECORAÇÃO", "ESPORTE", "PET SHOP", "INSTRUMENTOS MUSICAIS", "ACESSÓRIOS PARA CELULAR E ELETRÔNICOS", "JARDINAGEM", "AUTOMOTIVO", "SAÚDE E BEM-ESTAR", "CONSTRUÇÃO E REFORMA"};
        JComboBox departmentComboBox = new JComboBox(department);
        panel.add(departmentComboBox);
        panel.add(new JLabel("NOME PRODUTO:"));
        JTextField nomeProdutoField = new JTextField();
        panel.add(nomeProdutoField);
        panel.add(new JLabel("NOME ABREVIADO:"));
        JTextField nomeAbreviadoField = new JTextField();
        panel.add(nomeAbreviadoField);
        panel.add(new JLabel("PREÇO:"));
        JTextField precoField = new JTextField();
        panel.add(precoField);
        panel.add(new JLabel("CUSTO:"));
        JTextField custoField = new JTextField();
        panel.add(custoField);
        panel.add(new JLabel("MARGEM:"));
        JTextField margemField = new JTextField();
        panel.add(margemField);
        String button_salvar = "SALVAR";
        JButton bt_save = new JButton(button_salvar);
        panel.add(bt_save);
        String button_cancela = "CANCELAR";
        JButton bt_cancel = new JButton(button_cancela);
        panel.add(bt_cancel);
        
        

        //Botão SALVAR
        bt_save.addActionListener((e) -> {
          
            Thread t = new Thread(() -> {
            
                try {
                    String selectedStatus = (String) statusComboBox.getSelectedItem();
                    int codigo = Integer.parseInt(codigoField.getText());
                    int codigoBarras = Integer.parseInt(codigoBarrasField.getText());
                    String referencia = referenciaField.getText();
                    String departamento = (String) departmentComboBox.getSelectedItem();
                    String nomeProduto = nomeProdutoField.getText();
                    String nomeAbreviado = nomeAbreviadoField.getText();
                    double preco = Double.parseDouble(precoField.getText());
                    double custo = Double.parseDouble(custoField.getText());
                    double margem = Double.parseDouble(margemField.getText());

                    // verifique se todos os campos obrigatórios estão preenchidos
                    if (codigoField.getText().isEmpty() || codigoBarrasField.getText().isEmpty() || nomeProdutoField.getText().isEmpty() || precoField.getText().isEmpty() || custoField.getText().isEmpty() || margemField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                DAOProdutos dao = DAOProdutos.getInstance();
                dao.save(selectedStatus, codigo, codigoBarras, referencia, departamento, nomeProduto, nomeAbreviado, preco, custo, margem);

                String msg = "SALVO!";
                System.out.println(msg);
                JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO!!!");
                dispose();

                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });
            t.start();
        });
            
        //Botão CANCELAR
        bt_cancel.addActionListener(e -> {
            dispose();
            TelaPrincipal telaPrincipal;
            try {
                telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }    
        });
        
        //seta o tamanho e a posição da janela
        this.setBounds(0, 0, 800, 400);
        // adiciona o panel no Frame
        this.add(panel);
        //define o tamanho default da janela
        this.setPreferredSize(new Dimension(800,400));
        //define o título da janela
        this.setTitle("CADASTRO DE PRODUTOS");
        this.pack();
        //exibe
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //define que quando fechar a janela,o programa acaba  
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }   
}
