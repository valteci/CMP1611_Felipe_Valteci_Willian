/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancoDeDados;

import Livros.Livro;
import categoria.Categoria;
import funcionarios.Funcionario;
import java.util.ArrayList;
import java.util.Date;
import funcionarios.Cargo;
import funcionarios.Cozinheiro;
import ingredientes.Ingrediente;
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
    public ArrayList<Cozinheiro> getCozinheirosRestaurante(int codigo) throws Exception;
    
    public ArrayList<Categoria> getCategorias() throws Exception;
    public Categoria getCategoriaCodigo(int codigo) throws Exception;
    public void inserirCategoria(String descricao) throws Exception;
    public void atualizarCategoria(int codigo, String novaDescricao) throws Exception;
    public void deletarCategoria(int codigo) throws Exception;
    
    
    public void inserirLivro(String ISBN, String titulo, String cpfEditor) throws Exception;
    public ArrayList<Livro> getLivros() throws Exception;
    public Livro getLivroISBN(String ISBN) throws Exception;
    public void deletarLivro(String ISBN) throws Exception;
    public void atualizarLivro(Livro livro, String ISBNoriginal) throws Exception;
    
    public ArrayList<Ingrediente> getIngredientes() throws Exception;
    
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



