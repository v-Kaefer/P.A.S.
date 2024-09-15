package com.grupo5.biblioteca;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    private IAcervoRepository livros;

    @Autowired
    public Controller(IAcervoRepository livros) {
        this.livros = livros; 
    }

    @GetMapping("")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("livros")
    public List<Livro> getListaLivros() {
        return livros.getAll();
    }

    @GetMapping("autores")
    public List<String> getListaAutores() {
        return livros.getAutores();
    }

    @GetMapping("livrosAutor")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return livros.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrosautor/{autor}/ano/{ano}")
    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return livros.getLivrosDoAutor(autor)
                .stream()
                .filter(l->l.getAno() == ano)
                .toList();
    }

    @PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return livros.cadastraLivroNovo(livro);
    }
}