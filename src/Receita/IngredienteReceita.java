/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Receita;

/**
 *
 * @author junio
 */
public class IngredienteReceita {
    
    int codigoIngrediente = -1;
    int quantidade = -1;
    String medida = "";

    public IngredienteReceita() {
    }
    
    public IngredienteReceita(
            int codigoIngrediente, 
            int quantidade,
            String medida
    ) {
        this.codigoIngrediente = codigoIngrediente;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    public int getCodigoIngrediente() {
        return codigoIngrediente;
    }

    public void setCodigoIngrediente(int codigoIngrediente) {
        this.codigoIngrediente = codigoIngrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
    
    
}
