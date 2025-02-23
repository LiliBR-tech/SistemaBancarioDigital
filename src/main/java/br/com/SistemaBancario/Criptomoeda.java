package br.com.SistemaBancario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Criptomoeda {
    private String nome;
    private String codigo;
    private double valor;
    private double saldo;

    // Construtor com três parâmetros
    public Criptomoeda(String nome, String codigo, double valor) {
        // Validação para garantir que os parâmetros não sejam nulos ou vazios
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da criptomoeda não pode ser vazio.");
        }
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("O código da criptomoeda não pode ser vazio.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da criptomoeda deve ser maior que zero.");
        }

        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.saldo = 0.0;
    }

    // Métodos Getter e Setter
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para comprar criptomoeda
    public void comprar(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade para compra deve ser maior que zero.");
        } else {
            saldo += quantidade;
            System.out.println("Compra realizada: " + quantidade + " de " + nome + " adquiridos.");
        }
    }

    // Método para vender criptomoeda
    public void vender(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade para venda deve ser maior que zero.");
        } else if (quantidade > saldo) {
            System.out.println("Erro: Quantidade de " + nome + " a ser vendida excede o saldo disponível.");
        } else {
            saldo -= quantidade;
            System.out.println("Venda realizada: " + quantidade + " de " + nome + " vendidos.");
        }
    }

    // Método para converter a criptomoeda em valor de mercado
    public double converterParaMoeda(double quantidade) {
        if (quantidade > 0 && quantidade <= saldo) {
            double valorConversao = quantidade * valor;
            // Garantir precisão de 2 casas decimais utilizando BigDecimal
            BigDecimal bd = new BigDecimal(valorConversao).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } else {
            System.out.println("Erro: Quantidade inválida para conversão.");
            return 0.0;
        }
    }

    // Método para depuração
    @Override
    public String toString() {
        return "Criptomoeda{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", valor=" + valor +
                ", saldo=" + saldo +
                '}';
    }
}