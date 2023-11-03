/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Livros;

/**
 *
 * @author junio
 */
public class Livro {
  
    String ISBN = "";
    String titulo = "";
    String cpfEditor = "";
    
    
    public Livro() {
    }
    
    public Livro(String ISBN, String titulo, String cpfEditor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.cpfEditor = cpfEditor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCpfEditor() {
        return cpfEditor;
    }

    public void setCpfEditor(String cpfEditor) {
        this.cpfEditor = cpfEditor;
    }
    
    
    
}
