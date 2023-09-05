package br.com.fiap.observer;

import br.com.fiap.models.Aluno;
import br.com.fiap.models.Biblioteca;
import br.com.fiap.models.Livro;

public interface LivroObserver {
	void loanBookObserver(Livro livro, Aluno aluno);
	
	void devolutionBookObserver(Livro livro, Aluno aluno, Biblioteca biblioteca);
}