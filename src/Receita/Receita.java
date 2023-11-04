/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Receita;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author junio
 */
public class Receita {
    
    int codigo = -1;
    String nomeReceita = "";
    Date diaCriacao = null;
    String nomeChef = "";
    String cpf_cozinheiro = "";
    int codigoCategoria = -1;
    
    public Receita() {
    }
    
    public Receita(
            int codigo,
            String nomeReceita,
            Date diaCriacao,
            String nomeChef,
            String cpf_cozinheiro,
            int codigoCategoria
    ) {
        
        this.codigo = codigo;
        this.nomeReceita = nomeReceita;
        this.diaCriacao = diaCriacao;
        this.nomeChef = nomeChef;
        this.cpf_cozinheiro = cpf_cozinheiro;
        this.codigoCategoria = codigoCategoria;
    }

    public String getStringDate() {
        
        Calendar  calendario = Calendar.getInstance();
        calendario.setTime(diaCriacao);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int ano = calendario.get(Calendar.YEAR);
        
        
        return ano + "-" + mes + "-" + dia;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public Date getDiaCriacao() {
        return diaCriacao;
    }

    public void setDiaCriacao(Date diaCriacao) {
        this.diaCriacao = diaCriacao;
    }

    public String getNomeChef() {
        return nomeChef;
    }

    public void setNomeChef(String nomeChef) {
        this.nomeChef = nomeChef;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getCpf_cozinheiro() {
        return cpf_cozinheiro;
    }

    public void setCpf_cozinheiro(String cpf_cozinheiro) {
        this.cpf_cozinheiro = cpf_cozinheiro;
    }
    
    
    
}

