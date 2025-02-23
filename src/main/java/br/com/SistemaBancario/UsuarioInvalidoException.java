package br.com.SistemaBancario;

public class UsuarioInvalidoException extends RuntimeException {
    public UsuarioInvalidoException(String mensagem) {
        super(mensagem);
    }
}