/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoDeDados;

import Livros.Livro;
import categoria.Categoria;
import funcionarios.Cargo;
import funcionarios.Cozinheiro;
import funcionarios.Degustador;
import funcionarios.Editor;
import funcionarios.Funcionario;
import ingredientes.Ingrediente;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import restaurantes.Restaurante;

/**
 *
 * @author junio
 */
public class BancoDeDados implements IBancoDeDados {

    private String usuario = "";
    private String senha = "";
    private String nomeDatabase = "";    

    private static BancoDeDados instancia = null;
    
    private BancoDeDados() {
        
    }
    
    private BancoDeDados(
            String usuario,
            String senha,
            String nomeDatabase
    ) {
        this.usuario = usuario;
        this.senha = senha;
        this.nomeDatabase = nomeDatabase;
        
    }
            
    public static BancoDeDados getInstance() {
        if (instancia == null)
            instancia = new BancoDeDados();
        
        return instancia;
    }
    
    public static BancoDeDados getInstance(
            String usuario,
            String senha,
            String nomeDatabase
    ) {
        if (instancia == null)
            instancia = new BancoDeDados(usuario, senha, nomeDatabase);
        
        return instancia;
    }
    
    
    @Override
    public ArrayList<Funcionario> getFuncionarios() throws Exception {
        ArrayList<Funcionario> resultado = new ArrayList<>();
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM cozinheiros"
        );
        
        
        
