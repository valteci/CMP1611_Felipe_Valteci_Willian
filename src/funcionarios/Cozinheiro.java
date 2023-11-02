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
public class Cozinheiro extends Funcionario {
    
    String nomeFantasia = "";
    
    public Cozinheiro() {
        super();
    }
    
    public Cozinheiro(
            String nome,
            String cpf,
            Date dataIngresso,
            float salario
    ) {        
        super(nome, cpf, dataIngresso, salario);    
    }
    
    public Cozinheiro(
            String nome,
            String cpf,
            Date dataIngresso,
            float salario,
            String nomeFantasia
    ) {        
        super(nome, cpf, dataIngresso, salario);
        this.nomeFantasia = nomeFantasia;        
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    
    
}



