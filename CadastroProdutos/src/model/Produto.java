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
    
    //Métodos Getters e Setters
    public int getId() {
        return id;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigoBarras() {
        return codigoBarras;
    }
    
    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    public String getSelectedStatus() {
        return selectedStatus;
    }
    
    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }
    
    public String getReferencia() {
        return referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public String getNomeAbreviado() {
        return nomeAbreviado;
    }
    
    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public double getCusto() {
        return custo;
    }
    
    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public double getMargem() {
        return margem;
    }
    
    public void setMargem(double margem) {
        this.margem = margem;
    }
    
    
    @Override
    public String toString(){
        return this.nomeProduto;
    }
}
