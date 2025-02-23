package br.com.SistemaBancario.utils;

import br.com.SistemaBancario.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    private static final String FILE_PATH = "data/clientes.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    // Lê a lista de clientes a partir do arquivo JSON
    public static List<Cliente> lerClientes() throws IOException {
        File file = new File(FILE_PATH);
        
        // Verifica se o arquivo existe
        if (!file.exists()) {
            throw new IOException("Arquivo clientes.json não encontrado!");
        }

        // Lê os dados do arquivo JSON e converte para a lista de clientes
        return mapper.readValue(file, new TypeReference<List<Cliente>>() {});
    }

    // Salva a lista de clientes no arquivo JSON
    public static void salvarClientes(List<Cliente> clientes) throws IOException {
        // Verifica e cria o diretório caso não exista
        File file = new File(FILE_PATH);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        // Grava a lista de clientes no arquivo JSON com formatação
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, clientes);
    }

    // Método genérico para ler qualquer tipo de objeto de um arquivo JSON
    public static <T> T lerObjeto(String caminhoArquivo, Class<T> tipoClasse) throws IOException {
        File file = new File(caminhoArquivo);
        if (!file.exists()) {
            throw new IOException("Arquivo " + caminhoArquivo + " não encontrado!");
        }
        return mapper.readValue(file, tipoClasse);
    }

    // Método genérico para salvar qualquer tipo de objeto em um arquivo JSON
    public static <T> void salvarObjeto(String caminhoArquivo, T objeto) throws IOException {
        File file = new File(caminhoArquivo);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, objeto);
    }
}