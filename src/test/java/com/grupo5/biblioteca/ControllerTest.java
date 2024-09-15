package com.grupo5.biblioteca;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {

    private Controller controller;

    @Mock
    private IAcervoRepository livrosMock;

    @BeforeEach
    public void setup() {
        livrosMock = mock(IAcervoRepository.class);
        controller = new Controller(livrosMock);
    }

    @Test
    public void testMensagemDeBemVindo() {
        String expectedMessage = "Bem vindo a biblioteca central!";
        String actualMessage = controller.mensagemDeBemVindo();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetListaLivros() {
        List<Livro> expectedLivros = Arrays.asList(new Livro(0, "Livro1", null, 0), new Livro(0, "Livro2", null, 0));
        when(livrosMock.getAll()).thenReturn(expectedLivros);

        List<Livro> actualLivros = controller.getListaLivros();
        assertEquals(expectedLivros, actualLivros);
    }

    @Test
    public void testGetListaAutores() {
        List<String> expectedAutores = Arrays.asList("Autor1", "Autor2");
        when(livrosMock.getAutores()).thenReturn(expectedAutores);

        List<String> actualAutores = controller.getListaAutores();
        assertEquals(expectedAutores, actualAutores);
    }

    @Test
    public void testGetLivrosDoAutor() {
        List<Livro> expectedLivros = Arrays.asList(new Livro(0, "Livro1", null, 0), new Livro(0, "Livro2", null, 0));
        String autor = "Autor1";
        when(livrosMock.getLivrosDoAutor(autor)).thenReturn(expectedLivros);

        List<Livro> actualLivros = controller.getLivrosDoAutor(autor);
        assertEquals(expectedLivros, actualLivros);
    }

    @Test
    public void testGetLivrosDoAutorAndAno() {
        List<Livro> expectedLivros = Arrays.asList(new Livro(0, "Livro1", "Autor1", 2022));
        String autor = "Autor1";
        int ano = 2022;
        when(livrosMock.getLivrosDoAutor(autor)).thenReturn(expectedLivros);
    
        List<Livro> actualLivros = controller.getLivrosDoAutor(autor, ano);
        assertEquals(expectedLivros, actualLivros);
    }

    @Test
    public void testCadastraLivroNovo() {
        Livro novoLivro = new Livro(0, "Livro3", null, 0);
        when(livrosMock.cadastraLivroNovo(novoLivro)).thenReturn(true);

        boolean result = controller.cadastraLivroNovo(novoLivro);
        assertEquals(true, result);
    }
}