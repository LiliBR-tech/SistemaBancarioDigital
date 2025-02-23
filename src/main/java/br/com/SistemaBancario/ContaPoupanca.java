package br.com.SistemaBancario;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente titular, double saldoInicial) {
        // Poupança não tem limite, então passamos 0 para o limite
        super(titular, saldoInicial, 0, "Poupança");
    }

    @Override
    public boolean sacar(double valor) {
        // Poupança não tem limite, portanto, só verifica o saldo
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficiente ou valor inválido.");
        return false;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "titular=" + getCliente().getNome() +
                ", saldo=" + getSaldo() +
                ", numero=" + getNumero() +  // Inclui o número da conta
                '}';
    }
}