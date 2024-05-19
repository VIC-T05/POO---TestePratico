package programa;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		intanciarFuncionariosEexecutarMetodos();

	}

	public static void intanciarFuncionariosEexecutarMetodos() {
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(new Secretario("Jorge Carvalho", LocalDate.of(2018, Month.JANUARY, 1)));
		funcionarios.add(new Secretario("Maria Souza", LocalDate.of(2015, Month.DECEMBER, 1)));

		Vendedor ana = new Vendedor("Ana Silva", LocalDate.of(2021, Month.DECEMBER, 1));
		ana.adicionarVenda(5200.0, 12, 2021);
		ana.adicionarVenda(4000.0, 1, 2022);
		ana.adicionarVenda(4200.0, 2, 2022);
		ana.adicionarVenda(5850.0, 3, 2022);
		ana.adicionarVenda(7000.0, 4, 2022);
		funcionarios.add(ana);

		Vendedor joao = new Vendedor("João Mendes", LocalDate.of(2021, Month.DECEMBER, 1));
		joao.adicionarVenda(3400.0, 12, 2021);
		joao.adicionarVenda(7700.0, 1, 2022);
		joao.adicionarVenda(5000.0, 2, 2022);
		joao.adicionarVenda(5900.0, 3, 2022);
		joao.adicionarVenda(6500.0, 4, 2022);
		funcionarios.add(joao);

		funcionarios.add(new Gerente("Juliana Alves", LocalDate.of(2017, Month.JULY, 1)));
		funcionarios.add(new Gerente("Bento Albino", LocalDate.of(2014, Month.MARCH, 1)));

		Gestao empresa = new Gestao(funcionarios);

		int mes = 2;
		int ano = 2022;
		String nomeFuncionario = "João Mendes";

		double totalPagoNoMes = empresa.calcularTotalPagoNoMes(nomeFuncionario, mes, ano);
		if (totalPagoNoMes > 0.0) {
			System.out.println("Total pago a " + nomeFuncionario + " em abril de 2022: R$ " + totalPagoNoMes);
		} else {
			System.out.println("Funcionário não encontrado.");
		}

		double salarioDoFuncionarioNoMes = empresa.calcularSalarioDoFuncionarioNoMes(nomeFuncionario, mes, ano);
		if (salarioDoFuncionarioNoMes > 0.0) {
			System.out.println(
					"Salário pago a " + nomeFuncionario + " em abril de 2022: R$ " + salarioDoFuncionarioNoMes);
		} else {
			System.out.println("Funcionário não encontrado.");
		}

		double beneficiosDoFuncionarioNoMes = empresa.calcularBeneficiosDoFuncionarioNoMes(nomeFuncionario, mes, ano);
		if (beneficiosDoFuncionarioNoMes > 0.0) {
			System.out.println(
					"Benefícios pagos a " + nomeFuncionario + " em abril de 2022: R$ " + beneficiosDoFuncionarioNoMes);
		} else {
			System.out.println("Funcionário não encontrado ou não recebe benefícios.");
		}

		Funcionario maiorRendimento = empresa.obterFuncionarioComMaiorRendimento(mes, ano);
		System.out.println("Funcionário com maior rendimento em " + mes + " de " + ano + ": "
				+ (maiorRendimento != null ? maiorRendimento.nome : "N/A"));

		Funcionario maiorBeneficio = empresa.obterFuncionarioComMaiorBeneficio(mes, ano);
		System.out.println("Funcionário com maior benefício em " + mes + " de " + ano + ": "
				+ (maiorBeneficio != null ? maiorBeneficio.nome : "N/A"));

		Vendedor maiorVendedor = empresa.obterVendedorComMaiorVenda(mes, ano);
		System.out.println("Vendedor com maior venda em " + mes + " de " + ano + ": "
				+ (maiorVendedor != null ? maiorVendedor.nome : "N/A"));
	}

}
