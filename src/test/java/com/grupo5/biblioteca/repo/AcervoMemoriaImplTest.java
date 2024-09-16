package com.grupo5.biblioteca.repo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grupo5.biblioteca.model.Livro;


public class AcervoMemoriaImplTest {

    private AcervoMemoriaImpl acervo;

    @BeforeEach
    public void setUp() {
        acervo = new AcervoMemoriaImpl();
    }

    @Test
    public void testGetAll() {
        List<Livro> livros = acervo.getAll();
        assertEquals(4, livros.size());
    }

    @Test
    public void testGetIDs() {
        List<Integer> ids = acervo.getIDs();
        assertEquals(4, ids.size());
        assertTrue(ids.contains(10));
        assertTrue(ids.contains(20));
        assertTrue(ids.contains(15));
        assertTrue(ids.contains(17));
    }

    @Test
    public void testGetTitulos() {
        List<String> titulos = acervo.getTitulos();
        assertEquals(4, titulos.size());
        assertTrue(titulos.contains("Introdução ao Java"));
        assertTrue(titulos.contains("Introdução ao Spring-Boot"));
        assertTrue(titulos.contains("Principios SOLID"));
        assertTrue(titulos.contains("Padroes de Projeto"));
    }

    @Test
    public void testGetAutores() {
        List<String> autores = acervo.getAutores();
        assertEquals(4, autores.size());
        assertTrue(autores.contains("Huguinho Pato"));
        assertTrue(autores.contains("Zezinho Pato"));
        assertTrue(autores.contains("Luizinho Pato"));
        assertTrue(autores.contains("Lala Pato"));
    }

    @Test
    public void testGetLivrosDoAutor() {
        List<Livro> livros = acervo.getLivrosDoAutor("Huguinho Pato");
        assertEquals(1, livros.size());
        assertEquals("Introdução ao Java", livros.get(0).getTitulo());
    }

    @Test
    public void testGetLivroTitulo() {
        Livro livro = acervo.getLivroTitulo("Introdução ao Java");
        assertNotNull(livro);
        assertEquals("Huguinho Pato", livro.getAutor());
    }

    @Test
    public void testCadastraLivroNovo() {
        Livro novoLivro = new Livro(30, "Novo Livro", "Novo Autor", 2023);
        boolean result = acervo.cadastraLivroNovo(novoLivro);
        assertTrue(result);
        assertEquals(5, acervo.getAll().size());
        System.out.println("Tamanho da lista: " + acervo.getAll().size());
        System.out.println("Todos os Livros: " + acervo.getAll());
        System.out.println("ID do novo livro: " + novoLivro.getId());
    }

    public void testGetMoreIDs() {
        Livro novoLivro = new Livro(30, "Novo Livro", "Novo Autor", 2023);
        boolean result = acervo.cadastraLivroNovo(novoLivro);
        assertTrue(result);
        List<Integer> ids = acervo.getIDs();
        assertEquals(5, ids.size());
        assertTrue(ids.contains(10));
        assertTrue(ids.contains(20));
        assertTrue(ids.contains(15));
        assertTrue(ids.contains(17));
        assertTrue(ids.contains(30));
    }

    public void testRemoveLivro() {
        boolean result = acervo.removeLivro(10);
        assertTrue(result);
        assertEquals(3, acervo.getAll().size());
        List<Integer> ids = acervo.getIDs();
        assertEquals(3, ids.size());
        assertTrue(ids.contains(20));
        assertTrue(ids.contains(15));
        assertTrue(ids.contains(17));
    }

    public void testRemoveLivroInexistente() {
        boolean result = acervo.removeLivro(100);
        assertTrue(result);
        assertEquals(4, acervo.getAll().size());
        List<Integer> ids = acervo.getIDs();
        assertEquals(4, ids.size());
        assertTrue(ids.contains(10));
        assertTrue(ids.contains(20));
        assertTrue(ids.contains(15));
        assertTrue(ids.contains(17));
    }

    public void testRemoveMaisLivros() {
        Livro novoLivro = new Livro(30, "Novo Livro", "Novo Autor", 2023);
        boolean result = acervo.cadastraLivroNovo(novoLivro);
        assertTrue(result);

        List<Integer> ids = acervo.getIDs();
        assertEquals(5, ids.size());
        boolean result1 = acervo.removeLivro(10);
        assertTrue(result1);

        assertEquals(4, acervo.getAll().size());
        boolean result2 = acervo.removeLivro(15);
        assertTrue(result2);

        assertEquals(3, acervo.getAll().size());
        assertTrue(ids.contains(20));
        assertTrue(ids.contains(17));
        assertTrue(ids.contains(30));
        System.out.println("Teste Remover Livros");
    }
}
