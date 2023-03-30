package cadastroprodutos;

/**
 *
 * @author Diego R. S. Arimura
 */
public class Produto {
    
    private int codigo, codigoBarras;
    private String selectedStatus, referencia, departamento, nomeProduto, nomeAbreviado;
    private double preco, custo, margem;
    
    //Construtor
    public Produto(String selectedStatus, int codigo, int codigoBarras, String referencia, String departamento, String nomeProduto, String nomeAbreviado, double preco, double custo, double margem){            this.selectedStatus = selectedStatus;
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
    
    //Getters e Setters
    public String getSelectedStatus(){
        return selectedStatus;
    }
    public void setSelectedStatus() {
        this.selectedStatus = selectedStatus;
    }
    public int getCodigo(){
        return codigo; 
    }
    public void setCodigo(){
        this.codigo = codigo;
    }
    public int getCodigoBarras(){
        return codigoBarras; 
    }
    public void setCodigoBarras(){
        this.codigoBarras = codigoBarras;
    }
    public String getReferencia(){
        return referencia; 
    }
    public void setReferencia(){
        this.referencia = referencia;
    }
    public String getDepartamento(){
        return departamento; 
    }
    public void setDepartamento(){
        this.departamento = departamento;
    }
    public String getNomeProduto(){
        return nomeProduto; 
    }
    public void setNomeProduto(){
        this.nomeProduto = nomeProduto;
    }
    public String getNomeAbreviado(){
        return nomeAbreviado; 
    }
    public void setNomeAbreviado(){
        this.nomeAbreviado = nomeAbreviado;
    }
    public double getPreco(){
        return preco; 
    }
    public void setPreco(){
        this.preco = preco;
    }
    public double getCusto(){
        return custo; 
    }
    public void setCusto(){
        this.custo = custo;
    }
    public double getMargem(){
        return margem; 
    }
    public void setMargem(){
        this.margem = margem;
    }
}
