package atividade1;
public class Indicador {
    private String pais;
    private Double taxa;
    
    public Indicador(){}
    
    public Indicador(String pais, Double taxa) {
        this.pais = pais;
        this.taxa = taxa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    
}
