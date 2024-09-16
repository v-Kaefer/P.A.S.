package com.grupo5.biblioteca.repo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.grupo5.biblioteca.model.Livro;


@Repository // Anotação para indicar que a classe é um repositório e que deve ser gerenciada pelo Spring
public class AcervoMemoriaImpl implements AcervoRepository {
    private List<Livro> livros;

    public AcervoMemoriaImpl() {
        livros = new LinkedList<>();

        livros.add(new Livro(10, "Introdução ao Java", "Huguinho Pato", 2022));
        livros.add(new Livro(20, "Introdução ao Spring-Boot", "Zezinho Pato", 2020));
        livros.add(new Livro(15, "Principios SOLID", "Luizinho Pato", 2023));
        livros.add(new Livro(17, "Padroes de Projeto", "Lala Pato", 2019));
    }

    @Override
    public List<Livro> getAll() {
        return livros;
    }

    @Override
    public List<Integer> getIDs() {
    return livros.stream()
                .map(livro -> (int) livro.getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTitulos() {
    return getAll()
            .stream()
            .map(livro -> livro.getTitulo())
            .toList();
    }

    @Override
    public List<String> getAutores() {
        return getAll()
                .stream()
                .map(livro -> livro.getAutor())
                .toList();
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return getAll()
                .stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .toList();
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return getAll()
                .stream()
                .filter(livro -> livro.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        int livroId = livro.getId();
        // Check if the livro ID is already in use
        for (Livro existingLivro : livros) {
            if (existingLivro.getId() == livroId) {
                // Handle the case where the ID is already in use
                // You can throw an exception, log a message, or handle it based on your requirements
                return false;
            }
        }
        livros.add(livro);
        return true;
    }

    @Override
    public boolean removeLivro(long codigo) {
        List<Livro> tmp = livros.stream()
                .filter(livro -> livro.getId() == codigo)
                .toList();
        return tmp.removeAll(tmp);
    }
}
