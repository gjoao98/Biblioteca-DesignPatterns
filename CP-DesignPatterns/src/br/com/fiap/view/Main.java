package br.com.fiap.view;

import br.com.fiap.models.Aluno;
import br.com.fiap.models.Biblioteca;
import br.com.fiap.models.Livro;
import br.com.fiap.observer.LivroAlerta;

public class Main {

	public static void main(String[] args) {
		Biblioteca bibli = Biblioteca.getInstance("Biblioteca do Parque Villa-Lobos");
		
		Aluno aluno1 = new Aluno(1, "Gabriel");
		Aluno aluno2 = new Aluno(1, "Felipe");
		
		Livro livr1 = new Livro(1, "Do mil ao milhão", "Thiago Nigro", 1, true);	
		Livro livr2 = new Livro(2, "Design Patterns", "Erich Gamma", 2, true);
		
		livr1.addObserver(new LivroAlerta());
		livr2.addObserver(new LivroAlerta());
		
		System.out.println("---------- Registro do livro! ----------");
		bibli.registerBook(livr1);
		bibli.registerBook(livr2);
		
		System.out.println("\n---------- Empréstimo do livro ----------");
		bibli.loanBook(livr1, aluno1);
		
		System.out.println("\n---------- Empréstimo do livro ----------");
		bibli.loanBook(livr1, aluno2);
		
		System.out.println("\n---------- Empréstimo do livro ----------");
		bibli.loanBook(livr2, aluno2);
		
		System.out.println("\n---------- Devolução do Livro ----------");
		bibli.devolutionBook(livr1, aluno1, bibli);
		
		System.out.println("\n---------- Devolução do Livro ----------");
		bibli.devolutionBook(livr2, aluno2, bibli);
		
		System.out.println("\n---------- Empréstimo do livro ----------");
		bibli.loanBook(livr2, aluno1);
		
		System.out.println("\n---------- Devolução do Livro ----------");
		bibli.devolutionBook(livr2, aluno1, bibli);
	}
}