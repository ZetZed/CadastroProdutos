package model;

/**
 *
 * @author Diego R. S. Arimura
 */
public class Produto {
    
    private int id, codigo, codigoBarras;
    private String selectedStatus, referencia, departamento, nomeProduto, nomeAbreviado;
    private double preco, custo, margem;
    
    //Construtor
    public Produto(String selectedStatus, int codigo, int codigoBarras, String referencia, String departamento, String nomeProduto, String nomeAbreviado, double preco, double custo, double margem){
        this.selectedStatus = selectedStatus;
        this.codigo = codigo;
        this.codigoBarras = codigoBarras;
        this.referencia = referencia;
        this.departamento = departamento;
        this.nomeProduto = nomeProduto;
        this.nomeAbreviado = nomeAbreviado;
        this.preco = preco;
        this.custo = custo;
        this.margem = margem;
    }
    public Produto(String selectedStatus, int codigo, int codigoBarras, String referencia, String departamento, String nomeProduto, String nomeAbreviado, double preco, double custo, double margem, int id){
        this.selectedStatus = selectedStatus;
        this.codigo = codigo;
        this.codigoBarras = codigoBarras;
        this.referencia = referencia;
        this.departamento = departamento;
        this.nomeProduto = nomeProduto;
        this.nomeAbreviado = nomeAbreviado;
        this.preco = preco;
        this.custo = custo;
        this.margem = margem;
        this.id = id;
    }
    
    //Método Getter Id
    public int getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return this.nomeProduto;
    }
}
