package programa;

import java.time.LocalDate;

public class Gerente extends Funcionario {

	public Gerente(String nome, LocalDate dataContratacao) {
        super(nome, "Gerente", dataContratacao);
    }

    @Override
    double calcularSalario(int mes, int ano) {
        return 20000.0;
    }

    @Override
    double calcularBeneficio(int mes, int ano) {
        return 0.0;
    }
}