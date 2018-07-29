package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;


public class CalculadoraSalario {
	
	/*
	 * Retornar o valor diretamente 
	 * 
	 * return numberteste != null && numberteste.compareTo(BigDecimal.ZERO) < 0 
	 * Existe um erro na lógica desse método. Ele deveria retornar false se o 
	 * numberteste igual a null && numberteste menor que zero. 
	 * Neste caso ele esta fazendo o contrário.
	 */
	public boolean testeEntrada(BigDecimal numberteste) {
		
		BigDecimal zero = new BigDecimal("0");
		if(numberteste == null)
			return true;
		else if( numberteste.compareTo(zero) == -1)
			 	return true;
		
		return false;
		
		}
		

	/*
	 * O método esta correto entrento não é necessário criar variáveis para armazenar 
	 * valores de retorno. Como mehoria tente realizar o retorno diretamente.
	 */
	public BigDecimal getSalarioLiquido(BigDecimal salarioBruto, BigDecimal percentualImpostoINSS) {
		
		// Verificar anotações no método testeEntrada
		if((testeEntrada(salarioBruto)) || (testeEntrada(percentualImpostoINSS)))
			throw new IllegalArgumentException();
	
		BigDecimal valor = (salarioBruto.multiply(percentualImpostoINSS)).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal salarioLiquido = salarioBruto.subtract(valor);
		
		// Poderia ser realizado dessa forma. Sendo assim as variaveis valor e salarioLiquido não seriam 
		// mais necessárias.
		// return salarioBruto.subtract(salarioBruto.multiply(percentualImpostoINSS).divide(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		return salarioLiquido;
	}
	
	/*
	 * Verifique o uso dos parênteses desnecessários
	 * Veja como fazer validação usando o else if()
	 * 
	 */
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

	/*
	 * O método esta funcionando corretamente porém esta
	 * muito complexo. Tente substituir o uso dos ifs encadeados
	 * 
	 */
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
