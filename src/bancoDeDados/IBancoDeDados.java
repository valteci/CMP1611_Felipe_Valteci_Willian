/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancoDeDados;

import funcionarios.Funcionario;
import java.util.ArrayList;
import java.util.Date;
import funcionarios.Cargo;
import restaurantes.Restaurante;

/**
 *
 * @author junio
 */
public interface IBancoDeDados {
    public ArrayList<Funcionario> getFuncionarios() throws Exception;
    public Funcionario getFuncionarioCPF(String cpf) throws Exception;
    public void deletarFuncionario(String cpf) throws Exception;
    public ArrayList<Restaurante> getRestaurantes() throws Exception;
    public Restaurante getRestauranteCodigo(int codigo) throws Exception;
    public void inserirRestaurante(String nome) throws Exception;
    public void deletarRestaurante(int codigo) throws Exception;
    public void atualizarRestaurante(int codigo, String novoNome) throws Exception;
    
    public void inserirFuncionario(
            String cpf,
            String nome, 
            Date dataIngresso,
            float salario,
            String nomeFantasia,
            Cargo.tipo cargo
    ) throws Exception;
    
    public void atualizarFuncionario(
            Funcionario novo,
            String cpfOriginal
    ) throws Exception;
}



