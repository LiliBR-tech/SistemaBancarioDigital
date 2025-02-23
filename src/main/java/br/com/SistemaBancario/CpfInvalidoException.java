package br.com.SistemaBancario;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String mensagem) {
        super(mensagem);
    }
}