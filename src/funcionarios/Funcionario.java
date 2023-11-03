/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionarios;

import java.util.Date;

/**
 *
 * @author junio
 */
public abstract class Funcionario {
    
    String nome = "";
    String cpf = "";
    Date dataIngresso = null;
    float salario = 0;
    
    public Funcionario() {
        
    }
    
    public Funcionario(
            String nome,
            String cpf,
            Date dataIngresso,
            float salario
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataIngresso = dataIngresso;
        this.salario = salario;
    }        
    
    public static boolean eCPFvalido(String cpf) {
        
        if (cpf.length() != 11) return false;
        if (!cpf.matches("\\d+")) return false;
        
        
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
}



