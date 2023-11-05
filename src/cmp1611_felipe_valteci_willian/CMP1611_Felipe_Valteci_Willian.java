/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cmp1611_felipe_valteci_willian;

import InterfaceGrafica.main;
import bancoDeDados.BancoDeDados;

/**
 *
 * @author junio
 */
public class CMP1611_Felipe_Valteci_Willian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "postgres";
        String senha = "1Z2ht6b.";
        String nomedb = "CMP1611_Felipe_Valteci_Willian";
        
        BancoDeDados banco = BancoDeDados.getInstance(usuario, senha, nomedb);
        
        main.main(null);
    }
    
}
