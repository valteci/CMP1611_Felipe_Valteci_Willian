/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancoDeDados;

import Livros.Livro;
import Receita.IngredienteReceita;
import Receita.Receita;
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
    
    //CRUD FUNCIONARIO
    public ArrayList<Funcionario> getFuncionarios() throws Exception;
    public Funcionario getFuncionarioCPF(String cpf) throws Exception;
    public void deletarFuncionario(String cpf) throws Exception;
    public ArrayList<Restaurante> getRestaurantes() throws Exception;
    
    //CRUD RESTAURANTE
    public Restaurante getRestauranteCodigo(int codigo) throws Exception;
    public void inserirRestaurante(String nome) throws Exception;
    public void deletarRestaurante(int codigo) throws Exception;
    public void atualizarRestaurante(int codigo, String novoNome) throws Exception;
    public ArrayList<Cozinheiro> getCozinheirosRestaurante(int codigo) throws Exception;
    
    //CRUD CATEGORIA
    public ArrayList<Categoria> getCategorias() throws Exception;
    public Categoria getCategoriaCodigo(int codigo) throws Exception;
    public void inserirCategoria(String descricao) throws Exception;
    public void atualizarCategoria(int codigo, String novaDescricao) throws Exception;
    public void deletarCategoria(int codigo) throws Exception;
    
    //CRUD LIVRO
    public void inserirLivro(String ISBN, String titulo, String cpfEditor) throws Exception;
    public ArrayList<Livro> getLivros() throws Exception;
    public Livro getLivroISBN(String ISBN) throws Exception;
    public void deletarLivro(String ISBN) throws Exception;
    public void atualizarLivro(Livro livro, String ISBNoriginal) throws Exception;
    
    //CRUD INGREDIENTE
    public ArrayList<Ingrediente> getIngredientes() throws Exception;
    public Ingrediente getIngredienteCodigo(int codigo) throws Exception;
    public void inserirIngrediente(String nome) throws Exception;
    public void deletarIngrediente(int codigo) throws Exception;
    public void atualizarIngrediente(int codigo, String novoNome) throws Exception;
    
    //CRUD RECEITAS
    public ArrayList<Receita> getReceitas() throws Exception;
    public Receita getReceitaCodigo(int codigo) throws Exception;
    public void inserirReceita(Receita receita, ArrayList<IngredienteReceita> ingredientes) throws Exception;
    public ArrayList<ArrayList<Object>> getIngredientesReceita(int codigoReceita) throws Exception;
    public void deletarReceita(int codigo) throws Exception;
    public void inserirDegustacoes(ArrayList<ArrayList<Object>> degustacoes, int codigoReceita) throws Exception;
    
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



