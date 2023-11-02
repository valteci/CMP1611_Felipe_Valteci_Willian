/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoDeDados;

import funcionarios.Cozinheiro;
import funcionarios.Degustador;
import funcionarios.Editor;
import funcionarios.Funcionario;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

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



