package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;


public class CalculadoraSalario {
	
	public boolean testeEntrada(BigDecimal numberteste) {
		
		BigDecimal zero = new BigDecimal("0");
		if(numberteste == null)
			return true;
		else if( numberteste.compareTo(zero) == -1)
			 	return true;
		
		return false;
		
		}
		

	public BigDecimal getSalarioLiquido(BigDecimal salarioBruto, BigDecimal percentualImpostoINSS) {
		
		if((testeEntrada(salarioBruto)) || (testeEntrada(percentualImpostoINSS)))
			throw new IllegalArgumentException();
	
		BigDecimal valor = (salarioBruto.multiply(percentualImpostoINSS)).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal salarioLiquido = salarioBruto.subtract(valor);
		
		return salarioLiquido;
	}
	
	public BigDecimal getValorINSS(BigDecimal salarioBruto) {

		if(testeEntrada(salarioBruto))
			throw new IllegalArgumentException();
		
		BigDecimal primeiraFaixa = new BigDecimal(1693.72);
		BigDecimal segundaFaixa = new BigDecimal(2822.90);
		
		if ((salarioBruto.compareTo(primeiraFaixa)) == -1)
			return (salarioBruto.multiply(new BigDecimal("8"))).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
		else
			if((((salarioBruto.compareTo(primeiraFaixa)) == 1) && ((salarioBruto.compareTo(segundaFaixa)) == -1)) || ((salarioBruto.compareTo(segundaFaixa)) == 0))
				 return (salarioBruto.multiply(new BigDecimal("9"))).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
			else
				return (salarioBruto.multiply(new BigDecimal("11"))).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getValorPlanoDeSaude(Integer idade) {
		String  valorEmStringsDoDesconto;
		
		if(testeEntrada(new BigDecimal(idade) ))
			throw new IllegalArgumentException();
		
		if(idade>=0 && idade<=9) {
			valorEmStringsDoDesconto = "75";	
		}else
			if(idade>=10&&idade<=19) {
				valorEmStringsDoDesconto = "112.50";
			}else
				if(idade>=20 && idade<=29) {
					valorEmStringsDoDesconto = "168.75";
				}else
					if (idade>=30 && idade<=39) {
						valorEmStringsDoDesconto = "253.13";
					}else
						if(idade>=40 && idade<=49) {
							valorEmStringsDoDesconto = "379.69";
						}else
							if(idade >= 50 && idade <=59 ) {
								valorEmStringsDoDesconto = "569.54";
							}else {
								valorEmStringsDoDesconto = "854.30";
							}
	
		BigDecimal ValorDoPlanoDeSaude = new BigDecimal(valorEmStringsDoDesconto).setScale(2);
		return ValorDoPlanoDeSaude;
	}




}
