package tests.java.br.com.SistemaBancario;

import br.com.SistemaBancario.Criptomoeda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CriptomoedaTest {

    private Criptomoeda bitcoin;

    @BeforeEach
    void setUp() {
        bitcoin = new Criptomoeda("Bitcoin", "BTC", 50000.00);
        bitcoin.comprar(10);  // Vamos garantir que o saldo seja maior que a quantidade a ser convertida
    }

    @Test
    void testGetNome() {
        assertEquals("Bitcoin", bitcoin.getNome());
    }

    @Test
    void testGetCodigo() {
        assertEquals("BTC", bitcoin.getCodigo());
    }

    @Test
    void testSetValor() {
        bitcoin.setValor(55000.00);
        assertEquals(55000.00, bitcoin.getValor());
    }

    @Test
    void testConversao() {
        double quantidade = 2;
        double esperado = 100000.00;
        double resultado = bitcoin.converterParaMoeda(quantidade);
        assertEquals(esperado, resultado, 0.01, "A conversão deve ser correta com precisão de 2 casas decimais");
    }

    @Test
    void testSetValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            bitcoin.setValor(-50000.00);
        }, "Não deveria permitir valores negativos para a criptomoeda");
    }

    @Test
    void testCriptomoedaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Criptomoeda("", "", -1000.00);
        }, "Deveria lançar exceção para criptomoeda com valores inválidos");
    }

    @Test
    void testConversaoComPrecisao() {
        double quantidade = 2.345;  // Quantidade de Bitcoins a ser convertida
        double esperado = 117250.00;  // Valor esperado após conversão com precisão de 2 casas decimais
        double resultado = bitcoin.converterParaMoeda(quantidade);  // Resultado da conversão
        assertEquals(esperado, resultado, 0.01, "A conversão deve ser correta com precisão de 2 casas decimais");
    }
}