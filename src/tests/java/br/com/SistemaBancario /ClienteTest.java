package tests.java.br.com.SistemaBancario;

import br.com.SistemaBancario.Cliente;
import br.com.SistemaBancario.Cliente.CpfInvalidoException;
import br.com.SistemaBancario.Cliente.UsuarioInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

   private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("João Silva", "12345678901", "joao123", "senha123");
    }

    @Test
    void testGetCpf() {
        assertEquals("12345678901", cliente.getCpf());
    }

    @Test
    void testGetNome() {
        assertEquals("João Silva", cliente.getNome());
    }

    @Test
    void testGetUsuario() {
        assertEquals("joao123", cliente.getUsuario());
    }

    @Test
    void testSetNome() {
        cliente.setNome("Carlos Souza");
        assertEquals("Carlos Souza", cliente.getNome());
    }

    @Test
    void testSetUsuario() {
        cliente.setUsuario("carlos123");
        assertEquals("carlos123", cliente.getUsuario());
    }

    @Test
    void testSenhaCriptografada() {
        String senhaCriptografada = cliente.getSenha();
        assertNotEquals("senha123", senhaCriptografada, "A senha não deve ser armazenada em texto puro!");
        assertTrue(senhaCriptografada.length() > 0, "A senha criptografada não pode ser vazia!");
    }

    @Test
    void testCpfInvalido() {
        assertThrows(CpfInvalidoException.class, () -> {
            new Cliente("João Silva", "123", "joao123", "senha123");
        }, "Deveria lançar exceção para CPF inválido");
    }

    @Test
    void testUsuarioInvalido() {
        assertThrows(UsuarioInvalidoException.class, () -> {
            new Cliente("João Silva", "12345678901", "", "senha123");
        }, "Deveria lançar exceção para usuário inválido");
    }

    @Test
    void testSenhaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("João Silva", "12345678901", "joao123", "");
        }, "Deveria lançar exceção para senha inválida");
    }

    @Test
    void testNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("", "12345678901", "joao123", "senha123");
        }, "Deveria lançar exceção para nome inválido");
    }
}