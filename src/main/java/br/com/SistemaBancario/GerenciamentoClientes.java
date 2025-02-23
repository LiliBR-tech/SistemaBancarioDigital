package br.com.SistemaBancario;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class GerenciamentoClientes {
    private Map<String, Cliente> clientes = new HashMap<>();
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    // Adiciona um novo cliente após validar o CPF
    public boolean adicionarCliente(Cliente cliente) {
        if (!validarCpf(cliente.getCpf())) {
            System.out.println("CPF inválido: " + cliente.getCpf());
            return false;
        }
        if (clientes.containsKey(cliente.getCpf())) {
            System.out.println("Cliente com CPF " + cliente.getCpf() + " já existe.");
            return false;
        }
        clientes.put(cliente.getCpf(), cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso.");
        return true;
    }

    // Busca cliente pelo CPF, retorna um Optional
    public Optional<Cliente> buscarCliente(String cpf) {
        return Optional.ofNullable(clientes.get(cpf));
    }

    // Remove um cliente, retornando um booleano de sucesso ou falha
    public boolean removerCliente(String cpf) {
        if (clientes.remove(cpf) != null) {
            System.out.println("Cliente com CPF " + cpf + " removido com sucesso.");
            return true;
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return false;
    }

    // Valida o CPF com uma expressão regular simples (pode ser melhorada)
    private boolean validarCpf(String cpf) {
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            return false;
        }
        // Validação adicional do CPF (cálculo dos dígitos verificadores)
        return validarDigitosCpf(cpf);
    }

    // Método auxiliar para validar os dígitos verificadores do CPF
    private boolean validarDigitosCpf(String cpf) {
        // Remove os pontos e hífens para pegar apenas os números
        String numeros = cpf.replaceAll("[^\\d]", "");
        if (numeros.length() != 11) {
            return false;
        }

        // Validação dos dois dígitos verificadores do CPF
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += (10 - i) * (numeros.charAt(i) - '0');
        }
        int digito1 = (soma1 * 10) % 11;
        if (digito1 == 10) digito1 = 0;

        int soma2 = 0;
        for (int i = 0; i < 9; i++) {
            soma2 += (11 - i) * (numeros.charAt(i) - '0');
        }
        soma2 += 2 * digito1;
        int digito2 = (soma2 * 10) % 11;
        if (digito2 == 10) digito2 = 0;

        return digito1 == (numeros.charAt(9) - '0') && digito2 == (numeros.charAt(10) - '0');
    }
}