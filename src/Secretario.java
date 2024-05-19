package programa;

import java.time.LocalDate;

public class Secretario extends Funcionario{

	public Secretario(String nome, LocalDate dataContratacao) {
        super(nome, "Secretário", dataContratacao);
    }

    @Override
    double calcularSalario(int mes, int ano) {
        return 7000.0;
    }

    @Override
    double calcularBeneficio(int mes, int ano) {
        int anosDeServico = ano - dataContratacao.getYear();
        return 1000.0 * anosDeServico + 0.2 * calcularSalario(mes, ano);
    }
}