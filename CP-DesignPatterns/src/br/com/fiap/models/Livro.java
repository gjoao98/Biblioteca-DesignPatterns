package br.com.fiap.models;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.observer.LivroObserver;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private long ISBN;
	private int quantidade;
	private boolean status;
	private int idAluno;
	
	private List<LivroObserver> observers = new ArrayList<LivroObserver>();
	
	public Livro(int id, String titulo, String autor, int quantidade, boolean status) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.quantidade = quantidade;
		this.status = status;
	}
	
	public void addObserver(LivroObserver obs) {
		this.observers.add(obs);
	}
	
	public void removeObserver(LivroObserver obs) {
		this.observers.remove(obs);
	}
	
	public void loanBookAlert(Livro livro, Aluno aluno) {
		for (LivroObserver liObs : observers) {
			liObs.loanBookObserver(livro, aluno);
		}
	}
	
	public void devolutionBookAlert(Livro livro, Aluno aluno, Biblioteca biblioteca) {
		for (LivroObserver liObs : observers) {
			liObs.devolutionBookObserver(livro, aluno, biblioteca);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
}
