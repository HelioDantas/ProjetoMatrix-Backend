package br.com.cariocadev.ProjetoMatrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadoraSalarioTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	public Map<Integer, BigDecimal> rangePlanoSaude = new HashMap<Integer, BigDecimal>();

	@Before
	public void initRange() {
		Double preco = 75.00;
		for (int i = 0; i <= 60; i++) {
			preco = i == 0 || i % 10 != 0 ? preco : (preco + ((preco * 50.00) / 100));
			rangePlanoSaude.put(new Integer(i), new BigDecimal(preco).setScale(2, BigDecimal.ROUND_UP));
		}
	}

	@Test
	public void deveRetornarSalarioLiquido() {

		CalculadoraSalario calculadora = new CalculadoraSalario();
		assertNotNull("O método não deve retonar null",
				calculadora.getSalarioLiquido(new BigDecimal(1000.00), new BigDecimal(8.0)));
		assertEquals(new BigDecimal(920.00).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getSalarioLiquido(new BigDecimal(1000.00), new BigDecimal(8.0)));
		assertEquals(new BigDecimal(900.00).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getSalarioLiquido(new BigDecimal(1000.00), new BigDecimal(10.0)));
		assertNotEquals(new BigDecimal(100.00).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getSalarioLiquido(new BigDecimal(1000.00), new BigDecimal(8.0)));
	}

	@Test
	public void deveDispararExcecaoSeAlgumArgumentoIgualNullAoCalcularSalarioLiquido() {
		exceptionRule.expect(IllegalArgumentException.class);
		CalculadoraSalario calculadora = new CalculadoraSalario();
		calculadora.getSalarioLiquido(null, null);
	}

	@Test
	public void deveDispararExcecaoSeArgumentoSalarioBrutoIgualNullAoCalcularSalarioLiquido() {
		exceptionRule.expect(IllegalArgumentException.class);
		CalculadoraSalario calculadora = new CalculadoraSalario();
		calculadora.getSalarioLiquido(null, new BigDecimal(10.0));
	}

	@Test
	public void deveRetornarOValorDoDescontoDoInssDeAcordoComATabelaDeImposto() {
		CalculadoraSalario calculadora = new CalculadoraSalario();
		assertNotNull("O método não deve retonar null",
				calculadora.getValorINSS(new BigDecimal(1000.00).setScale(2, BigDecimal.ROUND_HALF_UP)));
		assertEquals(new BigDecimal(80.00).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(1000.00).setScale(2, BigDecimal.ROUND_HALF_UP)));
		assertEquals(new BigDecimal(135.50).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(1693.72).setScale(2, BigDecimal.ROUND_HALF_UP)));

		assertEquals(new BigDecimal(152.44).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(1693.73).setScale(2, BigDecimal.ROUND_HALF_UP)));
		assertEquals(new BigDecimal(180.00).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(2000.00).setScale(2, BigDecimal.ROUND_HALF_UP)));
		assertEquals(new BigDecimal(254.06).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(2822.90).setScale(2, BigDecimal.ROUND_HALF_UP)));

		assertEquals(new BigDecimal(310.52).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(2822.91).setScale(2, BigDecimal.ROUND_HALF_UP)));
		assertEquals(new BigDecimal(330.00).setScale(2, BigDecimal.ROUND_HALF_UP),
				calculadora.getValorINSS(new BigDecimal(3000.00).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}

	@Test
	public void deveDispararExcecaoSeArgumentoIgualNullAoCalcularValorINSS() {
		exceptionRule.expect(IllegalArgumentException.class);
		CalculadoraSalario calculadora = new CalculadoraSalario();
		calculadora.getValorINSS(null);
	}

	@Test
	public void deveRetornarOValorDoPlanoDeSaudePorIdade() {
		CalculadoraSalario calculadora = new CalculadoraSalario();
		assertNotNull("O método não deve retonar null", calculadora.getValorPlanoDeSaude(50));

		
		for (int i = 0; i < 70; i++) {
			assertEquals(getPrecoPlanoSaudePorIdade(i), calculadora.getValorPlanoDeSaude(i));
		}
	}

	private BigDecimal getPrecoPlanoSaudePorIdade(Integer idade) {
		if (idade < 0)
			return new BigDecimal(0.0);

		return idade > 60 ? rangePlanoSaude.get(60) : rangePlanoSaude.get(idade);
	}
}
