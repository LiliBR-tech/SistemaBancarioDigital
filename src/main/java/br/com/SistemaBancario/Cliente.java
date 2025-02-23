package br.com.SistemaBancario;

public class Cliente {

    private String nome;
    private String cpf;
    private String usuario;
    private String senha;

    // Exceções personalizadas
    public static class CpfInvalidoException extends RuntimeException {
        public CpfInvalidoException(String message) {
            super(message);
        }
    }

    public static class UsuarioInvalidoException extends RuntimeException {
        public UsuarioInvalidoException(String message) {
            super(message);
        }
    }

    public Cliente(String nome, String cpf, String usuario, String senha) {
        setNome(nome);
        setCpf(cpf);
        setUsuario(usuario);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().length() != 11 || !cpf.matches("\\d+")) {
            throw new CpfInvalidoException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new UsuarioInvalidoException("Usuário inválido");
        }
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha inválida");
        }
        this.senha = "SenhaCriptografada"; // Lógica de criptografia pode ser aplicada aqui
    }
}