        while (resultadoConsulta.next()) {
            
            String cpf = resultadoConsulta.getString(
                    "cpf_coz"
            );
            
            String nome = resultadoConsulta.getString(
                    "nome_Coz"
            );
            
            Date data = resultadoConsulta.getDate(
                    "dt_contrato_coz"
            );
            
            float salario = resultadoConsulta.getFloat(
                    "Salario_Coz"
            );
            
            String nomeFantasia = resultadoConsulta.getString(
                    "nome_fantasia"
            );
            
            Funcionario funcionario = new Cozinheiro(
                    nome,
                    cpf,
                    data,
                    salario,
                    nomeFantasia
            );
            
            resultado.add(funcionario);
        }
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM degustadores"
        );
        
        while (resultadoConsulta.next()) {
            
            String cpf = resultadoConsulta.getString(
                    "cpf_deg"
            );
            
            String nome = resultadoConsulta.getString(
                    "nome_deg"
            );
            
            Date data = resultadoConsulta.getDate(
                    "dt_contrato_deg"
            );
            
            float salario = resultadoConsulta.getFloat(
                    "salario_deg"
            );            
            
            Funcionario funcionario = new Degustador(
                    nome,
                    cpf,
                    data,
                    salario
            );
            
            resultado.add(funcionario);            
        }
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM editores"
        );
        
        
        while (resultadoConsulta.next()) {
            
            String cpf = resultadoConsulta.getString(
                    "cpf_edit"
            );
            
            String nome = resultadoConsulta.getString(
                    "nome_edit"
            );
            
            Date data = resultadoConsulta.getDate(
                    "dt_contrato_edit"
            );
            
            float salario = resultadoConsulta.getFloat(
                    "salario_edit"
            );            
            
            Funcionario funcionario = new Editor(
                    nome,
                    cpf,
                    data,
                    salario
            );
            
            resultado.add(funcionario);            
        }
        
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
        
        
        return resultado;
    }

    
    @Override
    public Funcionario getFuncionarioCPF(String cpf) throws Exception {
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM Profissionais WHERE cpf_profissional = " +
                cpf
        );
        
        if (! resultadoConsulta.next())
            throw new Exception(
                    "Funcionário não existe ou cpf inválido"
            );
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM cozinheiros WHERE cpf_coz = " +
                cpf
        );
        
        if (resultadoConsulta.next()) {
            
            String nome = resultadoConsulta.getString("Nome_Coz");
            Date data = resultadoConsulta.getDate("Dt_Contrato_Coz");
            float salario = resultadoConsulta.getFloat("Salario_Coz");
            
            String nomeFantasia = resultadoConsulta.getString(
                    "Nome_Fantasia"
            );
            
            

            Funcionario funcionario = new Cozinheiro(
                    nome,
                    cpf,
                    data,
                    salario,
                    nomeFantasia
            );
            
            if (resultadoConsulta != null)
            resultadoConsulta.close();
        
            if (comando != null)
                comando.close();

            if (conexao != null)
                conexao.close();
        
            return funcionario;
        }
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM degustadores WHERE cpf_deg = " +
                cpf
        );
        
        if (resultadoConsulta.next()) {
            
            String nome = resultadoConsulta.getString("Nome_Deg");
            Date data = resultadoConsulta.getDate("Dt_Contrato_Deg");
            float salario = resultadoConsulta.getFloat("Salario_Deg");

            Funcionario funcionario = new Degustador(
                    nome,
                    cpf,
                    data,
                    salario                    
            );
            
            if (resultadoConsulta != null)
            resultadoConsulta.close();
        
            if (comando != null)
                comando.close();

            if (conexao != null)
                conexao.close();
        
            return funcionario;
        }
        
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM editores WHERE cpf_edit = " +
                cpf
        );
        
        if (! resultadoConsulta.next())
            throw new Exception(
                "Erro: falha na restrição de integridade" + 
                "do banco de dados"
        );
        
        String nome = resultadoConsulta.getString("Nome_Edit");
        Date data = resultadoConsulta.getDate("Dt_Contrato_Edit");
        float salario = resultadoConsulta.getFloat("Salario_Edit");
        
        Funcionario funcionario = new Editor(
                nome,
                cpf,
                data,
                salario
        );
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();

        if (comando != null)
            comando.close();

        if (conexao != null)
            conexao.close();
            
        return funcionario;
    }
    
    @Override
    public void deletarFuncionario(String cpf) throws Exception {
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        
        if (! comando.executeQuery(
                "SELECT * FROM profissionais WHERE Cpf_Profissional = " + 
                cpf).next()
        ) {
            throw new Exception(
                    "Funcionário não existe ou cpf inválido"
            );
        }
        
        comando.execute(
                "DELETE FROM profissionais WHERE Cpf_Profissional = " +
                cpf
        );
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public void inserirFuncionario(
            String cpf,
            String nome, 
            Date dataIngresso,
            float salario,
            String nomeFantasia,
            Cargo.tipo cargo            
    ) throws Exception {
        
        String posQuery = "";
        String preQuery = "INSERT INTO Profissionais (Cpf_Profissional)" +
                          "VALUES (" + cpf + ")";
        
        Calendar  calendario = Calendar.getInstance();
        calendario.setTime(dataIngresso);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int ano = calendario.get(Calendar.YEAR);                                
        
        String salarioFormatado = String.format(
                "%.2f",
                salario
                ).replace(
                        ',',
                        '.'
        );
        
        
        switch (cargo) {
            case COZINHEIRO:
                posQuery = """
                        INSERT INTO Cozinheiros 
                        (Nome_Coz, Nome_Fantasia, Dt_Contrato_Coz, Salario_Coz, 
                        Cpf_Coz) VALUES ('%s', '%s', '%d-%d-%d', %s, %s)
                        """.formatted(
                                nome,
                                nomeFantasia,
                                ano,
                                mes,
                                dia,
                                salarioFormatado,
                                cpf
                        );
                break;
                
            case DEGUSTADOR:
                posQuery = """
                        INSERT INTO degustadores 
                        (Nome_deg, Dt_Contrato_deg, Salario_deg, Cpf_deg) 
                        VALUES ('%s', '%d-%d-%d', %s, %s)
                        """.formatted(
                                nome,                                
                                ano,
                                mes,
                                dia,
                                salarioFormatado,
                                cpf
                        );
                
                break;
                
            case EDITOR:
                posQuery = """
                        INSERT INTO Editores 
                        (Nome_Edit, Dt_Contrato_Edit, Salario_Edit, Cpf_Edit) 
                        VALUES ('%s', '%d-%d-%d', %s, %s)
                        """.formatted(
                                nome,                                
                                ano,
                                mes,
                                dia,
                                salarioFormatado,
                                cpf
                        );
                
                break;
        }
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
                
        comando.execute(preQuery);
        comando.execute(posQuery);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    
    
    @Override
    public void atualizarFuncionario(
            Funcionario novo,
            String cpfOriginal
    ) throws Exception {
        
        String queryAlterarCpf = "";
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        
        if (! novo.getCpf().equals(cpfOriginal)) {
            queryAlterarCpf = """
                              UPDATE Profissionais SET Cpf_Profissional = %s 
                              WHERE Cpf_Profissional = %s                              
                              """.formatted(
                                      novo.getCpf(),
                                      cpfOriginal
                              );
            
            comando.execute(queryAlterarCpf);
        }
        
        
        
        String queryAlterarDados = "";
        
        Calendar  calendario = Calendar.getInstance();
        calendario.setTime(novo.getDataIngresso());
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int ano = calendario.get(Calendar.YEAR);                                
        
        String salarioFormatado = String.format(
                "%.2f",
                novo.getSalario()
                ).replace(
                        ',',
                        '.'
        );
        
        if (novo instanceof Cozinheiro cozinheiro) {
            
            queryAlterarDados = """
                    UPDATE cozinheiros SET 
                    Nome_Coz = '%s',
                    Nome_Fantasia = '%s',
                    Dt_Contrato_Coz = '%d-%d-%d',
                    Salario_Coz = %s
                    WHERE Cpf_Coz = %s
                    """.formatted(
                            novo.getNome(),
                            cozinheiro.getNomeFantasia(),
                            ano,
                            mes,
                            dia,
                            salarioFormatado,
                            novo.getCpf()
                    );
            
        }
        else if (novo instanceof Degustador) {
            
            queryAlterarDados = """
                    UPDATE degustadores SET 
                    Nome_deg = '%s',
                    Dt_Contrato_deg = '%d-%d-%d',
                    Salario_deg = %s
                    WHERE Cpf_deg = %s
                    """.formatted(
                            novo.getNome(),
                            ano,
                            mes,
                            dia,
                            salarioFormatado,
                            novo.getCpf()
                    );
        }
        else if (novo instanceof Editor) {
            
            queryAlterarDados = """
                    UPDATE editores SET 
                    Nome_Edit = '%s',
                    Dt_Contrato_Edit = '%d-%d-%d',
                    Salario_Edit = %s
                    WHERE Cpf_Edit = %s
                    """.formatted(
                            novo.getNome(),
                            ano,
                            mes,
                            dia,
                            salarioFormatado,
                            novo.getCpf()
                    );
        }
        
        System.out.println(queryAlterarDados);
        comando.execute(queryAlterarDados);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public ArrayList<Restaurante> getRestaurantes() throws Exception {
        
        ArrayList<Restaurante> resultado = new ArrayList<>();
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM Restaurantes"
        );
        
        
        
        while (resultadoConsulta.next()) {
            
            int codigo = resultadoConsulta.getInt(
                    "Cod_Restaurante"
            );
            
            String nome = resultadoConsulta.getString(
                    "Nome_Restaurante"
            );
            
            Restaurante restaurante = new Restaurante(
                    codigo,
                    nome
            );
            
            resultado.add(restaurante);
        }
        
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
        
        return resultado;
    }
    
    @Override
    public void inserirRestaurante(String nome) throws Exception {
        String url = getUrl();
        String query = "INSERT INTO Restaurantes (Nome_Restaurante) VALUES " +
                       "('"+ nome +"')";
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public void deletarRestaurante(int codigo) throws Exception {
        String url = getUrl();
        String query = "DELETE FROM Restaurantes WHERE Cod_Restaurante = " +
                codigo;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    
    @Override
    public Restaurante getRestauranteCodigo(int codigo) throws Exception {
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM Restaurantes WHERE cod_restaurante = " +
                codigo
        );
        
        if (! resultadoConsulta.next())
            throw new Exception(
                    "Restaurante não existe ou código inválido"
            );
                                
            
            String nome = resultadoConsulta.getString("Nome_Restaurante");
            Restaurante restaurante = new Restaurante(
                    codigo,
                    nome
            );
            
            if (resultadoConsulta != null)
                resultadoConsulta.close();
        
            if (comando != null)
                comando.close();

            if (conexao != null)
                conexao.close();
        
            return restaurante;
    }
    
    
    @Override
    public void atualizarRestaurante(int codigo, String novoNome
    ) throws Exception {
        
        String url = getUrl();
        String query = "UPDATE Restaurantes SET Nome_Restaurante = '"+
                       novoNome + "' WHERE Cod_Restaurante = " + codigo;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public ArrayList<Cozinheiro> getCozinheirosRestaurante(int codigo) throws Exception {
        
        ArrayList<Cozinheiro> resultado = new ArrayList<>();
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "select y.Cpf_Coz, y.Nome_Coz  from Curriculo x " +
                "INNER JOIN Cozinheiros y ON x.Cpf_Coz = y.Cpf_Coz" + 
                " WHERE Cod_Restaurante =" + codigo
        );
        
        
        
        while (resultadoConsulta.next()) {
            
            String cpf = resultadoConsulta.getString(
                    "Cpf_Coz"
            );
            
            String nome = resultadoConsulta.getString(
                    "Nome_Coz"
            );
            
            Cozinheiro cozinheiro = new Cozinheiro();
            cozinheiro.setNome(nome);
            cozinheiro.setCpf(cpf);
            
            resultado.add(cozinheiro);
        }
        
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
        
        return resultado;
    }
    
    
    @Override
    public ArrayList<Categoria> getCategorias() throws Exception {
        ArrayList<Categoria> resultado = new ArrayList<>();
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM Categoria_Receita "
        );
        
        
        
        while (resultadoConsulta.next()) {
            
            int codigo = resultadoConsulta.getInt(
                    "Cod_Cat_Rec"
            );
            
            String descricao = resultadoConsulta.getString(
                    "Desc_Cat_Rec"
            );
            
            Categoria categoria = new Categoria();
            categoria.setCodigo(codigo);
            categoria.setDescricao(descricao);
            
            resultado.add(categoria);
        }
        
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
        
        return resultado;
    }
    
    @Override
    public Categoria getCategoriaCodigo(int codigo) throws Exception {
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM CATEGORIA_RECEITA WHERE Cod_Cat_Rec = " +
                codigo
        );
        
        if (! resultadoConsulta.next())
            throw new Exception(
                    "Categoria não existe ou código inválido"
            );
                                
            
            String descricao = resultadoConsulta.getString("Desc_Cat_Rec");
            Categoria categoria = new Categoria(
                    codigo,
                    descricao
            );
            
            if (resultadoConsulta != null)
                resultadoConsulta.close();
        
            if (comando != null)
                comando.close();

            if (conexao != null)
                conexao.close();
        
            return categoria;
    }
    
    @Override
    public void inserirCategoria(String descricao) throws Exception {
        String url = getUrl();
        String query = "INSERT INTO Categoria_Receita (Desc_Cat_Rec) VALUES " +
                       "('"+ descricao +"')";
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    
    @Override
    public void atualizarCategoria(int codigo, String novaDescricao) throws Exception {
        String url = getUrl();
        String query = "UPDATE categoria_receita SET Desc_Cat_Rec = '" + 
                       novaDescricao + "' WHERE Cod_Cat_Rec = " + codigo;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public void deletarCategoria(int codigo) throws Exception {
        
        String url = getUrl();
        String query = "DELETE FROM categoria_receita WHERE Cod_Cat_Rec = " +
                codigo;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public void inserirLivro(String ISBN, String titulo, String cpfEditor
    ) throws Exception {
        
        String url = getUrl();
        String query = "INSERT INTO livros (ISBN, Titulo, Cpf_Edit) VALUES (" +
                       ISBN + ", '" + titulo +"', " + cpfEditor + ")";
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public ArrayList<Livro> getLivros() throws Exception {
        
        ArrayList<Livro> resultado = new ArrayList<>();
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM Livros"
        );
        
        
        
        while (resultadoConsulta.next()) {
            
            String ISBN = resultadoConsulta.getString(
                    "ISBN"
            );
            
            String titulo = resultadoConsulta.getString(
                    "Titulo"
            );
            
            String cpfEditor = resultadoConsulta.getString(
                    "Cpf_Edit"
            );
            
            
            Livro livro = new Livro(
                    ISBN,
                    titulo,
                    cpfEditor
            );
            
            resultado.add(livro);
        }
        
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
        
        return resultado;
        
    }
    
    
    @Override
    public Livro getLivroISBN(String ISBN) throws Exception {
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "select * from livros WHERE ISBN = " + ISBN
        );
        
        if (! resultadoConsulta.next())
            throw new Exception(
                    "ISBN não existe ou ISBN inválido"
            );
                                
            
            String titulo = resultadoConsulta.getString("Titulo");
            String cpfEditor = resultadoConsulta.getString("Cpf_Edit");
            
            Livro livro = new Livro(
                    ISBN,
                    titulo,
                    cpfEditor
            );
            
            if (resultadoConsulta != null)
                resultadoConsulta.close();
        
            if (comando != null)
                comando.close();

            if (conexao != null)
                conexao.close();
        
            return livro;
        
    }
    
    @Override
    public void deletarLivro(String ISBN) throws Exception {
        String url = getUrl();
        String query = "DELETE FROM livros WHERE ISBN = " + ISBN;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    
    @Override
    public void atualizarLivro(Livro livro, String ISBNoriginal) throws Exception {
        
        String url = getUrl();
        String query = "UPDATE livros SET ISBN = " + livro.getISBN() + ", " +
                       "Titulo = '" + livro.getTitulo() + "', Cpf_Edit = " +
                       livro.getCpfEditor() + " WHERE ISBN = " + ISBNoriginal;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    public ArrayList<Ingrediente> getIngredientes() throws Exception {
        
        ArrayList<Ingrediente> resultado = new ArrayList<>();
        
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "SELECT * FROM ingrediente"
        );
        
        
        
        while (resultadoConsulta.next()) {
            
            int codigo = resultadoConsulta.getInt(
                    "Cod_Ingrediente"
            );
            
            String nome = resultadoConsulta.getString(
                    "Nome_Ingrediente"
            );
            
            Ingrediente ingrediente = new Ingrediente(
                    codigo,
                    nome
            );
            
            resultado.add(ingrediente);
        }
        
        
        if (resultadoConsulta != null)
            resultadoConsulta.close();
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
        
        return resultado;
    }
    
    @Override
    public Ingrediente getIngredienteCodigo(int codigo) throws Exception {
        String url = getUrl();
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        ResultSet resultadoConsulta;
        
        resultadoConsulta = comando.executeQuery(
                "select * from ingrediente where cod_ingrediente = " +
                codigo
        );
        
        if (! resultadoConsulta.next())
            throw new Exception(
                    "Restaurante não existe ou código inválido"
            );
                                
            
            String nome = resultadoConsulta.getString("Nome_Ingrediente");
            Ingrediente ingrediente = new Ingrediente(
                    codigo,
                    nome
            );
            
            if (resultadoConsulta != null)
                resultadoConsulta.close();
        
            if (comando != null)
                comando.close();

            if (conexao != null)
                conexao.close();
        
            return ingrediente;
    }
    
    @Override
    public void inserirIngrediente(String nome) throws Exception {
        
        String url = getUrl();
        String query = "INSERT INTO ingrediente (Nome_Ingrediente) VALUES " +
                       "('"+ nome +"')";
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    @Override
    public void deletarIngrediente(int codigo) throws Exception {
        
        String url = getUrl();
        String query = "DELETE FROM ingrediente WHERE cod_ingrediente = " +
                codigo;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    
    @Override
    public void atualizarIngrediente(int codigo, String novoNome) throws Exception {
        
        String url = getUrl();
        String query = "UPDATE ingrediente SET nome_ingrediente = '"+
                       novoNome + "' WHERE cod_ingrediente = " + codigo;
        
        Connection conexao = DriverManager.getConnection(
                url,
                usuario,
                senha
        );
        
        Statement comando = conexao.createStatement();
        comando.execute(query);
        
        if (comando != null) {
            comando.close();
        }
    
        if (conexao != null) {
            conexao.close();
        }
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeDatabase() {
        return nomeDatabase;
    }

    public void setNomeDatabase(String nomeDatabase) {
        this.nomeDatabase = nomeDatabase;
    }
    
    public String getUrl() {
        return "jdbc:postgresql://localhost:5432/" + nomeDatabase;
    }
    
    
}



