package br.com.SistemaBancario.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.security.SecureRandom;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SecurityUtils {

    private static final String ALGORITHM = "AES";
    private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding"; // Modo CBC com padding PKCS5
    private static final int KEY_SIZE = 128; // Tamanho da chave em bits
    private static final SecureRandom secureRandom = new SecureRandom();

    private static SecretKey secretKey = generateKey();

    // Gerar chave AES
    private static SecretKey generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(KEY_SIZE, secureRandom); // Usando SecureRandom para mais segurança
            return keyGenerator.generateKey();
        } catch (Exception e) {
            throw new SecurityException("Erro ao gerar chave AES", e);
        }
    }

    // Criptografar dado com chave AES e IV
    public static String encrypt(String data) {
        try {
            // Gerar vetor de inicialização (IV) aleatório
            byte[] iv = new byte[16]; // 16 bytes para AES CBC
            secureRandom.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Inicializar o Cipher
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            // Criptografar os dados
            byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));

            // Concatenar IV e os dados criptografados
            byte[] encryptedWithIv = new byte[iv.length + encryptedBytes.length];
            System.arraycopy(iv, 0, encryptedWithIv, 0, iv.length);
            System.arraycopy(encryptedBytes, 0, encryptedWithIv, iv.length, encryptedBytes.length);

            return Base64.getEncoder().encodeToString(encryptedWithIv); // Retornar em Base64 para facilitar armazenamento/transporte
        } catch (Exception e) {
            throw new SecurityException("Erro ao criptografar", e);
        }
    }

    // Descriptografar dado com chave AES e IV
    public static String decrypt(String encryptedData) {
        try {
            byte[] encryptedWithIv = Base64.getDecoder().decode(encryptedData);

            // Extrair IV e os dados criptografados
            byte[] iv = new byte[16];
            System.arraycopy(encryptedWithIv, 0, iv, 0, iv.length);
            byte[] encryptedBytes = new byte[encryptedWithIv.length - iv.length];
            System.arraycopy(encryptedWithIv, iv.length, encryptedBytes, 0, encryptedBytes.length);

            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Inicializar o Cipher para descriptografar
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            // Descriptografar os dados
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            throw new SecurityException("Erro ao descriptografar", e);
        }
    }
}