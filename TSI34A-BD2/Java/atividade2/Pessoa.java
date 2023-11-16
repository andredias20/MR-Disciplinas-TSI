package Java.atividade2;

import java.util.Date;

public class Pessoa {
    private String nome;
    private Date dataNasc;
    private String CPF;
    
    public Pessoa(String nome, Date dataNasc, String CPF) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }    
}
