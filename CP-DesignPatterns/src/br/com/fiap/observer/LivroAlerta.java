package br.com.fiap.observer;

import br.com.fiap.models.Aluno;
import br.com.fiap.models.Biblioteca;
import br.com.fiap.models.Livro;

public class LivroAlerta implements LivroObserver {

	@Override
	public void loanBookObserver(Livro livro, Aluno aluno) {
		if (livro.getQuantidade() < 2 && livro.isStatus()) {
			System.out.println("O aluno %s pegou o livro '%s' emprestado!"
					.formatted(aluno.getNome(), livro.getTitulo())
					+ " \nEste livro era o último disponível e não estará disponível \nAté que o %s faça a devoulução do mesmo."
					.formatted(aluno.getNome()));

		} else if (livro.getQuantidade() >= 2 && livro.isStatus()) {
			System.out.println("O aluno %s pegou o livro '%s' emprestado!"
					.formatted(aluno.getNome(), livro.getTitulo()));
		} else {
			System.out.println("O livro %s não está disponível no momento!"
					.formatted(livro.getTitulo()));
		}
	}

	@Override
	public void devolutionBookObserver(Livro livro, Aluno aluno, Biblioteca biblioteca) {
		System.out.println("O aluno %s realizou a devolução do livro %s. "
				.formatted(aluno.getNome(), livro.getTitulo())
				+ "\nAgora este livro estará disponível para outro aluno poder pegar emprestado!"
				+ "\nA %s agradece!"
				.formatted(biblioteca.getNome()));
	}
}
