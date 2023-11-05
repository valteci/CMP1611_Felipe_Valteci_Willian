/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cmp1611_felipe_valteci_willian;

import InterfaceGrafica.main;
import bancoDeDados.BancoDeDados;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author junio
 */
public class CMP1611_Felipe_Valteci_Willian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StringBuilder senha = new StringBuilder();
        String senhaPostgres = "";
        String caminho = "./senha_postgres.txt";
        
        if (System.getProperty("user.dir").contains("dist"))
            caminho = "../senha_postgres.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = "";
            while ((linha = br.readLine()) != null) {
                senha.append(linha);
                // Se o arquivo contiver múltiplas linhas e você quer apenas a primeira, descomente a linha abaixo
                // break;
            }
            
            senhaPostgres = senha.toString();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();                                    
        }                                    
        
        String usuario = "postgres";
        String nomedb = "CMP1611_Felipe_Valteci_Willian";
        BancoDeDados banco = BancoDeDados.getInstance(usuario, senhaPostgres, nomedb);
        
        main.main(null);
    }
    
}







