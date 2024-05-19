package programa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario{

	 private List<RegistroDeVendas> vendas;

	    public Vendedor(String nome, LocalDate dataContratacao) {
	        super(nome, "Vendedor", dataContratacao);
	        this.vendas = new ArrayList<>();
	    }

	    public void adicionarVenda(double valor, int mes, int ano) {
	        vendas.add(new RegistroDeVendas(valor, mes, ano));
	    }

	    public double calcularTotalVendas(int mes, int ano) {
	        double totalVendas = 0.0;
	        for (RegistroDeVendas venda : vendas) {
	            if (venda.mes == mes && venda.ano == ano) {
	                totalVendas += venda.valor;
	            }
	        }
	        return totalVendas;
	    }

	    @Override
	    double calcularSalario(int mes, int ano) {
	        return 12000.0;
	    }

	    @Override
	    double calcularBeneficio(int mes, int ano) {
	        int anosDeServico = ano - dataContratacao.getYear();
	        double totalVendas = calcularTotalVendas(mes, ano);
	        return 1800.0 * anosDeServico + 0.3 * totalVendas;
	    }
	}