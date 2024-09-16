package com.grupo5.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.grupo5.biblioteca.repo.BibliotecaRepo;

@SpringBootApplication
public class BibliotecaApplication {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BibliotecaApplication.class, args);

		BibliotecaRepo repo = context.getBean(BibliotecaRepo.class); // Obtendo o bean do repositório
		repo.saveLivro(BibliotecaRepo.getLivroById(1)); // Salvando um livro no banco de dados

		System.out.println(repo.getLivros()); // Listando todos os livros do banco de dados
	}

}

