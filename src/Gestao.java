package programa;

import java.util.List;

public class Gestao {
	List<Funcionario> funcionarios;

	public Gestao(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public double calcularTotalPagoNoMes(String nomeFuncionario, int mes, int ano) {
		double totalPago = 0.0;
		for (Funcionario func : funcionarios) {
			if (func.nome.equalsIgnoreCase(nomeFuncionario)) {
				totalPago = func.calcularSalario(mes, ano) + func.calcularBeneficio(mes, ano);
				break;
			}
		}
		return totalPago;
	}

	public double calcularSalarioDoFuncionarioNoMes(String nomeFuncionario, int mes, int ano) {
        double salario = 0.0;
        for (Funcionario func : funcionarios) {
            if (func.nome.equalsIgnoreCase(nomeFuncionario)) {
                salario = func.calcularSalario(mes, ano);
                break;
            }
        }
        return salario;
    }

	public double calcularBeneficiosDoFuncionarioNoMes(String nomeFuncionario, int mes, int ano) {
        double beneficios = 0.0;
        for (Funcionario func : funcionarios) {
            if (func.nome.equalsIgnoreCase(nomeFuncionario)) {
                beneficios = func.calcularBeneficio(mes, ano);
                break;
            }
        }
        return beneficios;
    }

	public Funcionario obterFuncionarioComMaiorRendimento(int mes, int ano) {
		Funcionario maiorRendimento = null;
		double maiorValor = 0.0;
		for (Funcionario func : funcionarios) {
			double valor = func.calcularSalario(mes, ano) + func.calcularBeneficio(mes, ano);
			if (maiorRendimento == null || valor > maiorValor) {
				maiorRendimento = func;
				maiorValor = valor;
			}
		}
		return maiorRendimento;
	}

	public Funcionario obterFuncionarioComMaiorBeneficio(int mes, int ano) {
		Funcionario maiorBeneficio = null;
		double maiorValor = 0.0;
		for (Funcionario func : funcionarios) {
			double valor = func.calcularBeneficio(mes, ano);
			if (valor > 0 && (maiorBeneficio == null || valor > maiorValor)) {
				maiorBeneficio = func;
				maiorValor = valor;
			}
		}
		return maiorBeneficio;
	}

	public Vendedor obterVendedorComMaiorVenda(int mes, int ano) {
		Vendedor maiorVendedor = null;
		double maiorVenda = 0.0;
		for (Funcionario func : funcionarios) {
			if (func instanceof Vendedor) {
				Vendedor vendedor = (Vendedor) func;
				double vendas = vendedor.calcularTotalVendas(mes, ano);
				if (maiorVendedor == null || vendas > maiorVenda) {
					maiorVendedor = vendedor;
					maiorVenda = vendas;
				}
			}
		}
		return maiorVendedor;
	}
}
