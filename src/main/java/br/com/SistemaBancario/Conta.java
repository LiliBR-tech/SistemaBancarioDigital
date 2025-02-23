package br.com.SistemaBancario;

public class Conta {
    protected Cliente cliente;
    protected double saldo;
    protected double limite;
    protected String tipo;
    private String numero; // Número da conta

    public Conta(Cliente cliente, double saldoInicial, double limite, String tipo) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.cliente = cliente;
        this.saldo = saldoInicial;
        this.limite = Math.max(0, limite); // Evita limite negativo
        this.tipo = tipo;
        this.numero = "Conta" + Math.random();  // Gerando um número aleatório para a conta
    }

    public String getNumero() {
        return numero;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    protected boolean verificarSaldoSuficiente(double valor) {
        return valor > 0 && valor <= saldo + limite;
    }

    public boolean sacar(double valor) {
        if (verificarSaldoSuficiente(valor)) {
            saldo -= valor;
            return true;
        }
        System.out.println("Saldo insuficiente ou valor inválido.");
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (destino == this) {
            System.out.println("Não é possível transferir para a mesma conta.");
            return false;
        }
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) { // Protegido para evitar manipulação externa
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void aplicarRendimento(double porcentagem) {
        if (porcentagem > 0) {
            saldo += saldo * (porcentagem / 100);
        } else {
            System.out.println("Porcentagem inválida.");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + (cliente != null ? cliente.getNome() : "Desconhecido") +
                ", saldo=" + saldo +
                ", limite=" + limite +
                ", tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conta conta = (Conta) obj;
        return cliente != null && conta.cliente != null &&
               cliente.getUsuario().equals(conta.cliente.getUsuario()) &&
               tipo.equals(conta.tipo);
    }

    @Override
    public int hashCode() {
        return (cliente != null ? cliente.getUsuario() + tipo : tipo).hashCode();
    }

    public Cliente getCliente() {
        return cliente;
    }
}