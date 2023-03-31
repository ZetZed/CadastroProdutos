package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.DefaultListModel;
/**
 *
 * @author Diego R. S. Arimura
 */
public class DAOProdutos {
    
    private Connection conexao;
    private static DAOProdutos instancia;
    
    private DAOProdutos() throws SQLException{
        try{
            //tenta carregar o driver
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            //se não carregar, vai cair na linha do ClassNotFound
            
            //Parâmetros de conexão ao banco
            String host = "localhost";
            String db = "cad_produtos";
            String url = "jdbc:mysql://" + host + "/" + db;
            String user = "root";
            String password = "root";
            
            this.conexao = DriverManager.getConnection(url, user, password);
            
            //testa conexão
            if (this.conexao != null){
                System.out.println("SUCESSO NA CONEXÃO COM O DB!");
            }else{
                System.err.println("ERRO NO DB!");
            }
        }
        catch(ClassNotFoundException e){
            // aqui quer dizer que o driver não foi encontrado
            System.out.println("O driver não foi encontrado");
        }
        catch(SQLException ex){
            System.err.println("Não foi possível conectar-se ao banco");
        }
    }
    
    //Método getInstance, faz a instanciação da única instância do DAO e retorna a única instância
    public static DAOProdutos getInstance() throws SQLException{
        if (instancia == null){
            instancia = new DAOProdutos();
        }
        return instancia;
    }
    
    //Método save, recebe os dados do produto a ser salvo
    public void save(String selectedStatus, int codigo, int codigoBarras, String referencia, String departamento, String nomeProduto, String nomeAbreviado, double preco, double custo, double margem){
        try{
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO produtos (status, codigo, codigoBarras, referencia, departamento, nomeProduto, nomeAbreviado, preco, custo, margem) " + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,selectedStatus);
            ps.setInt(2, codigo);
            ps.setInt(3,codigoBarras);
            ps.setString(4,referencia);
            ps.setString(5,departamento);
            ps.setString(6,nomeProduto);
            ps.setString(7,nomeAbreviado);
            ps.setDouble(8, preco);
            ps.setDouble(9, custo);
            ps.setDouble(10, margem);
            
            ps.execute();
        }
        catch(SQLException ez){
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ez);
        }
    }
    
    public DefaultListModel<Produto> list(){
        DefaultListModel<Produto> model = new DefaultListModel<>();
        try{
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                model.addElement(new Produto(
                    rs.getString("status"),
                    rs.getInt("codigo"),
                    rs.getInt("codigoBarras"),
                    rs.getString("referencia"),
                    rs.getString("departamento"),
                    rs.getString("nomeProduto"),
                    rs.getString("nomeAbreviado"),
                    rs.getDouble("preco"),
                    rs.getDouble("custo"),
                    rs.getDouble("margem"),
                    rs.getInt("id")
                ));
            }
            return model;
        }
        catch(SQLException ex){
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int id) {
        try{
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM produtos WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
