package br.com.SistemaBancario;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GerenciamentoCriptomoedas {
    private Map<String, Double> criptomoedas;

    public GerenciamentoCriptomoedas() {
        this.criptomoedas = new HashMap<>();
    }

    // Adiciona uma criptomoeda com a cotação
    public boolean adicionarCriptomoeda(String nome, double cotacao) {
        if (cotacao < 0) {
            System.out.println("A cotação não pode ser negativa.");
            return false;
        }
        if (criptomoedas.containsKey(nome)) {
            System.out.println("Criptomoeda " + nome + " já existe.");
            return false;
        }
        criptomoedas.put(nome, cotacao);
        System.out.println("Criptomoeda " + nome + " adicionada com cotação " + cotacao + ".");
        return true;
    }

    // Retorna a cotação de uma criptomoeda, se existente
    public Optional<Double> obterCotacao(String nome) {
        Optional<Double> cotacao = Optional.ofNullable(criptomoedas.get(nome));
        cotacao.ifPresentOrElse(
            valor -> System.out.println("Cotação de " + nome + ": " + valor),
            () -> System.out.println("Criptomoeda " + nome + " não encontrada.")
        );
        return cotacao;
    }

    // Atualiza a cotação de uma criptomoeda
    public boolean atualizarCotacao(String nome, double novaCotacao) {
        if (novaCotacao < 0) {
            System.out.println("A cotação não pode ser negativa.");
            return false;
        }
        if (criptomoedas.containsKey(nome)) {
            criptomoedas.put(nome, novaCotacao);
            System.out.println("Cotação de " + nome + " atualizada para " + novaCotacao + ".");
            return true;
        }
        System.out.println("Criptomoeda " + nome + " não encontrada.");
        return false;
    }

    // Remove uma criptomoeda
    public boolean removerCriptomoeda(String nome) {
        if (criptomoedas.remove(nome) != null) {
            System.out.println("Criptomoeda " + nome + " removida com sucesso.");
            return true;
        }
        System.out.println("Criptomoeda " + nome + " não encontrada.");
        return false;
    }

    // Lista todas as criptomoedas e suas cotações
    public void listarCriptomoedas() {
        if (criptomoedas.isEmpty()) {
            System.out.println("Nenhuma criptomoeda cadastrada.");
        } else {
            System.out.println("Criptomoedas disponíveis:");
            criptomoedas.forEach((nome, cotacao) -> System.out.println(nome + ": " + cotacao));
        }
    }
}