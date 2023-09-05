package br.com.fiap.models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private String nome;

	private List<Livro> livros = new ArrayList<Livro>();

	private static Biblioteca bibUnica;

	private Biblioteca(String nome) {
		this.nome = nome;
	}

	public static Biblioteca getInstance(String nome) {
		if (bibUnica == null) {
			bibUnica = new Biblioteca(nome);
		}
		return bibUnica;
	}

	public void registerBook(Livro livro) {
		livros.add(livro);
		System.out.println("O livro %s foi registrado na %s"
				.formatted(livro.getTitulo(), this.getNome()));
	}

	public void loanBook(Livro livro, Aluno aluno) {
		if (livro.getId() <= 0 && !livro.isStatus()) {
			System.out.println("Não temos esse livro disponível no momento!");
		} else {
			livro.loanBookAlert(livro, aluno);
			livro.setQuantidade(livro.getQuantidade() - 1);
			livro.setIdAluno(aluno.getId());
			livro.setStatus(false);
		}
	}

	public void devolutionBook(Livro livro, Aluno aluno, Biblioteca biblioteca) {
		livro.devolutionBookAlert(livro, aluno, biblioteca);
		livro.setQuantidade(livro.getQuantidade() + 1);
		livro.setIdAluno(0);
		livro.setStatus(true);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
