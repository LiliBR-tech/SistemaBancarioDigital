package br.com.SistemaBancario;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente titular, double saldo, double limiteChequeEspecial) {
        super(titular, saldo, limiteChequeEspecial, "Corrente");
        // Garantir que o limiteChequeEspecial não seja negativo
        this.limiteChequeEspecial = limiteChequeEspecial < 0 ? 0 : limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        // Verifica se o saldo + limite são suficientes para o saque
        if (verificarSaldoSuficiente(valor)) {
            setSaldo(getSaldo() - valor);  // Atualiza o saldo da conta
            return true;
        }
        System.out.println("Saldo insuficiente ou valor inválido.");
        return false;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "titular=" + getCliente().getNome() +  // Usando o método getCliente para maior clareza
                ", saldo=" + getSaldo() +
                ", limiteChequeEspecial=" + limiteChequeEspecial +
                ", numero=" + getNumero() +  // Inclui o número da conta para mais clareza
                '}';
    }
}