/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancoDeDados;

import funcionarios.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public interface IBancoDeDados {
    public ArrayList<Funcionario> getFuncionarios() throws Exception;
    public Funcionario getFuncionarioCPF(String cpf) throws Exception;
    public void deletarFuncionario(String cpf) throws Exception;
}



