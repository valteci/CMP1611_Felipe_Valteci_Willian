/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ingredientes;

/**
 *
 * @author junio
 */
public class Ingrediente {
   int codigo = -1;
   String nome = "";
   
   public Ingrediente() {
   }
   
   public Ingrediente(int codigo, String nome) {
       
       this.codigo = codigo;
       this.nome = nome;
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
   
}
