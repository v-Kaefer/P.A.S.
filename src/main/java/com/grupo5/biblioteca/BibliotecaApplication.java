package com.grupo5.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.grupo5.biblioteca.model.Livro;
import com.grupo5.biblioteca.repo.AcervoMemoriaImpl;

@SpringBootApplication
public class BibliotecaApplication {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BibliotecaApplication.class, args);

		Livro novoLivroTeste = new Livro(30, "Livro Teste", "Autor Teste", 2024); // Criando um novo livro

		AcervoMemoriaImpl repo = context.getBean(AcervoMemoriaImpl.class); // Obtendo o bean do repositório
		repo.cadastraLivroNovo(novoLivroTeste); // Salvando um livro no banco de dados

		System.out.println(repo.getAll()); // Listando todos os livros do banco de dados
	}

}

