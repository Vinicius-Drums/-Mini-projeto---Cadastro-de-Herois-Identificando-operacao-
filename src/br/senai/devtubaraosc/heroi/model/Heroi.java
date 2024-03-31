//  Heroi.java
package br.senai.devtubaraosc.heroi.model;

// Classe que representa um herói
public class Heroi {
    private String nome;
    private String superpoder;
    private int idade;

    // Construtor da classe
    public Heroi(String nome, String superpoder, int idade) {
        this.nome = nome;
        this.superpoder = superpoder;
        this.idade = idade;
    }

    // Métodos Getters e Setters

    // Getter para o nome do herói
    public String getNome() {
        return nome;
    }

    // Setter para o nome do herói
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o superpoder do herói
    public String getSuperpoder() {
        return superpoder;
    }

    // Setter para o superpoder do herói
    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    // Getter para a idade do herói
    public int getIdade() {
        return idade;
    }

    // Setter para a idade do herói
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
