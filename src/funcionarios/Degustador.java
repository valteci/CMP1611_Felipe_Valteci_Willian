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
public class Degustador extends Funcionario {
    
    public Degustador() {
        super();
    }
    
    public Degustador(
            String nome,
            String cpf,
            Date dataIngresso,
            float salario
    ) {        
        super(nome, cpf, dataIngresso, salario);
    }
    
}
