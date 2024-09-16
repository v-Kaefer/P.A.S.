package com.grupo5.biblioteca.repo;

import java.util.LinkedList;

import org.springframework.stereotype.Repository;

import com.grupo5.biblioteca.model.Livro;

@Repository // Anotação para indicar que a classe é um repositório e que deve ser gerenciada pelo Spring
public class BibliotecaRepo {

    public void saveLivro (Livro Livro) {
        System.out.println("Livro salvo no banco de dados - Teste");
    }

    public static LinkedList<Livro> getLivros() { // Implementar func para ler a LinkedList do App e retornar
        LinkedList<Livro> livros = new LinkedList<>();
        livros.add(new Livro(1, "Livro 1", "Autor 1", 2021));
        livros.add(new Livro(2, "Livro 2", "Autor 2", 2022));
        livros.add(new Livro(3, "Livro 3", "Autor 3", 2023));
        return livros;
    }

    public static Livro getLivroById(int id) {
        LinkedList<Livro> livros = getLivros();
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null; // Return null if the Livro with the specified ID is not found
    }
    
}
