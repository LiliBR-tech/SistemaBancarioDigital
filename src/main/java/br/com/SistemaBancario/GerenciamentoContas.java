package br.com.SistemaBancario;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class GerenciamentoContas {
    private Map<String, Conta> contas = new HashMap<>();
    private static final Pattern NUMERO_CONTA_PATTERN = Pattern.compile("\\d{5}-\\d");

    // Adiciona uma nova conta após validar o número da conta
    public boolean adicionarConta(Conta conta) {
        if (!validarNumeroConta(conta.getNumero())) {
            System.out.println("Número de conta inválido: " + conta.getNumero());
            return false;
        }
        if (contas.containsKey(conta.getNumero())) {
            System.out.println("Conta com número " + conta.getNumero() + " já existe.");
            return false;
        }
        contas.put(conta.getNumero(), conta);
        System.out.println("Conta " + conta.getNumero() + " adicionada com sucesso.");
        return true;
    }

    // Busca uma conta pelo número, retorna um Optional
    public Optional<Conta> buscarConta(String numero) {
        return Optional.ofNullable(contas.get(numero));
    }

    // Remove uma conta, retornando um booleano de sucesso ou falha
    public boolean removerConta(String numero) {
        if (contas.remove(numero) != null) {
            System.out.println("Conta " + numero + " removida com sucesso.");
            return true;
        }
        System.out.println("Conta com número " + numero + " não encontrada.");
        return false;
    }

    // Valida o número da conta com uma expressão regular simples
    private boolean validarNumeroConta(String numero) {
        return NUMERO_CONTA_PATTERN.matcher(numero).matches();
    }
}