package programa;

import java.time.LocalDate;

abstract class Funcionario {
	String nome;
	String cargo;
	LocalDate dataContratacao;

	public Funcionario(String nome, String cargo, LocalDate dataContratacao) {
		this.nome = nome;
		this.cargo = cargo;
		this.dataContratacao = dataContratacao;
	}

	abstract double calcularSalario(int mes, int ano);

	abstract double calcularBeneficio(int mes, int ano);
}
